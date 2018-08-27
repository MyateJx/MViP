package com.myatejx.viamvp.business;

import android.content.Context;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.BaseResult;
import com.myatejx.architecture.business.bus.BaseResultCode;
import com.myatejx.architecture.business.interfaces.IDataBaseInterface;
import com.myatejx.architecture.business.interfaces.INetworkInterface;
import com.myatejx.architecture.utils.RxUtils;
import com.myatejx.viamvp.repertory.DataBaseAdapter;
import com.myatejx.viamvp.repertory.NetworkAdapter;

import java.io.IOException;

import io.reactivex.ObservableEmitter;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class TestPresenter implements ITestRequest {

    private IDataBaseInterface mDataBase;
    private INetworkInterface mNetwork;

    public void init(Context context) {
        mDataBase = new DataBaseAdapter();
        mDataBase.init(context);
        mNetwork = new NetworkAdapter();
        mNetwork.init(context);
    }

    @Override
    public void requestBean() {
        RxUtils.getInstance().executeAsnycTask(new RxUtils.IAsnycTask() {
            @Override
            public Object[] onExecute(ObservableEmitter<Object[]> e) throws IOException {
                return new Object[0];
            }

            @Override
            public void onResult(Throwable throwable, Object[] o) {
                BaseResult testResult = new BaseResult(BaseResultCode.GET_BEAN, null);
                BaseBus.onResult(testResult);
            }
        });
    }

    @Override
    public void requestBeans() {
        RxUtils.getInstance().executeAsnycTask(new RxUtils.IAsnycTask() {
            @Override
            public Object[] onExecute(ObservableEmitter<Object[]> e) throws IOException {
                return new Object[0];
            }

            @Override
            public void onResult(Throwable throwable, Object[] o) {
                BaseResult testResult = new BaseResult(BaseResultCode.GET_BEANS, null);
                BaseBus.onResult(testResult);
            }
        });
    }
}
