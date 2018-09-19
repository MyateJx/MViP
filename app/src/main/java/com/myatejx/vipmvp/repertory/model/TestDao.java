package com.myatejx.vipmvp.repertory.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.myatejx.vipmvp.bean.NoteBean;

import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
@Dao
public interface TestDao {

    @Query("SELECT * FROM NoteBean")
    List<NoteBean> getBeans();

    @Query("SELECT * FROM NoteBean WHERE id=:id")
    NoteBean getBean(int id);



}
