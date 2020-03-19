package com.example.hw1.dummy;

import android.os.Parcelable;

import com.example.hw1.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static int COUNT = 0;

    public static int createDummyItem() {
        addItem(new DummyItem(String.valueOf(COUNT), "Item " + COUNT, makeDetails(COUNT)));
        return COUNT++;
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
