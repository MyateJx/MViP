package com.myatejx.vipmvp.business;

import android.content.Context;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.architecture.business.interfaces.IDataBaseInterface;
import com.myatejx.architecture.business.interfaces.INetworkInterface;
import com.myatejx.architecture.utils.RxUtils;
import com.myatejx.vipmvp.constant.TestResultCode;
import com.myatejx.vipmvp.repertory.DataBaseAdapter;
import com.myatejx.vipmvp.repertory.NetworkAdapter;

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
                Result testResult = new Result(TestResultCode.CANCELED, null);
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
                Result testResult = new Result(TestResultCode.CANCELED, null);
                BaseBus.onResult(testResult);
            }
        });
    }
}
