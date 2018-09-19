package com.myatejx.vipmvp.business.bus;

import com.myatejx.architecture.business.bus.IRequest;
import com.myatejx.vipmvp.bean.NoteBean;

/**
 * @author xmj
 * @date 2018/9/19
 */
public interface INoteRequest extends IRequest{

    void queryList();

    void queryEntity(long id);

    void insert(NoteBean bean);

    void update(NoteBean bean);

    void delete(NoteBean bean);
}
