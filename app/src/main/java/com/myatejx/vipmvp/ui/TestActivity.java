package com.myatejx.vipmvp.ui;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.utils.PermissionUtils;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.business.TestPresenter;
import com.myatejx.vipmvp.business.constant.BusinessType;
import com.myatejx.vipmvp.databinding.ActivityTestBinding;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestActivity extends AppCompatActivity {

    private ActivityTestBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_test);
        initModel();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, TestListFragment.newInstance())
                .addToBackStack(null).commit();
    }

    private void initModel() {
        PermissionUtils.requestPermissionInActivity(new PermissionUtils.IPermissionCallback() {
            @Override
            public void onAllowedPermissions() {
                TestPresenter presenter = new TestPresenter();
                BaseBus.registerRequestHandle(BusinessType.DIARY.name(), presenter);
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
        BaseBus.clearAllRegister();
    }
}
