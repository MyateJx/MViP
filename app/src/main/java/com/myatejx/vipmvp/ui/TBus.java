package com.myatejx.vipmvp.ui;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.vipmvp.test.IDbRequest;
import com.myatejx.vipmvp.test.INetRequest;

/**
 * author：xmj
 * Create at 2018/9/18
 */
public class TBus extends BaseBus {

    public static INetRequest net() {
        return (INetRequest) getRequest(INetRequest.class);
    }

    public static IDbRequest db() {
        return (IDbRequest) getRequest(IDbRequest.class);
    }


}
