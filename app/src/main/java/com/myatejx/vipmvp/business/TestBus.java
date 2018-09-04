package com.myatejx.vipmvp.business;

import com.myatejx.architecture.business.bus.BaseBus;

/**
 * @author xmj
 * @date 2018/9/3
 */
public class TestBus extends BaseBus<ITestRequest> {

    private static TestBus sInstance;

    public static TestBus io() {
        if (sInstance == null) {
            sInstance = new TestBus();
        }
        return sInstance;
    }

    private TestBus() {
    }

    @Override
    public ITestRequest request() {
        if (mIRequest == null) {
            throw new RuntimeException("please register request handler before request");
        }
        return mIRequest;
    }

}
