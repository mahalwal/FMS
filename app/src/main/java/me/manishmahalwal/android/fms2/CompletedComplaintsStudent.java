package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        final String curUserEmail = mAuth.getCurrentUser().getEmail();
        final String curUserEmail = "mad@t.com";
        FirebaseDatabase.getInstance().getReference().child("CleanComplaint")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String num = snapshot.child("complaintNum").getValue().toString();
                            String to = snapshot.child("complaintTo").getValue().toString();
                            String room = snapshot.child("complaintRoom").getValue().toString();
                            String priorit = snapshot.child("priority").getValue().toString();
                            int priority = Integer.parseInt(priorit);
                            String description = snapshot.child("ComplaintDescription").getValue().toString();
                            String completed = snapshot.child("completed").getValue().toString();
                            String location = snapshot.child("locationBuilding").getValue().toString();
                            String from = snapshot.child("complaintFrom").getValue().toString();
                            if(from.equals(curUserEmail) == true && completed.equals("true")){

                                addComplaintStatusStudent(
                                        new ObjComplaintStatusStudent(
                                                description,
                                                num,
                                                room,
                                                to,
                                                "CleanComplaint",
                                                priority,
                                                location
                                        )
                                );
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");
//                        Toast.makeText(getApplicationContext(), "Maa Chud Gayi", Toast.LENGTH_LONG).show();

                    }
                });

        FirebaseDatabase.getInstance().getReference().child("AcComplaint")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String num = snapshot.child("complaintNum").getValue().toString();
                            String to = snapshot.child("complaintTo").getValue().toString();
                            String room = snapshot.child("complaintRoom").getValue().toString();
                            String priorit = snapshot.child("priority").getValue().toString();
                            int priority = Integer.parseInt(priorit);
                            String description = snapshot.child("ComplaintDescription").getValue().toString();
                            String completed = snapshot.child("completed").getValue().toString();
                            String location = snapshot.child("locationBuilding").getValue().toString();
                            String from = snapshot.child("complaintFrom").getValue().toString();
                            if(from.equals(curUserEmail) == true && completed.equals("true")){

                                addComplaintStatusStudent(
                                        new ObjComplaintStatusStudent(
                                                description,
                                                num,
                                                room,
                                                to,
                                                "AcComplaint",
                                                priority,
                                                location
                                        )
                                );
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");
//                        Toast.makeText(getApplicationContext(), "Maa Chud Gayi", Toast.LENGTH_LONG).show();

                    }
                });

        FirebaseDatabase.getInstance().getReference().child("CarpentComplaint")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String num = snapshot.child("complaintNum").getValue().toString();
                            String to = snapshot.child("complaintTo").getValue().toString();
                            String room = snapshot.child("complaintRoom").getValue().toString();
                            String priorit = snapshot.child("priority").getValue().toString();
                            int priority = Integer.parseInt(priorit);
                            String description = snapshot.child("ComplaintDescription").getValue().toString();
                            String completed = snapshot.child("completed").getValue().toString();
                            String location = snapshot.child("locationBuilding").getValue().toString();
                            String from = snapshot.child("complaintFrom").getValue().toString();
                            if(from.equals(curUserEmail) == true && completed.equals("true")){

                                addComplaintStatusStudent(
                                        new ObjComplaintStatusStudent(
                                                description,
                                                num,
                                                room,
                                                to,
                                                "CarpentComplaint",
                                                priority,
                                                location
                                        )
                                );
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");
//                        Toast.makeText(getApplicationContext(), "Maa Chud Gayi", Toast.LENGTH_LONG).show();

                    }
                });

        FirebaseDatabase.getInstance().getReference().child("ElectricComplaint")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String num = snapshot.child("complaintNum").getValue().toString();
                            String to = snapshot.child("complaintTo").getValue().toString();
                            String room = snapshot.child("complaintRoom").getValue().toString();
                            String priorit = snapshot.child("priority").getValue().toString();
                            int priority = Integer.parseInt(priorit);
                            String description = snapshot.child("ComplaintDescription").getValue().toString();
                            String completed = snapshot.child("completed").getValue().toString();
                            String location = snapshot.child("locationBuilding").getValue().toString();
                            String from = snapshot.child("complaintFrom").getValue().toString();
                            if(from.equals(curUserEmail) == true && completed.equals("true")){

                                addComplaintStatusStudent(
                                        new ObjComplaintStatusStudent(
                                                description,
                                                num,
                                                room,
                                                to,
                                                "ElectricComplaint",
                                                priority,
                                                location
                                        )
                                );
                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");
//                        Toast.makeText(getApplicationContext(), "Maa Chud Gayi", Toast.LENGTH_LONG).show();

                    }
                });



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
