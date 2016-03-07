package com.example.jimmy.scroolableview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jimmy.scroolableview.R;
import com.example.jimmy.scroolableview.drawer.NavDrawerItem;

import java.util.ArrayList;

/**
 * Created by Jimmy on 3/5/2016.
 */
public class NavDrawerListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<NavDrawerItem> list;

    public NavDrawerListAdapter (Context context, ArrayList<NavDrawerItem> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView ivIcon = (ImageView)convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView)convertView.findViewById(R.id.title);
        ivIcon.setImageResource(list.get(position).getImage());
        txtTitle.setText(list.get(position).getTitle());
        return convertView;
    }
}
