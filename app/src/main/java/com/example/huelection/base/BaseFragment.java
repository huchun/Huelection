package com.example.huelection.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huelection.R;

/**
 * Created by chunchun.hu on 2018/3/5.
 */

public class BaseFragment extends Fragment {

     private View view;

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     * @must 1.不要在子类重复这个类中onCreateView中的代码;
     *       2.在子类onCreateView中super.onCreateView(inflater, container, savedInstanceState);
     *       initView();initData();initEvent(); return view;
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return onCreateView(inflater, container, savedInstanceState, 0);
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @param layoutResID fragment全局视图view的布局资源id，默认值为R.layout.base_http_list_fragment
     * @return
     * @must 1.不要在子类重复这个类中onCreateView中的代码;
     *       2.在子类onCreateView中super.onCreateView(inflater, container, savedInstanceState, layoutResID);
     *       initView();initData();initEvent(); return view;
     */
    private View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, int layoutResID) {
        super.onCreateView(inflater,container,savedInstanceState);

        view = inflater.inflate(layoutResID <= 0 ? R.layout.base_list_fragment : layoutResID, container,false);
        return view;
    }
}
