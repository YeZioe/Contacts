package com.contacts.VIew;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import android.app.Fragment;


import com.contacts.Adapter.PhoneAdapter;
import com.contacts.Adapter.PhoneEntity;

import com.contacts.AddContactsActivity;
import com.contacts.R;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class ContactsFragment extends Fragment {

    public PhoneAdapter<PhoneEntity> adapter;

    private String name;
    private String number;


    private ListView listview;
    private List<PhoneEntity> phoneEntities = new ArrayList<>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button button = (Button) getActivity().findViewById(R.id.add_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(getActivity(),AddContactsActivity.class),1);

                if(name != null && number != null) {
                    addPhotoEnger();
                }
                Log.i(TAG, "点击时间"+name);


            }
        });

        Log.i(TAG, "onCreate: ");


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, null);


        adapter = new PhoneAdapter<PhoneEntity>(getActivity(),R.layout.list_item_phone,phoneEntities);
        listview = view.findViewById(R.id.listview);
        listview.setAdapter(adapter);


        initPhoneEntities();

        return view;
    }


    public void initPhoneEntities() {


            PhoneEntity wang = new PhoneEntity("小王","13654213768",R.drawable.phone_photo);
            phoneEntities.add(wang);

            PhoneEntity shen = new PhoneEntity("沈洁","17053542678",R.drawable.phone_photo);
            phoneEntities.add(shen);

            PhoneEntity yang = new PhoneEntity("杨哥","18862245739",R.drawable.phone_photo);
            phoneEntities.add(yang);

            PhoneEntity che = new PhoneEntity("车姐","15140347082",R.drawable.phone_photo);
            phoneEntities.add(che);

            PhoneEntity sha = new PhoneEntity("沙同洋","13140256890",R.drawable.phone_photo);
            phoneEntities.add(sha);

            PhoneEntity yu = new PhoneEntity("于志海","18142456785",R.drawable.phone_photo);
            phoneEntities.add(yu);

            PhoneEntity liang = new PhoneEntity("梁渚海","13020264738",R.drawable.phone_photo);
            phoneEntities.add(liang);


    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle = data.getExtras();
        name = bundle.getString("name");
        number = bundle.getString("number");
        Log.i(TAG, name);

    }


    private void addPhotoEnger(){

        PhoneEntity exam = new PhoneEntity(name, number, R.drawable.phone_photo);
        phoneEntities.add(exam);

        Toast.makeText(getActivity(),name,Toast.LENGTH_SHORT);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

}