package com.codebaum.antifragments.views.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.codebaum.antifragments.R;
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
            return true;
        }
        return false;
    }

    @Override public void showItem(String item) {
        if (listViewAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail, this);
        }
        MyDetailView detailView = (MyDetailView) getChildAt(0);
        detailView.setItem(item);
    }

    private boolean listViewAttached() {
        return listView.getParent() != null;
    }
}