package com.codebaum.antifragments.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.codebaum.antifragments.R;
import com.codebaum.antifragments.dummy.DummyContent;
import com.codebaum.antifragments.interfaces.Container;

public class AntiFragmentActivity extends Activity {

    /**
     * The serialization (saved instance state) Bundle key representing the
     * activated item position. Only used on tablets.
     */
    private static final String STATE_ACTIVATED_POSITION = "activated_position";

    private Container container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anti_fragment);

        container = (Container) findViewById(R.id.container);

        // Restore the previously serialized activated item position.
        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_ACTIVATED_POSITION)) {
            DummyContent.DummyItem savedItem = savedInstanceState.getParcelable(STATE_ACTIVATED_POSITION);
            if (savedItem != null) {
                container.showItem(savedItem);
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.anti, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings: {
                return true;
            }
            case android.R.id.home: {
                container.onBackPressed();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override public void onBackPressed() {
        boolean handled = container.onBackPressed();
        if (!handled) {
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(STATE_ACTIVATED_POSITION, container.getDetailState());
    }

    public Container getContainer() {
        return container;
    }
}
