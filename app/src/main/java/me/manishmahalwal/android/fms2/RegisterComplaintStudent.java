package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.common.internal.service.CommonApi;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterComplaintStudent extends Fragment {
    public Button B1;
    public EditText E1;
    public EditText E2;
    public EditText E3;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        B1 = (Button)view.findViewById(R.id.button_submit);
        E1 = (EditText) view.findViewById(R.id.editText);
        E2 = (EditText) view.findViewById(R.id.editText2);
        E3 = (EditText) view.findViewById(R.id.editText9);
        final Spinner spinner = (Spinner)view.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.Complaint_Type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected=parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });
        final Spinner spinner2 = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.Building,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(6);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected=parentView.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }

        });
        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final String RoomNum=E1.getText().toString();
                final String Description=E2.getText().toString();
                final FirebaseAuth mAuth = FirebaseAuth.getInstance();
//                final String email = mAuth.getCurrentUser().getEmail();
                final String email = "mad@t.com";
                Toast.makeText(getContext(),"read",Toast.LENGTH_LONG).show();
                String ComplaintType = spinner.getSelectedItem().toString();
                final FirebaseDatabase database = FirebaseDatabase.getInstance();
                final String location = spinner2.getSelectedItem().toString();
                if(ComplaintType.equals("Room Cleaning")){

                    final DatabaseReference myRef = database.getReference("CleanID");
                    int upd;
                    myRef.addListenerForSingleValueEvent(new ValueEventListener(){
                    int val;
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = dataSnapshot.getValue(Integer.class);
                            int upd = val + 1;
                            myRef.setValue(upd);
                            final DatabaseReference myRef2 = database.getReference("CleanComplaint").child(upd+"");
                            Log.e("RegisterComplaint", upd +"");
                            CleanComplaint ct = new CleanComplaint(val + "", "Room Cleaning", email,"NULL", RoomNum, -1, Description, "false", location);
                            myRef2.setValue(ct);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else if(ComplaintType.equals("AC Servicing")){
                    final DatabaseReference myRef = database.getReference("ACID");

                    int upd;
                    myRef.addListenerForSingleValueEvent(new ValueEventListener(){
                        int val;
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = dataSnapshot.getValue(Integer.class);
                            int upd = val + 1;
                            final DatabaseReference myRef2 = database.getReference("AcComplaint").child(upd+"");
                            myRef.setValue(upd);
                            Log.e("RegisterComplaint", upd +"");
                            AcComplaint ct = new AcComplaint(val + "", "AC Servicing", email,"NULL", RoomNum, -1, Description, "false", location);
                            myRef2.setValue(ct);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else if(ComplaintType.equals("Carpenter")){
                    final DatabaseReference myRef = database.getReference("CarpenterID");
                    int upd;
                    myRef.addListenerForSingleValueEvent(new ValueEventListener(){
                        int val;
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = dataSnapshot.getValue(Integer.class);
                            int upd = val + 1;
                            final DatabaseReference myRef2 = database.getReference("CarpentComplaint").child(upd+"");
                            myRef.setValue(upd);
                            CarpentComplaint ct = new CarpentComplaint(val + "", "Carpenter", email,"NULL", RoomNum, -1, Description, "false", location);
                            Log.e("RegisterComplaint", upd +"");
                            myRef.setValue(ct);
                        }


                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else{
                    final DatabaseReference myRef = database.getReference("ElectricID");

                    int upd;
                    myRef.addListenerForSingleValueEvent(new ValueEventListener(){
                        int val;
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            val = dataSnapshot.getValue(Integer.class);
                            int upd = val + 1;
                            final DatabaseReference myRef2 = database.getReference("ElectricComplaint").child(upd+"");
                            myRef.setValue(upd);
                            ElectricComplaint ct = new ElectricComplaint(val + "", "Electric", email,"NULL", RoomNum, -1, Description, "false", location);
                            Log.e("RegisterComplaint", upd +"");
                            myRef2.setValue(ct);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
            }
        });

        return  view;

    }

}
