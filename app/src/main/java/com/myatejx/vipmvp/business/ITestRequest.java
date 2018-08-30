package com.myatejx.vipmvp.business;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * @author KunMinX
 * @date 2018/8/27
 */
public interface ITestRequest extends IRequest {

    void requestEntity();

    void requestList();

    void requestInsert();

    void requestInserts();

    void requestUpdate();

    void requestUpdates();

    void requestDelete();

    void requestDeletes();

}
