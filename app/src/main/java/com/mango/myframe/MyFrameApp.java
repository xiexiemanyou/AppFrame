package com.mango.myframe;

import android.app.Application;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/07/29.
 */
public class MyFrameApp extends Application {

    private static MyFrameApp instance;

    public static MyFrameApp getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}
