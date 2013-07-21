package com.introtoandroid.advancedlayouts;
public class GridListMenuActivity extends MenuActivity {
    @Override
    /*
     * The code for all three of these is identical, except for the 
     * class used for the layout in each.
     */
    void prepareMenu() {
        addMenuItem("1. Grid w/Adapter", GridAdapterSampleActivity.class);
        addMenuItem("2. List w/Adapter", ListAdapterSampleActivity.class);
    }
}