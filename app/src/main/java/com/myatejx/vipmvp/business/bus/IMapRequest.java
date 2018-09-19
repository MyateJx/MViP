package com.myatejx.vipmvp.business.bus;

import android.graphics.drawable.Drawable;

import com.myatejx.architecture.business.bus.IRequest;

/**
 * @author xmj
 * @date 2018/9/19
 */
public interface IMapRequest extends IRequest {

    void locate(int x, int y);

    void mark(int x, int y, Drawable drawable, String text);

}
