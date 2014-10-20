package com.codebaum.antifragments.presenters;

import android.widget.Toast;

import com.codebaum.antifragments.views.MyDetailView;

/**
 * Created by brandon on 10/9/14.
 */
public class DetailPresenter {

    /* SETUP */

    private MyDetailView view;

    public void setView(MyDetailView view) {
        this.view = view;
    }

    /* ACTIONS */

    public void buttonClicked() {
        Toast.makeText(view.getContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
    }
}
