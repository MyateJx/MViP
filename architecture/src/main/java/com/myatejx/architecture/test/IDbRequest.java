package com.myatejx.architecture.test;

/**
 * author：xmj
 * Create at 2018/9/4
 */
public interface IDbRequest {

    void queryList();

    void queryEntity();

    void insertEntity();

    void updateEntity();

    void deleteEntity();
}
