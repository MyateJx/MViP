package com.myatejx.vipmvp.business;

import com.myatejx.architecture.business.bus.BaseBus;

/**
 * @author KunMinX
 * @date 2018/8/27
 */
public class TestBus extends BaseBus {

    public static void requestBean() {
        if (getIRequest() != null) {
            ((ITestRequest) getIRequest()).requestBean();
        }
    }

    public static void requestBeans() {
        if (getIRequest() != null) {
            ((ITestRequest) getIRequest()).requestBeans();
        }
    }
}
