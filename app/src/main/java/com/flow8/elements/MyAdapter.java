package com.flow8.elements;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by GILADSAG on 7/9/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<ListItem> listItems;
    private Context context;

    public MyAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);
        holder.itemLogo.setImageDrawable(listItem.getlogo());
        holder.itemName.setText(listItem.getexploreItem());

        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = listItem.geturl();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView itemLogo;
        public TextView itemName;
        public LinearLayout itemLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemLogo = (ImageView)itemView.findViewById(R.id.itemLogo);
            itemName = (TextView)itemView.findViewById(R.id.itemName);
            itemLayout = (LinearLayout)itemView.findViewById(R.id.item_layout);
        }
    }
}

