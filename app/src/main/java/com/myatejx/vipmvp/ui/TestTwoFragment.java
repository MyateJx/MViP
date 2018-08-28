package com.myatejx.vipmvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.IResponse;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.business.ITestRequest;
import com.myatejx.vipmvp.constant.BusinessType;
import com.myatejx.vipmvp.constant.TestResultCode;
import com.myatejx.vipmvp.databinding.FragmentTestTwoBinding;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestTwoFragment extends Fragment implements IResponse {

    private FragmentTestTwoBinding mBinding;
    private ITestRequest mRequest;

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
        BaseBus.registerResponseObserve(BusinessType.DIARY.name(), this);
        mRequest = (ITestRequest) BaseBus.request(BusinessType.DIARY.name());
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mRequest.requestBean();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseBus.unregisterResponseObserve(BusinessType.DIARY.name(), this);
    }

    @Override
    public void onResult(Result testResult) {
        int resultCode = testResult.getResultCode();
        switch (resultCode) {
            case TestResultCode.GOT_LIST:
                break;
            case TestResultCode.FAILURE:
                break;
            case TestResultCode.CANCELED:
                break;
            default:
        }
    }
}
