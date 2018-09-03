package com.myatejx.architecture.test;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.IResponse;

/**
 * author：xmj
 * Create at 2018/9/3
 */
public class VipMVP extends BaseBus{

    private static VipMVP sInstance;

    public static VipMVP getInstance() {
        if (sInstance == null) {
            sInstance = new VipMVP();
        }
        return sInstance;
    }

    private VipMVP() {
    }

    public IDbRequest DbRequest;

    public INetRequest NetRequest;

    public IResponse Response;
}
