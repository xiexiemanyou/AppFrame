package com.mango.myframe.net;

import com.mango.myframe.json.ResponseBean;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/09/12.
 */
public interface MyResponse {

   void onSuccess(ResponseBean response);

   void onFailer();

}
