package com.myatejx.architecture.business.bus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BaseBus {

    private IRequest mIRequest;
    private List<IResponse> mIResponses = new ArrayList<>();

    public void registerRequestHandle(IRequest request) {
        if (request != null) {
            mIRequest = request;
        }
    }

    public void unregisterRequestHandle() {
        if (mIRequest != null) {
            mIRequest.clear();
            mIRequest = null;
        }
    }

    public void registerResponseObserve(IResponse response) {
        if (response != null && !mIResponses.contains(response)) {
            mIResponses.add(response);
        }
    }

    public void unregisterResponseObserve(IResponse response) {
        if (response != null && mIResponses.contains(response)) {
            mIResponses.remove(response);
        }
    }

    public void clearAllRegister() {
        unregisterRequestHandle();
        mIResponses.clear();
    }

    public IRequest request() {
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
