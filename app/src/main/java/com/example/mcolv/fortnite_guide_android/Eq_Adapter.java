package com.example.mcolv.fortnite_guide_android;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class Eq_Adapter extends ArrayAdapter<String> {

    private final Context mcontext;  // where tasking is happening
    private final String[] titles;     // titles for the elements of list
    private final Integer[] drawids;    // id for the drawables

    //for layout element example see eq_lists_element.xmlq
     Eq_Adapter(Context context, String[]titles, Integer[]drawid){ //constructor which you will pass to
        super(context,R.layout.eq_lists_element,titles);{

        this.mcontext=context;
        this.titles=titles;
        this.drawids=drawid;


        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

      ViewHolder holder ;

        if(convertView == null) {
            LayoutInflater inflater= ((Activity)mcontext).getLayoutInflater();
            convertView=inflater.inflate(R.layout.eq_lists_element,parent,false);
            holder = new ViewHolder();
            holder.txt = convertView.findViewById(R.id.equiptment_element_txt);
            holder.img = convertView.findViewById(R.id.equiptment_element_img);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img.setImageResource(drawids[position]);
        holder.txt.setText(titles[position]);

    return convertView;
    }
    static class ViewHolder{ //holds views for faster displaying
        public TextView txt;
        public ImageView img;
    }

}
