package com.example.navbarfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class GalleryFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        /*View view =  inflater.inflate(R.layout.fragment_home, container, false);
        BottomNavigationView bottomNav = (BottomNavigationView)view.findViewById(R.id.nav_bar);
        bottomNav.getMenu().findItem(R.id.nav_gallery).setChecked(true);
        */
        return inflater.inflate(R.layout.fragment_gallery,container,false);   }

}
