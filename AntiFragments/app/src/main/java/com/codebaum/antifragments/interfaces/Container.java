package com.codebaum.antifragments.interfaces;

import com.codebaum.antifragments.dummy.DummyContent;

/**
 * Created by brandon on 10/9/14.
 */
public interface Container {
    public void showItem(DummyContent.DummyItem item);
    public boolean onBackPressed();
    public DummyContent.DummyItem getDetailState();
}
