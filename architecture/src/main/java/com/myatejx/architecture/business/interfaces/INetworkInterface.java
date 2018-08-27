package com.myatejx.architecture.business.interfaces;

import android.content.Context;

import java.io.IOException;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public interface INetworkInterface<T> {

    void init(Context context);

    String listSupportMethods();

    //TODO 需要配一个目录用的实体类，可以设置每个对象的类型、名称、大小等信息
    String listFiles(String dirName) throws IOException;

    boolean isExistFile(String fileName) throws IOException;

    boolean downloadFile(String fileName);

    //TODO 下载多文件，其自身应该包含ui回调的操作，不能是多次请求
    boolean downloadFiles(List<String> filesName);

    String getStringFromNetFile(String fileName) throws IOException;

    boolean uploadFile(String fileName) throws IOException;

    boolean uploadString(String fileName, String content) throws IOException;

    //TODO
    boolean uploadFiles(List<String> filesName);

    List<T> jsonToList(String json);

    String listToJson(List<T> list);

}
