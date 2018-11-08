package me.manishmahalwal.android.fms2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Aj Kamal on 28-09-2018.
 */
public class RegisterComplaintStudent extends Fragment {
    public Button B1;
    public EditText E1;
    public EditText E2;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_c, container, false);
        B1= (Button)view.findViewById(R.id.button_submit);
        E1= (EditText) view.findViewById(R.id.editText);
        E2= (EditText) view.findViewById(R.id.editText2);
        //get last complaint id increment it and provide new
        Spinner spinner = (Spinner)view.findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),R.array.Complaint_Type,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(4);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selected=parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {


            }

        });
        Spinner spinner2 = (Spinner)view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getContext(),R.array.Building,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner2.setSelection(6);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
                String selected=parentView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {


            }

        });
        B1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String d=E1.getText().toString();
                String f=E2.getText().toString();
                /*int ff=Integer.parseInt(f);
                Map<String, Object> city = new HashMap<>();
                city.put("Complaint ID",c_id);
                city.put("Complaint Type", ff);
                */

//                mdb.child("Pending_Complaint").child("Complaint ID").setValue(1234);
                Toast.makeText(getContext(),"read",Toast.LENGTH_LONG).show();



            }
        });




        return  view;



    }



}
