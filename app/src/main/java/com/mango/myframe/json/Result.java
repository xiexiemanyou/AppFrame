package com.mango.myframe.json;

import java.util.List;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/12.
 */
public class Result {

    private String channel;

    private String count;

    private String ch_name;

    private String artistid;

    private String avatar;

    private List<Songlist> songlist ;

    private String channelid;

    public void setChannel(String channel){
        this.channel = channel;
    }
    public String getChannel(){
        return this.channel;
    }
    public void setCount(String count){
        this.count = count;
    }
    public String getCount(){
        return this.count;
    }
    public void setCh_name(String ch_name){
        this.ch_name = ch_name;
    }
    public String getCh_name(){
        return this.ch_name;
    }
    public void setArtistid(String artistid){
        this.artistid = artistid;
    }
    public String getArtistid(){
        return this.artistid;
    }
    public void setAvatar(String avatar){
        this.avatar = avatar;
    }
    public String getAvatar(){
        return this.avatar;
    }
    public void setSonglist(List<Songlist> songlist){
        this.songlist = songlist;
    }
    public List<Songlist> getSonglist(){
        return this.songlist;
    }
    public void setChannelid(String channelid){
        this.channelid = channelid;
    }
    public String getChannelid(){
        return this.channelid;
    }
}
