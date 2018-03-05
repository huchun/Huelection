package com.example.huelection.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.huelection.R;

/**
 * Created by chunchun.hu on 2018/3/5.
 */

public class RefreshListViewHeader extends LinearLayout {

    private LinearLayout mContainer = null;
    private View mArrowImageView = null;
    private View mProgressBar = null;
    private TextView mHintTextView = null;

    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;

    private final int ROTATE_ANIM_DURATION = 180;

    public final static int STATE_NORMAL = 0;
    public final static int STATE_READY = 1;
    public final static int STATE_REFRESHING = 2;

    public RefreshListViewHeader(Context context) {
        super(context);
        initView(context);
    }

    /**
     * @param context
     * @param attrs
     */
    public RefreshListViewHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    private void initView(Context context) {
        // 初始情况，设置下拉刷新view高度为0
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,0);
        mContainer = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.listview_header, null);
        addView(mContainer,params);
        setGravity(Gravity.BOTTOM);

        mArrowImageView = findViewById(R.id.listview_header_arrow);
        mProgressBar = findViewById(R.id.listview_header_progressbar);
        mHintTextView = findViewById(R.id.listview_header_hint_textview);

        mRotateUpAnim = new RotateAnimation(0.0f, -180.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateUpAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateUpAnim.setFillAfter(true);

        mRotateDownAnim = new RotateAnimation(-180.0f,0.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        mRotateDownAnim.setDuration(ROTATE_ANIM_DURATION);
        mRotateDownAnim.setFillAfter(true);
    }

    public void setVisiableHeight(int height) {
        if(height < 0)
            height = 0;
        LayoutParams params = (LayoutParams) mContainer.getLayoutParams();
        params.height = height;
        mContainer.setLayoutParams(params);
    }


}
