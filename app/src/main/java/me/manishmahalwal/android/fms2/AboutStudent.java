package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class AboutStudent extends Fragment {
    View myView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.fragment_ab, container, false);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Log.e("THIS", "STARTED");
        FirebaseDatabase.getInstance().getReference().child("ListOfUser")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String email = mAuth.getCurrentUser().getEmail();

                        Log.e("THIS", email);

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            String name = snapshot.child("name").getValue().toString();
                            String email_temp = snapshot.child("email").getValue().toString();
                            String phone = snapshot.child("number").getValue().toString();
                            String roll = snapshot.child("rollNo").getValue().toString();
                            String gender = snapshot.child("gender").getValue().toString();
                            if(email_temp.equals(email) == true){
                                Log.e("THIS", phone);
                                LayoutInflater lf = getActivity().getLayoutInflater();
                                TextView text = (TextView) myView.findViewById(R.id.textView4);
                                text.setText(email_temp);
                                TextView text2 = (TextView) myView.findViewById(R.id.textView3);
                                text2.setText(phone);

                                TextView text3 = (TextView) myView.findViewById(R.id.textView2);
                                text3.setText(roll);

                                TextView tex4 = (TextView) myView.findViewById(R.id.textView1);
                                tex4.setText(name);

                                TextView tex5 = (TextView) myView.findViewById(R.id.textView5);
                                tex5.setText(gender);

                                break;
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.e("THIS", "NOT POSSIBLE");
//                        Toast.makeText(getApplicationContext(), "Maa Chud Gayi", Toast.LENGTH_LONG).show();

                    }
                });

        return myView;
    }
}
