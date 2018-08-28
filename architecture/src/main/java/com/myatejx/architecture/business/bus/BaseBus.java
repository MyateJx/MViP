package com.myatejx.architecture.business.bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BaseBus {

    private static HashMap<BusinessType, IRequest> sRequestMap = new HashMap<>();
    private static HashMap<BusinessType, List<IResponse>> sResponseMap = new HashMap<>();

    public static void registerRequestHandle(BusinessType requestType, IRequest request) {
        if (requestType != null && request != null && sRequestMap.get(requestType) == null) {
            sRequestMap.put(requestType, request);
        }
    }

    public static void unregisterRequestHandle(BusinessType requestType) {
        if (requestType != null && sRequestMap.get(requestType) != null) {
            sRequestMap.remove(requestType);
        }
    }

    public static void registerResponseObserve(BusinessType requestType, IResponse response) {
        if (response != null && requestType != null) {
            if (sResponseMap.get(requestType) == null) {
                List<IResponse> responses = new ArrayList<>();
                responses.add(response);
                sResponseMap.put(requestType, responses);
            } else {
                sResponseMap.get(requestType).add(response);
            }
        }
    }

    public static void unregisterResponseObserve(BusinessType requestType, IResponse response) {
        if (response != null && requestType != null && sResponseMap.get(requestType) != null) {
            if (sResponseMap.get(requestType).contains(response)) {
                sResponseMap.get(requestType).remove(response);
            }
        }
    }

    public static void clearAllRegister() {
        sRequestMap.clear();
        sResponseMap.clear();
    }

    public static IRequest request(BusinessType requestType) {
        return sRequestMap.get(requestType);
    }

    public static void response(BusinessType requestType, Result result) {
        List<IResponse> responseList = sResponseMap.get(requestType);
        if (responseList != null && responseList.size() > 0) {
            for (IResponse response : responseList) {
                response.onResult(result);
            }
        }
    }

}
