package com.myatejx.architecture.business;

import com.myatejx.architecture.business.bus.VipBus;
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

    public BasePresenter(String businessType) {
        this.businessType = businessType;
    }

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
     * @param e
     * @param result
     */
    protected void sendMessage(ObservableEmitter<Result> e, Result result) {
        e.onNext(result);
    }

    /**
     * 进度progress等时使用。
     *
     * @param e
     * @param result
     */
    protected void onProgress(ObservableEmitter<Result> e, Result result) {
        sendMessage(e, result);
    }

    /**
     * 处理请求，一参数版
     *
     * @param iAsync
     */
    protected void handleRequest(IAsync iAsync) {
        handleRequest(businessType, iAsync);
    }

    /**
     * 处理请求，二参数版
     *
     * @param businessType
     * @param iAsync
     */
    protected void handleRequest(final String businessType, final IAsync iAsync) {
        Observable.create(new ObservableOnSubscribe<Result>() {
            @Override
            public void subscribe(ObservableEmitter<Result> e) {
                try {
                    if (iAsync != null) {
                        e.onNext(iAsync.onExecute(e));
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
                        VipBus.response(businessType, value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Result result = new Result(businessType, ResultCode.FAILURE, e.toString());
                        VipBus.response(businessType, result);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public interface IAsync {
        /**
         * 异步执行中
         *
         * @param e
         * @return
         * @throws IOException
         */
        Result onExecute(ObservableEmitter<Result> e) throws IOException;
    }

}
