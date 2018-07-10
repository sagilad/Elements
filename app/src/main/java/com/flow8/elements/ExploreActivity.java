package com.flow8.elements;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by GILADSAG on 9/19/2017.
 */

public class ExploreActivity extends Fragment{
    private static final String TAG = "SettingsFragment";

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    private List<ListItem> listItems;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_explore,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.exploreLst);
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listItems = new ArrayList<>();
        defineList();
        return view;

    }
public void defineList(){
    Resources res = getResources();
    String mDrawableName = "logo_default";
    //int resID = res.getIdentifier(mDrawableName , "wikipedia_icon.png", getContext().getPackageName());
    //Drawable wikiIMG = ContextCompat.getDrawable(getContext(), resID);
    Drawable wikiIMG = this.getContext().getDrawable(R.drawable.wikipedia_icon);
    Drawable iepIMG = this.getContext().getDrawable(R.drawable.iep);
    Drawable britanicaIMG = this.getContext().getDrawable(R.drawable.britanica);
    Drawable kwIMG = this.getContext().getDrawable(R.drawable.kw);
    Drawable zenIMG = this.getContext().getDrawable(R.drawable.zen);
    Drawable chinaIMG = this.getContext().getDrawable(R.drawable.china);

    listItems.add(new ListItem(wikiIMG,"Wikipedia","https://en.wikipedia.org/wiki/Wu_Xing"));
    listItems.add(new ListItem(iepIMG,"IEP","http://www.iep.utm.edu/wuxing/"));
    listItems.add(new ListItem(britanicaIMG,"Encyclopedia Britannica","https://www.britannica.com/topic/wuxing"));
    listItems.add(new ListItem(kwIMG,"Karma Weather","https://www.karmaweather.com/the-5-chinese-astrology-zodiac-elements/"));
    listItems.add(new ListItem(zenIMG,"The Zen Of Healing","https://www.thezenofhealing.com/5-element"));
    listItems.add(new ListItem(chinaIMG,"China Highlights","https://www.chinahighlights.com/travelguide/chinese-zodiac/china-five-elements-philosophy.htm"));

    adapter = new MyAdapter(listItems, getContext());

    recyclerView.setAdapter(adapter);
}
}
