package com.flow8.elements;

import android.app.LauncherActivity;
import android.graphics.drawable.Drawable;

/**
 * Created by GILADSAG on 7/9/2018.
 */

public class ListItem {
    private Drawable logo;
    private String exploreItem, url;

    public ListItem(Drawable logo, String exploreItem, String url) {
        this.logo = logo;
        this.exploreItem = exploreItem;
        this.url=url;
    }

    public Drawable getlogo() {
        return logo;
    }

    public String getexploreItem() {
        return exploreItem;
    }

    public String geturl() {
        return url;
    }

}
