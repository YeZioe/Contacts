package com.contacts.Adapter;


import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.contacts.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneAdapter<P> extends ArrayAdapter<PhoneEntity> {

    private int resourceId;
    List<PhoneEntity> objects;


    public PhoneAdapter(Context context, int textViewResourceId, List<PhoneEntity> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        PhoneEntity phoneEntity = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);

        ImageView phoneImage = view.findViewById(R.id.people_photo);
        TextView phonename = view.findViewById(R.id.name);
        TextView phonenumber = view.findViewById(R.id.number);

        phoneImage.setImageResource(phoneEntity.getImageId());
        phonename.setText(phoneEntity.getPhoneName());
        phonenumber.setText(phoneEntity.getPhoneNumber());



        return view;
    }


}
