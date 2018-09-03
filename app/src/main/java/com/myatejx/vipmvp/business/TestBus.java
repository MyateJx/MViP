package com.myatejx.vipmvp.business;

import com.myatejx.architecture.business.bus.BaseBus;

/**
 * @author xmj
 * @date 2018/9/3
 */
public class TestBus extends BaseBus<ITestRequest> {

    private static TestBus sInstance;

    public static TestBus getInstance() {
        if (sInstance == null) {
            sInstance = new TestBus();
        }
        return sInstance;
    }

    private TestBus() {
    }


}
