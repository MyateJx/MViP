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
import com.myatejx.architecture.business.bus.IResponse;
import com.myatejx.architecture.business.bus.Result;
import com.myatejx.vipmvp.R;
import com.myatejx.vipmvp.bean.NoteBean;
import com.myatejx.vipmvp.business.bus.NoteBus;
import com.myatejx.vipmvp.business.constant.NoteResultCode;
import com.myatejx.vipmvp.databinding.AdapterTestListBinding;
import com.myatejx.vipmvp.databinding.FragmentNoteListBinding;
import com.myatejx.vipmvp.ui.adapter.BaseBindingAdapter;

import java.util.List;

/**
 * @author KunMinX
 * @date 2018/8/21
 */
public class NoteListFragment extends Fragment implements IResponse {

    private FragmentNoteListBinding mBinding;
    private BaseBindingAdapter<NoteBean, AdapterTestListBinding> mAdapter;

    public static NoteListFragment newInstance() {
        NoteListFragment fragment = new NoteListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);
        mBinding = FragmentNoteListBinding.bind(view);
        mBinding.setClickProxy(new ClickProxy());
        setHasOptionsMenu(true);
        NoteBus.registerResponseObserver(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
    }

    private void initViews() {
        mAdapter = new BaseBindingAdapter<NoteBean, AdapterTestListBinding>(getContext()) {
            @Override
            protected int getLayoutResId(int viewType) {
                return R.layout.adapter_test_list;
            }

            @Override
            protected void onBindItem(AdapterTestListBinding binding, final NoteBean item, int position) {
                binding.tvTitle.setText(item.getTitle());
                Glide.with(getContext()).load(item.getImgUrl()).into(binding.ivThumb);
                binding.getRoot().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .add(R.id.fragment_container, NoteDetailFragment.newInstance(item.getTitle()))
                                .addToBackStack(null).commit();
                    }
                });
            }
        };
        mBinding.rv.setAdapter(mAdapter);
        NoteBus.note().queryList();
    }

    public class ClickProxy {
        public void newTest() {
            getActivity().getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, NoteDetailFragment.newInstance(""))
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void onResult(Result testResult) {
        int resultCode = testResult.getResultCode();
        switch (resultCode) {
            case NoteResultCode.QUERY_LIST:
                List<NoteBean> beanList;
                if (testResult.getResultObject() != null) {
                    beanList = (List<NoteBean>) testResult.getResultObject();
                    mAdapter.setList(beanList);
                    mAdapter.notifyDataSetChanged();
                }
                break;
            case NoteResultCode.INSERTED:

                break;
            case NoteResultCode.FAILURE:
                Toast.makeText(getContext(), "数据请求失败", Toast.LENGTH_SHORT).show();
                break;
            case NoteResultCode.CANCELED:
                Toast.makeText(getContext(), "数据请求取消", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        NoteBus.unregisterResponseObserver(this);
    }
}
