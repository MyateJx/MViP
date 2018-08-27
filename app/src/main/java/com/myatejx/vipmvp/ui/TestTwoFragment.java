package com.myatejx.vipmvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myatejx.architecture.R;
import com.myatejx.architecture.base.BaseFragment;
import com.myatejx.architecture.business.bus.BaseResult;
import com.myatejx.architecture.business.bus.BaseResultCode;
import com.myatejx.vipmvp.business.TestBus;
import com.myatejx.vipmvp.databinding.FragmentTestTwoBinding;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestTwoFragment extends BaseFragment {

    private FragmentTestTwoBinding mBinding;

    public static TestTwoFragment newInstance() {
        TestTwoFragment fragment = new TestTwoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_two, container, false);
        mBinding = FragmentTestTwoBinding.bind(view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        TestBus.requestBeans();
    }

    @Override
    public void onResult(BaseResult testResult) {
        int resultCode = testResult.getResultCode();
        switch (resultCode) {
            /*case BaseResultCode.GET_BEAN:
                break;*/
            case BaseResultCode.GET_BEANS:
                break;
            default:
        }
    }
}
