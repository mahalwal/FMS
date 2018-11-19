package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ThirdFragment extends Fragment implements WorkerDialog.DialogListener{

    List<ObjComplaintStatusStudent> objComplaintStatusList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_cc, container, false);
        RecyclerView recyclerView = v.findViewById(R.id.rv2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        objComplaintStatusList = new ArrayList<>();

        addComplaintStatusStudent(
                new ObjComplaintStatusStudent(
                        "dummy",
                        "boy",
                        "fall",
                        "in love",
                        "he",
                        1,
                        "stoopid"
                ));

        //creating recyclerview adapter
        ObjComplaintStatusStudentAdapter adapter = new ObjComplaintStatusStudentAdapter(getActivity(), objComplaintStatusList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

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

                    WorkerDialog dialogFragment = new WorkerDialog();

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

