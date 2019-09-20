package com.mango.myframe.net.volley;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mango.myframe.MyFrameApp;
import com.mango.myframe.json.ResponseBean;
import com.mango.myframe.net.MyResponse;

import org.json.JSONObject;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/11.
 */
public class MyVolley {

    private final String URL = "https://api.apiopen.top/musicBroadcastingDetails?channelname=public_tuijian_spring";

    private final static RequestQueue mRequestQueue = Volley.newRequestQueue(MyFrameApp.getInstance());

    private Gson mGson;

    //饿汉模式
//    private final static MyVolley instance = new MyVolley();
//
//    private MyVolley(){}
//
//    public static MyVolley getInstance(){
//        return instance;
//    }

    //懒汉加载模式
//    private static  MyVolley instance = null;

//    private MyVolley(){}

//    public static MyVolley getInstance(){
//
//        if(instance == null) {
//            synchronized (this) {
//                if (instance == null) {
//                    instance = new MyVolley();
//                }
//            }
//        }
//
//        return instance;
//    }

    private MyVolley(){
        mGson = new GsonBuilder()
                .serializeNulls() //智能null
                .create();
    }

    private static class Holder{
        private static MyVolley instance = new MyVolley();
    }

    public static MyVolley getInstance(){
        return Holder.instance;
    }

    public void sendStringRequest(String url, final MyResponse myResponse){

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ResponseBean bean = mGson.fromJson(response, ResponseBean.class);
                myResponse.onSuccess(bean);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        mRequestQueue.add(stringRequest);

    }

    public <T> void sentJsonReques(String url, final MyResponse myResponse ){

        JsonObjectRequest objectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
            }
        }, new Response.ErrorListener() {
            @Override



            public void onErrorResponse(VolleyError error) {
                myResponse.onFailer();
            }
        });

        mRequestQueue.add(objectRequest);

    }



}
