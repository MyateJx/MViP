package com.myatejx.vipmvp.ui;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.architecture.business.bus.IResponse;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.architecture.utils.PermissionUtils;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.business.TestBus;
import com.myatejx.vipmvp.business.TestPresenter;
import com.myatejx.vipmvp.databinding.ActivityTestBinding;
import com.myatejx.vipmvp.test.INetRequest;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestActivity extends AppCompatActivity implements IResponse {

    private ActivityTestBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TBus.registerResponseObserver(this);
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
                TestPresenter presenter = new TestPresenter(getApplicationContext(), TestBus.io());
                initView();
            }

            @Override
            public void onDeniedPermissions(String msg) {

            }
        }, this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        TBus.net().get();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        TBus.unregisterResponseObserver(this);
    }

    @Override
    public void onResult(Result testResult) {

    }
}
