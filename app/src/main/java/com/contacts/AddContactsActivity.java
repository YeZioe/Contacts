package com.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.contacts.VIew.ContactsFragment;

public class AddContactsActivity extends Activity implements View.OnClickListener{

    private static final String TAG = "AddContactsActivity";

    
    private TextView CanelTxt;
    private TextView Addtxt;

    private EditText AddName;
    private EditText AddNumber;

    private ContactsFragment cf;

    private String strName;
    private String strNumber;

    private FragmentManager fragmentManager;//主要用于在Activity中操作Fragment
    private FragmentTransaction transaction;//保证一些列Fragment操作的原子性,主要的操作都在这里


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcontacts);

        init();



    }


    public void init(){
        CanelTxt = findViewById(R.id.canel_txt);
        Addtxt = findViewById(R.id.add_txt);

        Addtxt.setOnClickListener(this);
        CanelTxt.setOnClickListener(this);

        AddName = findViewById(R.id.add_name);
        AddNumber = findViewById(R.id.add_number);

        AddName.addTextChangedListener(textWatcher);
        AddNumber.addTextChangedListener(textWatcher);

    }

    @Override
    public void onClick(View v){


        switch(v.getId()){
            case R.id.add_txt:


                Intent intent = new Intent(AddContactsActivity.this,ContactsFragment.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", AddName.getText().toString());
                bundle.putString("number", AddNumber.getText().toString());
                intent.putExtras(bundle);
                setResult(1,intent);
                finish();

                break;

            case R.id.canel_txt:

                Intent intent1 = new Intent(AddContactsActivity.this,ContactsFragment.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("name", AddName.getText().toString());
                bundle2.putString("number", AddNumber.getText().toString());
                intent1.putExtras(bundle2);
                setResult(1,intent1);
                finish();

                break;

        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent1 = new Intent(AddContactsActivity.this,ContactsFragment.class);
            Bundle bundle2 = new Bundle();
            bundle2.putString("name", AddName.getText().toString());
            bundle2.putString("number", AddNumber.getText().toString());
            intent1.putExtras(bundle2);
            setResult(1,intent1);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //这个方法是想用来监听按钮变色使用
    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {

            Log.i(TAG, "onTextChanged: ");
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            Log.i(TAG, "beforeTextChanged: ");

        }

        @Override
        public void afterTextChanged(Editable s) {
            Log.i(TAG, "afterTextChanged: ");

        }
    };



}
