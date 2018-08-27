package com.myatejx.viamvp.repertory.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.myatejx.viamvp.bean.TestBean;

import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
@Dao
public interface TestDao {

    @Query("SELECT * FROM TestBean")
    List<TestBean> getBeans();

    @Query("SELECT * FROM TestBean WHERE id=:id")
    TestBean getBean(int id);
}
