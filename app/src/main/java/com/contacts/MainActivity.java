package com.contacts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Window;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.contacts.VIew.ContactsFragment;
import com.contacts.VIew.FavoritesFragment;
import com.contacts.VIew.IncommingFragment;
import com.contacts.VIew.PostcardFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{


    private RadioGroup RGroup;

    private RadioButton RBIncomming;
    private RadioButton RBContacts;
    private RadioButton RBFavorites;
    private RadioButton RBPostcard;

    private ContactsFragment ContFram;
    private IncommingFragment IncoFram;
    private FavoritesFragment FavoFram;
    private PostcardFragment PostFram;

    private FragmentTransaction transaction;


    private  TextView TitleBarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //屏蔽系统自带的导航栏
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        build();

        //初次开启应用，默认显示在联系人界面
        RBContacts.setChecked(true);

        if(ContFram==null){
            ContFram = new ContactsFragment();
            transaction.add(R.id.fragment_view,ContFram);
        }else{
            transaction.show(ContFram);
        }

    }

    public void build(){

        RGroup = findViewById(R.id.tab_menu);
        RGroup.setOnCheckedChangeListener(this);

        RBIncomming = findViewById(R.id.rb_incomming);
        RBContacts = findViewById(R.id.rb_contacts);
        RBFavorites = findViewById(R.id.rb_favorite);
        RBPostcard = findViewById(R.id.rb_postcard);


        TitleBarTxt = findViewById(R.id.titlt_text);


    }



    public void hideAllFragment(FragmentTransaction transaction){
        if(ContFram!=null){
            transaction.hide(ContFram);
        }
        if(IncoFram!=null){
            transaction.hide(IncoFram);
        }
        if(FavoFram!=null){
            transaction.hide(FavoFram);
        }
        if(PostFram!=null){
            transaction.hide(PostFram);
        }
    }

    public void onCheckedChanged(RadioGroup group, int checkedId){

        transaction = getFragmentManager().beginTransaction();

        hideAllFragment(transaction);


        switch(checkedId){
            case R.id.rb_contacts:

                TitleBarTxt.setText("联系人");

                if(ContFram==null){
                    ContFram = new ContactsFragment();
                    transaction.add(R.id.fragment_view,ContFram);
                }else{
                    transaction.show(ContFram);
                }

                break;

            case R.id.rb_incomming:

                TitleBarTxt.setText("来电显示");


                break;

            case R.id.rb_favorite:

                TitleBarTxt.setText("备忘");


                break;

            case R.id.rb_postcard:

                TitleBarTxt.setText("我的名片");

                break;

        }

        transaction.commit();

    }


}


