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

public class BasePresenter {

    public void handleRequest(final String businessType, final int resultCode, final IAsync iAsnycTask) {
        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> e) {
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
                .subscribe(new Observer<Object>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Object value) {
                        Result result = new Result(resultCode, value);
                        BaseBus.response(businessType, result);
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
        Object onExecute(ObservableEmitter<Object> e) throws IOException;
    }

}
