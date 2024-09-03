package com.example.game_dua_xe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class boxAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<box>boxlist;

    public boxAdapter(Context context, int layout, List<box> boxlist) {
        this.context = context;
        this.layout = layout;
        this.boxlist = boxlist;
    }

    @Override
    public int getCount() {
        return boxlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHorder{
        ImageView imgHinh;
        TextView giatri;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHorder hd;
        if(view==null){
            hd=new ViewHorder();
            LayoutInflater ifLayoutInflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=ifLayoutInflater.inflate(layout,null);

            hd.imgHinh=(ImageView) view.findViewById(R.id.imghinh);
            hd.giatri=(TextView) view.findViewById(R.id.giatri);
            view.setTag(hd);
        }else{
            hd=(ViewHorder) view.getTag();
        }

        box box=boxlist.get(i);
        hd.imgHinh.setImageResource(box.getHinh());
        hd.giatri.setText(box.getGiatri()+"");

        return view;
    }
}
