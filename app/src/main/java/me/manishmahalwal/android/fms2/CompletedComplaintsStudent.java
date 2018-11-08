package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class CompletedComplaintsStudent extends Fragment {

    List<ObjComplaintStatusStudent> objComplaintStatusList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v= inflater.inflate(R.layout.fragment_cc, container, false);
        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rv2);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        objComplaintStatusList = new ArrayList<>();


        addComplaintStatusStudent(
                new ObjComplaintStatusStudent(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.5,
                        60000));

        addComplaintStatusStudent(
                new ObjComplaintStatusStudent(
                        1,
                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
                        "14 inch, Gray, 1.659 kg",
                        4.5,
                        60000));

        addComplaintStatusStudent(
                new ObjComplaintStatusStudent(
                        1,
                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        60000));

        //creating recyclerview adapter
        ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        return v;

    }

    public void addComplaintStatusStudent(ObjComplaintStatusStudent myObj)
    {
        objComplaintStatusList.add(myObj);
    }
}
