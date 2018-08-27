package com.myatejx.viamvp.ui;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.myatejx.architecture.R;
import com.myatejx.architecture.base.BaseActivity;
import com.myatejx.architecture.utils.PermissionUtils;
import com.myatejx.viamvp.business.TestBus;
import com.myatejx.viamvp.business.TestPresenter;
import com.myatejx.viamvp.databinding.ActivityTestBinding;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestActivity extends BaseActivity {

    private ActivityTestBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        initModel();
    }

    private void initView() {
        loadRootFragment(R.id.fragment_container, TestOneFragment.newInstance());
    }

    private void initModel() {
        PermissionUtils.requestPermissionInActivity(new PermissionUtils.IPermissionCallback() {
            @Override
            public void onAllowedPermissions() {
                TestPresenter presenter = new TestPresenter();
                TestBus.registerIRequest(presenter);
                initView();
            }

            @Override
            public void onDeniedPermissions(String msg) {

            }
        }, this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TestBus.registerIRequest(null);
        TestBus.unregisterAllResponses();
    }
}
