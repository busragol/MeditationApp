package com.example.meditasyonapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private String[] name;
    private String[] link;
    private LayoutInflater inflater;//come back images in menusatir
    public ListViewAdapter(Context n_context,String[] n_name,String[] n_link){
        this.context=n_context;
        this.name=n_name;
        this.link=n_link;

    }
    @Override
    public int getCount() {
        return name.length;//there are many items as the number of names in the menu
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView name_textview;
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemview=inflater.inflate(R.layout.menusatir,parent,false);
        name_textview=(TextView) itemview.findViewById(R.id.menunameText);
        name_textview.setText(name[position]);
        return itemview;
    }
}
