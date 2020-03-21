package com.example.hw1.dummy;

import android.graphics.Color;
import android.os.Parcelable;

import com.example.hw1.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

public class DummyContent {
    public static final List<DummyItem> ITEMS = new ArrayList<>();
    private static int COUNT = 0;

    public static int createDummyItem() {
        int textColor = COUNT % 2 == 0 ? Color.RED : Color.BLUE;
        ITEMS.add(new DummyItem(String.valueOf(COUNT+1), textColor));
        return COUNT++;
    }

    public static class DummyItem {
        final String text;
        final int textColor;

        DummyItem(String text, int textColor) {
            this.text = text;
            this.textColor = textColor;
        }

        public int getTextColor() {
            return textColor;
        }

        public String getText() {
            return text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
