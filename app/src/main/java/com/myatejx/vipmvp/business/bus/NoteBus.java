package com.myatejx.vipmvp.business.bus;

import com.myatejx.architecture.business.bus.BaseBus;

/**
 * author：xmj
 * Create at 2018/9/18
 */
public class NoteBus extends BaseBus {

    public static INoteRequest note() {
        return (INoteRequest) getRequest(INoteRequest.class);
    }

    public static IMapRequest map() {
        return (IMapRequest) getRequest(IMapRequest.class);
    }

    public static IUserRequest user() {
        return (IUserRequest) getRequest(IUserRequest.class);
    }
}
