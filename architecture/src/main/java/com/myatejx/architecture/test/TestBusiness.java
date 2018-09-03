package com.myatejx.architecture.test;

import com.myatejx.architecture.utils.RxUtils;

import java.io.IOException;

import io.reactivex.ObservableEmitter;

/**
 * author：xmj
 * Create at 2018/9/4
 */
public class TestBusiness {

    public void testBusiness() {
        RxUtils.getInstance().executeAsnycTask(new RxUtils.IAsnycTask() {
            @Override
            public Object[] onExecute(ObservableEmitter<Object[]> e) throws IOException {
                return new Object[0];
            }

            @Override
            public void onResult(Throwable throwable, Object[] o) {
                VipMVP.getInstance().Response().onResult(null);
            }
        });
    }
}
