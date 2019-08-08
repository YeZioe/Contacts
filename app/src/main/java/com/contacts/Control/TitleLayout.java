package com.contacts.Control;


import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.contacts.R;

public class TitleLayout extends LinearLayout implements View.OnClickListener{


    private static final String TAG = "TitleLayout";
    public TitleLayout(Context context, AttributeSet attrs){

        super(context,attrs);
        LayoutInflater.from(context).inflate(R.layout.bar_title,this);

    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.add_button:

                break;
            case R.id.setting_button:
                //逻辑代码
                break;
            default:
                break;

        }
    }




}
