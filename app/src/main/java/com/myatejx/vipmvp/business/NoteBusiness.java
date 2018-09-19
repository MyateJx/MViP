package com.myatejx.vipmvp.business;

import android.content.Context;

import com.myatejx.architecture.business.BasePresenter;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.bean.NoteBean;
import com.myatejx.vipmvp.business.bus.INoteRequest;
import com.myatejx.vipmvp.business.bus.NoteBus;
import com.myatejx.vipmvp.repertory.DataBaseAdapter;

import java.io.IOException;

import io.reactivex.ObservableEmitter;

/**
 * @author xmj
 * @date 2018/9/19
 */
public class NoteBusiness extends BasePresenter<NoteBus> implements INoteRequest {

    private DataBaseAdapter mDataBase;
    private Context mContext;

    public void init(Context context) {
        mContext = context;
        mDataBase = new DataBaseAdapter();
        mDataBase.init(context);
    }

    @Override
    public void queryList() {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void queryEntity(long id) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void insert(NoteBean bean) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void update(NoteBean bean) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void delete(NoteBean bean) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }
}
