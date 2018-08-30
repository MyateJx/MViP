package com.myatejx.vipmvp.business;

import android.content.Context;

import com.myatejx.architecture.business.BasePresenter;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.business.constant.BusinessType;
import com.myatejx.vipmvp.business.constant.TestResultCode;
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
        handleRequest(BusinessType.DIARY.name(), new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return new Result(TestResultCode.GOT_ENTITY, null);
            }
        });
    }

    @Override
    public void requestBeans() {
        handleRequest(BusinessType.DIARY.name(), new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return new Result(TestResultCode.GOT_LIST, null);
            }
        });
    }
}
