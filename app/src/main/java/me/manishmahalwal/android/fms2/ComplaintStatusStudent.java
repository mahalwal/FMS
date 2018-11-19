package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ComplaintStatusStudent extends Fragment implements EditComplaintStatusStudentDialog.DialogListener{


    List<ObjComplaintStatusStudent> objComplaintStatusList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_cs, container, false);
        final RecyclerView recyclerView = v.findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final FloatingActionButton fab = v.findViewById(R.id.fab);
        fab.setImageResource(R.drawable.ic_add_blac);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                EditComplaintStatusStudentDialog dialogFragment = new EditComplaintStatusStudentDialog();
//
//                Bundle bundle = new Bundle();
//                bundle.putBoolean("notAlertDialog", true);
//                dialogFragment.setArguments(bundle);
//
                Fragment newFragment = new RegisterComplaintStudent();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack if needed
                transaction.replace(R.id.fragment_container, newFragment);
                transaction.addToBackStack(null);

                // Commit the transaction
                transaction.commit();

            }
        });

        objComplaintStatusList = new ArrayList<>();
//        addComplaintStatusStudent(
//                new ObjComplaintStatusStudent(
//                        "r3",
//                        "edwq",
//                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
//                        "14 inch, Gray, 1.659 kg",
//                        "4.3",
//                        1,
//                        "dwe"));
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
//        final String curUserEmail = mAuth.getCurrentUser().getEmail();
        final String curUserEmail = mAuth.getCurrentUser().getEmail();
        Log.d("CheckC", curUserEmail);


        FirebaseDatabase.getInstance().getReference("CleanComplaint")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren())
                        {
                            Log.d("Check2.1","iterate");
                            CleanComplaint temp=snapshot.getValue(CleanComplaint.class);
                            if(temp.complaintFrom.equals(curUserEmail) && temp.completed.equals("false"))
                            {
                                objComplaintStatusList.add(
                                        new ObjComplaintStatusStudent(
                                                temp.ComplaintDescription,
                                                temp.complaintNum,
                                                temp.complaintRoom,
                                                temp.complaintTo,
                                                "Room Cleaning",
                                                temp.priority,
                                                temp.locationBuilding
                                        )
                                );
                                ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);
                                recyclerView.setAdapter(adapter);
                            }

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");

                    }
                });

        FirebaseDatabase.getInstance().getReference().child("AcComplaint")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren())
                        {
                            Log.d("Check2.2","iterate");
                            AcComplaint temp=snapshot.getValue(AcComplaint.class);
                            if(temp.complaintFrom.equals(curUserEmail) && temp.completed.equals("false"))
                            {
                                objComplaintStatusList.add(
                                        new ObjComplaintStatusStudent(
                                                temp.ComplaintDescription,
                                                temp.complaintNum,
                                                temp.complaintRoom,
                                                temp.complaintTo,
                                                "AC Servicing",
                                                temp.priority,
                                                temp.locationBuilding
                                        )
                                );
                                ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);
                                recyclerView.setAdapter(adapter);
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
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren())
                        {
                            Log.d("Check2.2","iterate");
                            CarpentComplaint temp=snapshot.getValue(CarpentComplaint.class);
                            if(temp.complaintFrom.equals(curUserEmail) && temp.completed.equals("false"))
                            {
                                objComplaintStatusList.add(
                                        new ObjComplaintStatusStudent(
                                                temp.ComplaintDescription,
                                                temp.complaintNum,
                                                temp.complaintRoom,
                                                temp.complaintTo,
                                                "Carpenter",
                                                temp.priority,
                                                temp.locationBuilding
                                        )
                                );
                                ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);
                                recyclerView.setAdapter(adapter);
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
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot)
                    {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren())
                        {
                            Log.d("Check2.2","iterate");
                            ElectricComplaint temp=snapshot.getValue(ElectricComplaint.class);
                            if(temp.complaintFrom.equals(curUserEmail) && temp.completed.equals("false"))
                            {
                                objComplaintStatusList.add(
                                        new ObjComplaintStatusStudent(
                                                temp.ComplaintDescription,
                                                temp.complaintNum,
                                                temp.complaintRoom,
                                                temp.complaintTo,
                                                "Electric",
                                                temp.priority,
                                                temp.locationBuilding
                                        )
                                );
                                ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);
                                recyclerView.setAdapter(adapter);
                            }

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("AboutStudent", "NOT POSSIBLE");

                    }
                });



        //creating recyclerview adapter
//        Log.d("Check5",objComplaintStatusList.size()+"");
//        ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);
//
//        //setting adapter to recyclerview
//        recyclerView.setAdapter(adapter);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy){
                if (dy > 0 || dy<0 && fab.isShown())
                    fab.hide();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    fab.show();
                }
                super.onScrollStateChanged(recyclerView, newState);
            }
        });

        /*
         * add onclicklistener for each recyclerview item
         *
         * */

        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if(child != null && gestureDetector.onTouchEvent(e)) {


                    int position = rv.getChildAdapterPosition(child);
                    Toast.makeText(getActivity(), Integer.toString(position), Toast.LENGTH_SHORT).show();

                    EditComplaintStatusStudentDialog dialogFragment = new EditComplaintStatusStudentDialog();

                    Bundle bundle = new Bundle();
                    bundle.putBoolean("notAlertDialog", true);

                    dialogFragment.setArguments(bundle);

                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    Fragment prev = getFragmentManager().findFragmentByTag("dialog");
                    if (prev != null) {
                        ft.remove(prev);
                    }
                    ft.addToBackStack(null);

                    dialogFragment.show(ft, "dialog");

                }

                return false;
            }



            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });




        return v;

    }

    public void addComplaintStatusStudent(ObjComplaintStatusStudent myObj)
    {
        objComplaintStatusList.add(myObj);
    }

    /*
     * When dialog box is closed this is called so you can use it to update the information entered by the user
     *
     * */
    @Override
    public void onFinishEditDialog(String inputText) {

        if (TextUtils.isEmpty(inputText)) {
            Toast.makeText(getActivity(), "Email was not entered", Toast.LENGTH_SHORT);
        }
        else
            Toast.makeText(getActivity(), "Email: " + inputText, Toast.LENGTH_SHORT);
    }
}