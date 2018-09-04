package com.myatejx.vipmvp.test;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.vipmvp.business.ITestRequest;
import com.myatejx.vipmvp.business.TestBus;

/**
 * @author xmj
 * @date 2018/9/4
 */
public class TestUI {

    public void test() {
//        VipMap.io().testBus().request().requestList();
//        VipMap.io().testBus().response(new Result(0, null));
//        VipMap.io().dbBus().request().insertEntity();
        TestBus.io().request().requestList();
//        TestBus.io().registerResponseObserver(this);
//        TestBus.io().registerRequestHandler(new TestPresenter());
        ITestRequest iTestRequest = (ITestRequest) BaseBus.io().request();
        iTestRequest.requestList();

        ViaBus.of(iTestRequest).request().clear();
    }
}
