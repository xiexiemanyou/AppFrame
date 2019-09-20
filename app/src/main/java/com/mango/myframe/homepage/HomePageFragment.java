package com.mango.myframe.homepage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;
import com.mango.myframe.BR;
import com.mango.myframe.MyFrameApp;
import com.mango.myframe.R;
import com.mango.myframe.ViewModelFactory;
import com.mango.myframe.adapter.RecyclerViewAdapter;
import com.mango.myframe.databinding.FragmentHomeBinding;
import com.mango.myframe.net.volley.MyVolley;
import com.mango.myframe.net.volley.TestVolley;

import java.util.ArrayList;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class HomePageFragment extends Fragment {

    private TestVolley volley = new TestVolley();
    private HomePageViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        final FragmentHomeBinding binding = FragmentHomeBinding.bind(view);
        binding.setLifecycleOwner(this);
        binding.homeRecyclerView.setLayoutManager(new GridLayoutManager(binding.homeRecyclerView.getContext(), 2));
        ViewModelFactory factory = ViewModelFactory.getInstance(MyFrameApp.getInstance());
        mViewModel = ViewModelProviders.of(this, factory).get(HomePageViewModel.class);
        mViewModel.getItemsLiveData().observe(this, new Observer<ArrayList<HomePageItem>>() {
            @Override
            public void onChanged(ArrayList<HomePageItem> homePageItems) {
                binding.setRecyclerViewAdapter(new RecyclerViewAdapter(homePageItems, R.layout.item_homepage, BR.item));
            }
        });

        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        volley.sendStringRequest();
        MyVolley.getInstance().sendStringRequest("https://api.apiopen.top/musicBroadcastingDetails?channelname=public_tuijian_spring", mViewModel);

    }

    @BindingAdapter(value = {"thumb"})
    public static void loadImage(ImageView imageView, String url){
        Glide.with(imageView)
                .load(url)
                .into(imageView);
    }

}
