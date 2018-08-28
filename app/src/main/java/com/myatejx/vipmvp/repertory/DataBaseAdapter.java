package com.myatejx.vipmvp.repertory;

import android.content.Context;

import com.myatejx.vipmvp.bean.TestBean;
import com.myatejx.vipmvp.constant.Configs;
import com.myatejx.vipmvp.repertory.model.AppDatabase;

import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class DataBaseAdapter implements IDataBaseInterface<TestBean> {
    @Override
    public void init(Context context) {
        AppDatabase.init(context, Configs.DB_PATH);
    }

    @Override
    public List<TestBean> getList() {
        return AppDatabase.getInstance().testDao().getBeans();
    }

    @Override
    public List<TestBean> getList(String tag, String type) {
        return null;
    }

    @Override
    public TestBean getEntity(String uuid) {
        return AppDatabase.getInstance().testDao().getBean(0);
    }

    @Override
    public long insertEntity(TestBean t) {
        return 0;
    }

    @Override
    public int updateEntity(TestBean t) {
        return 0;
    }

    @Override
    public int deleteEntity(TestBean t) {
        return 0;
    }

    @Override
    public boolean insertEntities(TestBean... ts) {
        return false;
    }

    @Override
    public boolean updateEntities(TestBean... ts) {
        return false;
    }

    @Override
    public boolean deleteEntities(TestBean... ts) {
        return false;
    }

    @Override
    public boolean insertEntities(List<TestBean> ts) {
        return false;
    }

    @Override
    public boolean updateEntities(List<TestBean> ts) {
        return false;
    }

    @Override
    public boolean deleteEntities(List<TestBean> ts) {
        return false;
    }
}
