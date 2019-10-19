package com.example.project1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class profileAdapter extends BaseAdapter {
     private Context context;
     private List<profile> dataSource ;
    public profileAdapter(Context context, List<profile> dataSource) {
        this.context= context ;
        this.dataSource = dataSource;
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public profile getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {
        Viewholder viewholder = null ;
        if (convertview == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertview = inflater.inflate(R.layout.gridrow, viewGroup, false);
            viewholder = new Viewholder(convertview);
            convertview.setTag(viewholder);
        }else{
            viewholder  = (Viewholder) convertview.getTag();

        }
        profile item = getItem(i);
        viewholder.imageView.setImageResource(item.getImage());
        viewholder.textView.setText(item.getTitle());
        return convertview;

    }class Viewholder {
        ImageView imageView ;
        TextView textView ;
        Viewholder(View view){
            imageView=view.findViewById(R.id.imageView);
            textView=view.findViewById(R.id.textView2);

        }
    }
}
