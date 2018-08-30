package com.myatejx.vipmvp.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.myatejx.architecture.business.bus.BaseBus;
import com.myatejx.architecture.business.bus.IResponse;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.bean.TestBean;
import com.myatejx.vipmvp.business.ITestRequest;
import com.myatejx.vipmvp.business.constant.BusinessType;
import com.myatejx.vipmvp.business.constant.TestResultCode;
import com.myatejx.vipmvp.databinding.AdapterTestListBinding;
import com.myatejx.vipmvp.databinding.FragmentTestListBinding;
import com.myatejx.vipmvp.ui.adapter.BaseBindingAdapter;

import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class TestListFragment extends Fragment implements IResponse {

    private FragmentTestListBinding mBinding;
    private ITestRequest mRequest;
    private BaseBindingAdapter<TestBean, AdapterTestListBinding> mAdapter;

    public static TestListFragment newInstance() {
        TestListFragment fragment = new TestListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test_list, container, false);
        mBinding = FragmentTestListBinding.bind(view);
        mBinding.setClickProxy(new ClickProxy());
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
        mAdapter = new BaseBindingAdapter<TestBean, AdapterTestListBinding>(getContext()) {
            @Override
            protected int getLayoutResId(int viewType) {
                return R.layout.adapter_test_list;
            }

            @Override
            protected void onBindItem(AdapterTestListBinding binding, TestBean item, int position) {
                binding.tvTitle.setText(item.getTitle());
                Glide.with(getContext()).load(item.getImgUrl()).into(binding.ivThumb);
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .add(R.id.fragment_container, TestDetailFragment.newInstance())
                                .addToBackStack(null).commit();
                    }
                });
            }
        };
        mBinding.rv.setAdapter(mAdapter);
        mRequest.requestBean();
    }

    public class ClickProxy {
        public void newTest() {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, TestDetailFragment.newInstance())
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onResult(Result testResult) {
        int resultCode = testResult.getResultCode();
        switch (resultCode) {
            case TestResultCode.GOT_LIST:
                List<TestBean> beanList;
                if (testResult.getResultObject() != null) {
                    beanList = (List<TestBean>) testResult.getResultObject();
                    mAdapter.setList(beanList);
                    mAdapter.notifyDataSetChanged();
                }
                break;
            case TestResultCode.INSERTED:

                break;
            case TestResultCode.FAILURE:
                Toast.makeText(getContext(), "数据请求失败", Toast.LENGTH_SHORT).show();
                break;
            case TestResultCode.CANCELED:
                Toast.makeText(getContext(), "数据请求取消", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        BaseBus.unregisterResponseObserve(BusinessType.DIARY.name(), this);
    }
}
