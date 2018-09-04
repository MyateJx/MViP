package com.myatejx.architecture.business.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public abstract class BaseBus<Q extends IRequest> {

    protected Q mIRequest;
    protected List<IResponse> mIResponses = new ArrayList<>();

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

    public abstract Q request();

    public void response(Result result) {
        if (mIResponses != null && mIResponses.size() > 0) {
            for (IResponse response : mIResponses) {
                response.onResult(result);
            }
        }
    }

}
