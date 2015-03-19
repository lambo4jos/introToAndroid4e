package com.introtoandroid.simplecontentprovider;

public class SimpleContentProviderMenuActivity extends MenuActivity {

    @Override
    void prepareMenu() {
        addMenuItem("1. MediaStore", SimpleMediaStore.class);
        addMenuItem("2. CallLog", SimpleCallLog.class);
        addMenuItem("3. Bookmarks", SimpleBookmarks.class);
    }
}