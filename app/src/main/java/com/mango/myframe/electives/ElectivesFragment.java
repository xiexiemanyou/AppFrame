package com.mango.myframe.electives;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mango.myframe.MyFrameApp;
import com.mango.myframe.R;
import com.mango.myframe.ViewModelFactory;
import com.mango.myframe.adapter.RecyclerViewAdapter;
import com.mango.myframe.databinding.FragmentElectivesBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Project_name: My Frame
 * Created by iuu on 2019/08/09.
 */
public class ElectivesFragment extends Fragment {

    private ElectivesViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electives, container, false);
        FragmentElectivesBinding binding = FragmentElectivesBinding.bind(view);
        ViewModelFactory factory = ViewModelFactory.getInstance(MyFrameApp.getInstance());
        mViewModel = ViewModelProviders.of(this, factory).get(ElectivesViewModel.class);
        List<ElectivesItem> electivesItemList = new ArrayList<>();
        electivesItemList.add(new ElectivesItem("mango", 1));
        electivesItemList.add(new ElectivesItem("mango", 2));
        electivesItemList.add(new ElectivesItem("mango", 3));
        electivesItemList.add(new ElectivesItem("mango", 4));
        electivesItemList.add(new ElectivesItem("mango", 5));
        electivesItemList.add(new ElectivesItem("mango", 6));
        electivesItemList.add(new ElectivesItem("mango", 7));
        electivesItemList.add(new ElectivesItem("mango", 8));
        electivesItemList.add(new ElectivesItem("mango", 9));
        electivesItemList.add(new ElectivesItem("mango", 10));
        electivesItemList.add(new ElectivesItem("mango", 11));
        electivesItemList.add(new ElectivesItem("mango", 12));
        electivesItemList.add(new ElectivesItem("mango", 13));
        electivesItemList.add(new ElectivesItem("mango", 14));
        electivesItemList.add(new ElectivesItem("mango", 15));
        electivesItemList.add(new ElectivesItem("mango", 16));
        electivesItemList.add(new ElectivesItem("mango", 17));
        electivesItemList.add(new ElectivesItem("mango", 18));
        RecyclerViewAdapter<ElectivesItem> recyclerViewAdapter = new RecyclerViewAdapter<>(electivesItemList, R.layout.item_electives, com.mango.myframe.BR.item);
        binding.setRecyclerViewAdapter(recyclerViewAdapter);
        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), RecyclerView.VERTICAL, false));

        binding.setLifecycleOwner((LifecycleOwner) getActivity());
        return view;
    }

    @BindingAdapter("imageUrl")
    public static void bindImageUrl(ImageView view, String imageUrl){

    }

}
