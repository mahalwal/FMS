package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class FirstFragment extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.first_layout, container, false);
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
                            String email_temp = snapshot.child("email").getValue().toString();
                            if(email_temp.equals(email) == true){
                                LayoutInflater lf = getActivity().getLayoutInflater();
                                TextView text = (TextView) myView.findViewById(R.id.editText3);
                                text.setText(email_temp);
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
