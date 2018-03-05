package com.example.huelection.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.huelection.R;

/**
 * Created by chunchun.hu on 2018/3/5.
 */

public class RefreshListViewFooter extends LinearLayout {

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_LOADING = 2;
    public final static int STATE_COMPLETE = 3;//Lemon add: all data were loaded and no more data available

    private Context mContext;

    private View mContentView;
    private View mProgressBar;
    private TextView mHintView;

    private boolean needFooter = true;
    private boolean isShowing = false;

    public RefreshListViewFooter(Context context) {
        super(context);
        initView(context);
    }

    public RefreshListViewFooter(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        LinearLayout moreView = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.listview_folder, null);
        addView(moreView);
        moreView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT));

        mContentView = moreView.findViewById(R.id.listview_footer_content);
        mProgressBar = moreView.findViewById(R.id.listview_footer_progressbar);
        mHintView = moreView.findViewById(R.id.xlistview_footer_hint_textview);
    }

    public boolean isShowing() {
        return isShowing;
    }

    public void setBottomMargin(int height) {
        if (height < 0)
            return;
        LayoutParams params = (LayoutParams) mContentView.getLayoutParams();
        params.bottomMargin = height;
        mContentView.setLayoutParams(params);
    }
}
