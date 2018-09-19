package com.myatejx.vipmvp.business;

import android.graphics.drawable.Drawable;

import com.myatejx.architecture.business.BasePresenter;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.business.bus.IMapRequest;
import com.myatejx.vipmvp.business.bus.NoteBus;

import java.io.IOException;

import io.reactivex.ObservableEmitter;

/**
 * @author xmj
 * @date 2018/9/19
 */
public class MapBusiness extends BasePresenter<NoteBus> implements IMapRequest {


    @Override
    public void locate(int x, int y) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }

    @Override
    public void mark(int x, int y, Drawable drawable, String text) {
        handleRequest(new IAsync() {
            @Override
            public Result onExecute(ObservableEmitter<Result> e) throws IOException {
                return null;
            }
        });
    }
}
