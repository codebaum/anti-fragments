package com.codebaum.antifragments.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.codebaum.antifragments.R;
import com.codebaum.antifragments.activities.AntiFragmentActivity;
import com.codebaum.antifragments.dummy.DummyContent;
import com.codebaum.antifragments.interfaces.Container;

/**
 * TODO: document your custom view class.
 */
public class ItemListView extends ListView {
    public ItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onFinishInflate() {
        super.onFinishInflate();
        final ListAdapter adapter = new ArrayAdapter<DummyContent.DummyItem>(
                getContext(),
                android.R.layout.simple_list_item_activated_1,
                android.R.id.text1,
                DummyContent.ITEMS);
        setAdapter(adapter);
        setOnItemClickListener(new OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> parent, View view,
                                              int position, long id) {
                String item = (String) adapter.getItem(position);
                AntiFragmentActivity activity = (AntiFragmentActivity) getContext();
                Container container = activity.getContainer();
                container.showItem(item);
            }
        });
    }
}
