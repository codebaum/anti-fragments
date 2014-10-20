package com.codebaum.antifragments.views;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.codebaum.antifragments.R;
import com.codebaum.antifragments.activities.AntiFragmentActivity;
import com.codebaum.antifragments.dummy.DummyContent;
import com.codebaum.antifragments.presenters.DetailPresenter;

/**
 * Created by brandon on 10/9/14.
 */
public class MyDetailView extends LinearLayout {

    /* Variables */

    TextView textView;
    DetailPresenter presenter;
    DummyContent.DummyItem item;

    /* Constructors */

    public MyDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        presenter = new DetailPresenter();
    }

    /* Overridden Methods */

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        presenter.setView(this);
        textView = (TextView) findViewById(R.id.text);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.buttonClicked();
            }
        });
    }

    /* Custom Methods */

    public void setItem(DummyContent.DummyItem item) {
        this.item = item;
        textView.setText(item.content);
    }

    public DummyContent.DummyItem getItem() {
        return item;
    }
}
