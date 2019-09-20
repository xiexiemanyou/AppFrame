package com.mango.myframe.homepage;

import androidx.lifecycle.MutableLiveData;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/19.
 */
public class HomePageItem {

    private  String artist;
    private  String thumb ;
    private  String title ;

    public HomePageItem(String artist, String thumb,String title){
        this.artist = artist;
        this.thumb = thumb;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
