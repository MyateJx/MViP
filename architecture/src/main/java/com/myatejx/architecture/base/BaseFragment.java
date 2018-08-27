package com.myatejx.architecture.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.BaseResult;
import com.myatejx.architecture.business.bus.IResponse;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class BaseFragment extends SupportFragment implements IResponse {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseBus.registerResponse(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseBus.unregisterResponse(this);
    }

    @Override
    public void onResult(BaseResult testResult) {

    }
}
