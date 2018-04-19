package com.example.mcolv.fortnite_guide_android;

import android.content.Context;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;



public class TableEditor {
    TableEditor(TableLayout Table_to_be_edited, Context where){
        table=Table_to_be_edited;
        context=where;
    }

    void add_column(String[] text_to_add , Integer column_color){
        int j=0; // count for what string to use
        // row views of table
        TableRow.LayoutParams add_view_params= new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.MATCH_PARENT);
        add_view_params.setMargins(0,0,(int)context.getResources().getDimension(R.dimen.table_divider_thickness),(int)context.getResources().getDimension(R.dimen.table_divider_thickness));
        for(int i=0; i<table.getChildCount(); i++){ // for all rows
            View row = table.getChildAt(i);
            if(row instanceof TableRow){
                TableRow tableRow = (TableRow) row;
                TextView add = new TextView(context);
                add.setTextSize(TypedValue.COMPLEX_UNIT_PX,context.getResources().getDimension(R.dimen.table_num_size));
                if(j==0){ add.setTextSize(TypedValue.COMPLEX_UNIT_PX,context.getResources().getDimension(R.dimen.table_text_size));}
                add.setText(text_to_add[j]); j++;
                add.setLayoutParams(add_view_params);
                add.setGravity(Gravity.CENTER);
                add.setBackgroundResource(column_color);
                tableRow.addView(add);
            }
        }




    }

    public float dptopx(android.content.Context context, float dp) {
        int conversion_factor = context.getResources().getDimensionPixelSize(R.dimen.dp_1);
        return(dp*conversion_factor);
    }

    Context context;
    TableLayout table;
}
