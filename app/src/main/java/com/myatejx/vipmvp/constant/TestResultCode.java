package com.myatejx.vipmvp.constant;

import com.myatejx.architecture.business.bus.BaseResultCode;

/**
 * @author KunMinX
 * @date 2018/8/28
 */
public class TestResultCode extends BaseResultCode {

    public static final int FAILURE = 0x0001;
    public static final int CANCELED = 0x0002;
    public static final int GOT_LIST = 0x0004;
    public static final int GOT_ENTITY = 0x0008;
    public static final int INSERTED = 0x0010;
    public static final int UPDATED = 0x0020;
    public static final int DELETED = 0x0040;

}
