package com.mango.myframe.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.Volley;
import com.mango.myframe.R;
import com.mango.myframe.databinding.FragmentHomeBinding;
import com.mango.myframe.net.volley.TestVolley;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class HomePageFragment extends Fragment {

    private TestVolley volley = new TestVolley();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        FragmentHomeBinding binding = FragmentHomeBinding.bind(view);
        binding.setTestVolley(volley);
        binding.setLifecycleOwner(this);


        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        volley.sendStringRequest();
//        volley.setContentq();

    }
}
