package com.mango.myframe.electives;

import androidx.lifecycle.MutableLiveData;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/27.
 */
public class ElectivesItem {

    private final MutableLiveData<String> name = new MutableLiveData<>();
    private final MutableLiveData<Integer> age = new MutableLiveData<>();

    public ElectivesItem(String name, int age){
        this.name.setValue(name);
        this.age.setValue(age);
    }

    public MutableLiveData<String> getName() {
        return name;
    }

    public MutableLiveData<Integer> getAge() {
        return age;
    }
}
