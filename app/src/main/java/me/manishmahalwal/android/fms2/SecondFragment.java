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

public class SecondFragment extends Fragment {

    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_cs, container, false);
        RecyclerView pl=(RecyclerView)v.findViewById(R.id.rv);
        pl.setLayoutManager(new LinearLayoutManager(getContext()));

        list_item c=new list_item("ID","         Staff Name","        Complaint Type","Posn in Queue");
        list_item a=new list_item("733","Ram Pal","Room Cleaning","7");
        list_item b=new list_item("934","Bob Seth","Room Cleaning","5");
        list_item[] lii={c, a, b};
        pl.setAdapter(new MyAdapter(lii));
        return v;


    }
}
