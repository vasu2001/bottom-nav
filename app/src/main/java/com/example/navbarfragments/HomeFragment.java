package com.example.navbarfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] data = {"A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H","A","B","C","D","E","F","G","H"};
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView programmingList = (RecyclerView)view.findViewById(R.id.recyclerView1);
        programmingList.setLayoutManager(new LinearLayoutManager(getActivity()));
        programmingList.setAdapter(new ProgrammingAdapter(data));

        return view;
    }
}
