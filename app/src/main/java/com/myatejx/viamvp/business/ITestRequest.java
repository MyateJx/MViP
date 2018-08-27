package com.myatejx.viamvp.business;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * @author KunMinX
 * @date 2018/8/27
 */
public interface ITestRequest extends IRequest {

    void requestBean();

    void requestBeans();
}
