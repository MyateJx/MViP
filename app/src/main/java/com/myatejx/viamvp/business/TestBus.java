package com.myatejx.viamvp.business;

import com.myatejx.architecture.business.bus.BaseBus;

/**
 * @author KunMinX
 * @date 2018/8/27
 */
public class TestBus extends BaseBus {

    private static ITestRequest sIRequest;

    public static void registerIRequest(ITestRequest iRequest) {
        sIRequest = iRequest;
    }

    public static void requestBean() {
        if (sIRequest != null) {
            sIRequest.requestBean();
        }
    }

    public static void requestBeans() {
        if (sIRequest != null) {
            sIRequest.requestBeans();
        }
    }
}
