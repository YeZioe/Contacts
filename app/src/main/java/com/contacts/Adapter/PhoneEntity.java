package com.contacts.Adapter;

import android.widget.ListView;

import com.contacts.R;
import com.contacts.VIew.ContactsFragment;

import java.util.ArrayList;
import java.util.List;

public class PhoneEntity {


    private List<PhoneEntity> phoneEntities = new ArrayList<>();


    private String phoneNumber;//手机号
    private String Name;//手机联系人
    private int ImageId;//人物头像

    public PhoneEntity(String Name,String phoneNumber,int ImageId){

        this.Name = Name;
        this.phoneNumber = phoneNumber;
        this.ImageId = ImageId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneName() {
        return Name;
    }

    public void setPhoneName(String phoneName) {
        this.Name = phoneName;
    }

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }




}
