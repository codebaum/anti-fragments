package com.codebaum.antifragments.views.containers;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.codebaum.antifragments.interfaces.Container;
import com.codebaum.antifragments.views.MyDetailView;

/**
 * Created by brandon on 10/9/14.
 */
public class DualPaneContainer extends LinearLayout implements Container {
    private MyDetailView detailView;

    public DualPaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        detailView = (MyDetailView) getChildAt(1);
    }

    public boolean onBackPressed() {
        return false;
    }

    @Override public void showItem(String item) {
        detailView.setItem(item);
    }
}
