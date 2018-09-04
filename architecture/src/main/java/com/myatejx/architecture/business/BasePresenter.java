package com.myatejx.architecture.business;

import android.content.Context;

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

    private BaseBus mBaseBus;
    protected Context mContext;

    public BasePresenter(Context context, BaseBus baseBus) {
        this.mContext = context;
        this.mBaseBus = baseBus;
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
     * 处理请求
     *
     * @param iAsync
     */
    protected void handleRequest(final IAsync iAsync) {
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
                        mBaseBus.response(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Result result = new Result(ResultCode.FAILURE, e.toString());
                        mBaseBus.response(result);
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
