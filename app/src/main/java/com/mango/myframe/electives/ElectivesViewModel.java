package com.mango.myframe.electives;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class ElectivesViewModel extends ViewModel {

    private final MutableLiveData<String> mItemImgUrl = new MutableLiveData<>();
    private final MutableLiveData<String> mElectivesName = new MutableLiveData<>();


    public MutableLiveData<String> getItemImgUrl() {
        return mItemImgUrl;
    }

    public MutableLiveData<String> getElectivesName() {
        return mElectivesName;
    }

}
