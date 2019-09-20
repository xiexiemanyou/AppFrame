package com.mango.myframe;

import android.app.Application;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.mango.myframe.electives.ElectivesViewModel;
import com.mango.myframe.homepage.HomePageViewModel;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private static volatile ViewModelFactory INSTANCE;

    public static ViewModelFactory getInstance(Application application) {

        if (INSTANCE == null) {
            synchronized (ViewModelFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ViewModelFactory();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass){
        if(modelClass.isAssignableFrom(ElectivesViewModel.class)){
            return (T) new ElectivesViewModel();
        }else if(modelClass.isAssignableFrom(HomePageViewModel.class)){
            return (T) new HomePageViewModel();
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }


}
