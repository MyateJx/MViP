package com.myatejx.architecture.business.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BaseBus {

    private static IRequest sIRequest;
    private static List<IResponse> sIResponses = new ArrayList<>();

    public static void registerResponse(IResponse iResponse) {
        if (!sIResponses.contains(iResponse)) {
            sIResponses.add(iResponse);
        }
    }

    public static void unregisterResponse(IResponse iResponse) {
        if (sIResponses.contains(iResponse)) {
            sIResponses.remove(iResponse);
        }
    }

    public static void onResult(Result testResult) {
        for (IResponse iResponse : sIResponses) {
            iResponse.onResult(testResult);
        }
    }

    public static void unregisterAllResponses() {
        sIResponses.clear();
    }

    public static void registerIRequest(IRequest iRequest) {
        sIRequest = iRequest;
    }

    public static void unregisterIRequest() {
        sIRequest = null;
    }

    protected static IRequest getIRequest() {
        return sIRequest;
    }

}
