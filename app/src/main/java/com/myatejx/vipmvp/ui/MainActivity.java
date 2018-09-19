package com.myatejx.vipmvp.ui;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.myatejx.architecture.utils.PermissionUtils;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.business.NoteBusiness;
import com.myatejx.vipmvp.business.bus.NoteBus;
import com.myatejx.vipmvp.databinding.ActivityMainBinding;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initModel();
    }

    private void initView() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, NoteListFragment.newInstance())
                .addToBackStack(null).commit();
    }

    private void initModel() {
        PermissionUtils.requestPermissionInActivity(new PermissionUtils.IPermissionCallback() {
            @Override
            public void onAllowedPermissions() {
                NoteBusiness noteBusiness = new NoteBusiness();
                noteBusiness.init(getApplicationContext());
                NoteBus.registerRequestHandler(noteBusiness);
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
    }

}
