package com.myatejx.vipmvp.business;

import android.content.Context;

import com.myatejx.architecture.business.BasePresenter;
import com.myatejx.architecture.business.bus.BusinessType;
import com.myatejx.vipmvp.constant.TestResultCode;
import com.myatejx.vipmvp.repertory.DataBaseAdapter;
import com.myatejx.vipmvp.repertory.IDataBaseInterface;

import java.io.IOException;

import io.reactivex.ObservableEmitter;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class TestPresenter extends BasePresenter implements ITestRequest {

    private IDataBaseInterface mDataBase;

    public void init(Context context) {
        mDataBase = new DataBaseAdapter();
        mDataBase.init(context);
    }

    @Override
    public void requestBean() {
        handleRequest(BusinessType.DIARY, TestResultCode.GOT_ENTITY, new IAsync() {
            @Override
            public Object onExecute(ObservableEmitter<Object> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void requestBeans() {
        handleRequest(BusinessType.DIARY, TestResultCode.GOT_LIST, new IAsync() {
            @Override
            public Object onExecute(ObservableEmitter<Object> e) throws IOException {
                return null;
            }
        });
    }
}
