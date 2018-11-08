package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_cc, container, false);
        RecyclerView pl=(RecyclerView)v.findViewById(R.id.rv2);
        pl.setLayoutManager(new LinearLayoutManager(getContext()));
        list_item_2[] lii=new list_item_2[121];

        list_item_2 c=new list_item_2("ID","Staff Name","Complaint Type","Status");
        for (int i=1;i<121;i++){
            String temp=""+(i+1);
            lii[i]=new list_item_2(temp,"Ram Pal","Room Cleaning","Resolved");

        }
        ;




        lii[0]=c;
        pl.setAdapter(new MyAdapter_2(lii));
        return v;

    }
}
