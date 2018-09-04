package com.myatejx.vipmvp.test;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * author：xmj
 * Create at 2018/9/4
 */
public interface IDbRequest extends IRequest {

    void queryList();

    void queryEntity();

    void insertEntity();

    void updateEntity();

    void deleteEntity();
}
