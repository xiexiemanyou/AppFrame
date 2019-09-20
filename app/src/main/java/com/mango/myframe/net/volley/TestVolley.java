package com.mango.myframe.net.volley;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mango.myframe.MyFrameApp;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/04.
 */
public class TestVolley {

    RequestQueue mQueue = Volley.newRequestQueue(MyFrameApp.getInstance());

    private final MutableLiveData<String> content = new MutableLiveData<>();

    public MutableLiveData<String> getContent() {
        return content;
    }

    public void setContent(){
        content.setValue("mangoAAA");
    }


    //StringRequest
    public void sendStringRequest(){
        //当然首先尝试一下访问百度了
        String url = "https://www.baidu.com";


        /**
         * 创建一个StringRequest对象
         * 参数说明：
         * 1.请求方法
         * 2.目标服务器的URL地址
         * 3.服务器响应成功的回调
         * 1.服务器响应失败的回调
         **/
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                content.setValue(response.substring(0,500) + "mango");
                Log.d("mango", "onResponse: + " + response.substring(0,500));
                content.setValue(response.substring(0,500));
//                content.setValue("mango" + response.substring(0,500));
//                mTextView.setText("The StringRequest's response is "+ response.substring(0,500));
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                content.setValue("The StringRequest's response is: That didn't work!");
//                mTextView.setText("The StringRequest's response is: That didn't work!" );
            }
        });
        //将StringRequest放入请求队列中即可
        mQueue.add(stringRequest);
        /*以下为POST方式，需要传递数据时的处理
        StringRequest stringRequestPost = new StringRequest(Request.Method.POST, url, new MyResponse.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new MyResponse.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("param1","value1");
                map.put("param2","value2");
                return map;
            }
        }
        mQueue.add(stringRequestPost);
        */


    }

}
