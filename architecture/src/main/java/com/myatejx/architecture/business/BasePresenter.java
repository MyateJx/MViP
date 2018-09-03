package com.myatejx.architecture.business;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.architecture.business.bus.ResultCode;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BasePresenter {

    private String businessType;

    public String getBusinessType() {
        return businessType;
    }

    protected void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    /**
     * 在onExcute期间，需要回传进度progress等时使用。
     *
     * @param result
     */
    protected void sendMessage(Result result) {
        BaseBus.response(businessType, result);
    }

    protected void handleRequest(IAsync iAsync) {
        handleRequest(businessType, iAsync);
    }

    protected void handleRequest(final String businessType, final IAsync iAsnycTask) {
        Observable.create(new ObservableOnSubscribe<Result>() {
            @Override
            public void subscribe(ObservableEmitter<Result> e) {
                try {
                    if (iAsnycTask != null) {
                        e.onNext(iAsnycTask.onExecute(e));
                    }
                } catch (Exception e1) {
                    e.onError(e1);
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Result>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Result value) {
                        BaseBus.response(businessType, value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Result result = new Result(businessType, ResultCode.FAILURE, e.toString());
                        BaseBus.response(businessType, result);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface IAsync {
        Result onExecute(ObservableEmitter<Result> e) throws IOException;
    }

}
