package com.myatejx.architecture.business.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BaseBus<Q extends IRequest> {

    private static BaseBus sInstance;

    public static BaseBus io() {
        if (sInstance == null) {
            sInstance = new BaseBus();
        }
        return sInstance;
    }

    protected BaseBus() {
    }

    private Q mIRequest;
    private List<IResponse> mIResponses = new ArrayList<>();

    public void registerRequestHandler(Q request) {
        if (request != null) {
            mIRequest = request;
        }
    }

    public void unregisterRequestHandler() {
        if (mIRequest != null) {
            mIRequest.clear();
            mIRequest = null;
        }
    }

    public void registerResponseObserver(IResponse response) {
        if (response != null && !mIResponses.contains(response)) {
            mIResponses.add(response);
        }
    }

    public void unregisterResponseObserver(IResponse response) {
        if (response != null && mIResponses.contains(response)) {
            mIResponses.remove(response);
        }
    }

    public void clearAllRegister() {
        unregisterRequestHandler();
        mIResponses.clear();
    }

    public Q request() {
        if (mIRequest == null) {
            throw new RuntimeException("please register request handler before request");
        }
        return mIRequest;
    }

    public void response(Result result) {
        if (mIResponses != null && mIResponses.size() > 0) {
            for (IResponse response : mIResponses) {
                response.onResult(result);
            }
        }
    }

}
