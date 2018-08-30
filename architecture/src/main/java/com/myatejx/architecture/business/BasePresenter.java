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
                        Result result = new Result(ResultCode.FAILURE, e.toString());
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
