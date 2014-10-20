package com.codebaum.antifragments.dummy;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    static {
        // Add 3 sample items.
        addItem(new DummyItem("1", "Item 1"));
        addItem(new DummyItem("2", "Item 2"));
        addItem(new DummyItem("3", "Item 3"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem implements Parcelable {

        /* Variables */

        public String id;
        public String content;

        public static final Parcelable.Creator<DummyItem> CREATOR =
                new Parcelable.Creator<DummyItem>(){

                    @Override
                    public DummyItem createFromParcel(Parcel source) {
                        return new DummyItem(source);
                    }

                    @Override
                    public DummyItem[] newArray(int size) {
                        return new DummyItem[size];
                    }
                };

        /* Constructors */

        public DummyItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        public DummyItem(Parcel source){
            readFromParcel(source);
        }

        /* Overridden Methods */

        @Override
        public String toString() {
            return content;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(id);
            dest.writeString(content);
        }

        /* Custom Methods */

        public void readFromParcel(Parcel source){
            id = source.readString();
            content = source.readString();
        }
    }
}
