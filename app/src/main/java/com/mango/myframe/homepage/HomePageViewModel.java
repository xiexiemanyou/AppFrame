package com.mango.myframe.homepage;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mango.myframe.json.ResponseBean;
import com.mango.myframe.json.Songlist;
import com.mango.myframe.net.MyResponse;

import java.util.ArrayList;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class HomePageViewModel extends ViewModel implements MyResponse {

    private final int RESPONSE_SUCCESS = 200;

    private final MutableLiveData<ArrayList<HomePageItem>> itemsLiveData = new MutableLiveData<>();

    @Override
    public void onSuccess(ResponseBean response) {
        ArrayList<HomePageItem> items = new ArrayList<>();
        Log.d("mango", "onSuccess: response " + response.getCode());
        if(response != null && response.getCode() == RESPONSE_SUCCESS){
            ArrayList<Songlist> songlists = (ArrayList<Songlist>) response.getResult().getSonglist();
            if(!songlists.isEmpty()){
                for(Songlist songlist : songlists){
                    Log.d("mango", "onSuccess: songlist " + songlist.getTitle());
                    items.add(new HomePageItem(songlist.getArtist(), songlist.getThumb(), songlist.getTitle()));
                }
            }
            itemsLiveData.setValue(items);
        }

    }

    @Override
    public void onFailer() {

    }

    public LiveData<ArrayList<HomePageItem>> getItemsLiveData(){
        return itemsLiveData;
    }
}
