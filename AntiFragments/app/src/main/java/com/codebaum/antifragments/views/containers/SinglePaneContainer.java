package com.codebaum.antifragments.views.containers;

import android.app.ActionBar;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.codebaum.antifragments.R;
import com.codebaum.antifragments.activities.AntiFragmentActivity;
import com.codebaum.antifragments.dummy.DummyContent;
import com.codebaum.antifragments.interfaces.Container;
import com.codebaum.antifragments.views.ItemListView;
import com.codebaum.antifragments.views.MyDetailView;

/**
 * Created by brandon on 10/9/14.
 */
public class SinglePaneContainer extends FrameLayout implements Container {
    private ItemListView listView;

    public SinglePaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ItemListView) getChildAt(0);
    }

    public boolean onBackPressed() {
        if (!listViewAttached()) {
            removeViewAt(0);
            addView(listView);

            AntiFragmentActivity activity = (AntiFragmentActivity) getContext();
            ActionBar actionBar = activity.getActionBar();
            actionBar.setTitle(R.string.title_headline_list_anti);
            actionBar.setDisplayHomeAsUpEnabled(false);

            return true;
        }
        return false;
    }

    @Override public void showItem(DummyContent.DummyItem item) {
        if (listViewAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail, this);

            AntiFragmentActivity activity = (AntiFragmentActivity) getContext();
            ActionBar actionBar = activity.getActionBar();
            actionBar.setTitle(R.string.title_headline_detail);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        MyDetailView detailView = (MyDetailView) getChildAt(0);
        detailView.setItem(item);
    }

    @Override
    public DummyContent.DummyItem getDetailState() {
        if (listViewAttached()) {
            return null;
        }

        MyDetailView detailView = (MyDetailView) getChildAt(0);
        return detailView.getItem();
    }

    private boolean listViewAttached() {
        return listView.getParent() != null;
    }
}