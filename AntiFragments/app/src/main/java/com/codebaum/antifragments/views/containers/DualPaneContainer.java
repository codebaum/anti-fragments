package com.codebaum.antifragments.views.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.codebaum.antifragments.dummy.DummyContent;
import com.codebaum.antifragments.interfaces.Container;
import com.codebaum.antifragments.views.ItemListView;
import com.codebaum.antifragments.views.MyDetailView;

/**
 * Created by brandon on 10/9/14.
 */
public class DualPaneContainer extends LinearLayout implements Container {

    /* Variables */

    private ItemListView listView;
    private MyDetailView detailView;

    /* Constructors */

    public DualPaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /* Overridden Methods */

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ItemListView) getChildAt(0);
        detailView = (MyDetailView) getChildAt(1);
    }

    @Override
    public DummyContent.DummyItem getDetailState() {
        try {
            return detailView.getItem();
        } catch (NullPointerException npe) {
            return null;
        }
    }

    @Override
    public void showItem(DummyContent.DummyItem item) {
        detailView.setItem(item);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
