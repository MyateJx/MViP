package com.myatejx.viamvp.repertory;

import android.content.Context;

import com.myatejx.architecture.business.interfaces.INetworkInterface;
import com.myatejx.viamvp.bean.TestBean;

import java.io.IOException;
import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/22
 */
public class NetworkAdapter implements INetworkInterface<TestBean> {
    @Override
    public void init(Context context) {

    }

    @Override
    public String listSupportMethods() {
        return null;
    }

    @Override
    public String listFiles(String dirName) throws IOException {
        return null;
    }

    @Override
    public boolean isExistFile(String fileName) throws IOException {
        return false;
    }

    @Override
    public boolean downloadFile(String fileName) {
        return false;
    }

    @Override
    public boolean downloadFiles(List<String> filesName) {
        return false;
    }

    @Override
    public String getStringFromNetFile(String fileName) throws IOException {
        return null;
    }

    @Override
    public boolean uploadFile(String fileName) throws IOException {
        return false;
    }

    @Override
    public boolean uploadString(String fileName, String content) throws IOException {
        return false;
    }

    @Override
    public boolean uploadFiles(List<String> filesName) {
        return false;
    }

    @Override
    public List<TestBean> jsonToList(String json) {
        return null;
    }

    @Override
    public String listToJson(List<TestBean> list) {
        return null;
    }
}
