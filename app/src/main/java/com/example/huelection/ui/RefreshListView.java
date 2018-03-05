package com.example.huelection.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Scroller;

/**
 * 下拉刷新，上拉加载的ListView
 * @modifier Lemon
 */
public class RefreshListView extends ListView implements AbsListView.OnScrollListener {

    private float mLastY = -1; // save event y
    private Scroller mScroller; // used for scroll back
    private OnScrollListener mScrollListener; // user's scroll listener

    // -- header view
    private RefreshListViewHeader mHeaderView;


    private int mHeaderViewHeight; // header view's height

    // -- footer view
    private RefreshListViewFooter mFooterView;

    // total list items, used to detect is at the bottom of listview.
    private int mTotalItemCount;

    // for mScroller, scroll back from header or footer.
    private int mScrollBack;
    private final static int SCROLLBACK_HEADER = 0;
    private final static int SCROLLBACK_FOOTER = 1;

    private final static int SCROLL_DURATION = 400; // scroll back duration
    private final static int PULL_LOAD_MORE_DELTA = 50; // when pull up >= 50px
    // at bottom, trigger
    // load more.
    private final static float OFFSET_RADIO = 1.8f; // support iOS like pull
    // feature.

    public RefreshListView(Context context) {
        super(context);
        initWithContext(context);
    }

    public RefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initWithContext(context);
    }

    public RefreshListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initWithContext(context);
    }

    private void initWithContext(Context context) {
        setFadingEdgeLength(0);
        setOverScrollMode(View.OVER_SCROLL_NEVER); // 消除滚动边框

        mScroller = new Scroller(context, new DecelerateInterpolator());
        super.setOnScrollListener(this);

        // init header view
        mHeaderView = new RefreshListViewHeader(context);


        addHeaderView(mHeaderView);

        // init footer view
        mFooterView = new RefreshListViewFooter(context);

        // init header height
        mHeaderView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

                getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    @Override
    public void setAdapter(ListAdapter adapter) {
        super.setAdapter(adapter);
    }

    @Override
    public void setOnScrollListener(OnScrollListener l) {
        mScrollListener = l;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
         if (mScrollListener != null){
             mScrollListener.onScrollStateChanged(view, scrollState);
         }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        // send to user's listener
        mTotalItemCount = totalItemCount;
        if (mScrollListener != null){
            mScrollListener.onScroll(view,firstVisibleItem,visibleItemCount,totalItemCount);
        }
    }

    private void invokeOnScrolling() {

    }

    @Override
    public void computeScroll() {
        if (mScroller.computeScrollOffset()){
            if (mScrollBack == SCROLLBACK_HEADER){
                mHeaderView.setVisiableHeight(mScroller.getCurrY());
            }else{
                mFooterView.setBottomMargin(mScroller.getCurrY());
            }
            postInvalidate();
            invokeOnScrolling();
        }
        super.computeScroll();
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        return super.onTouchEvent(ev);
    }


}
