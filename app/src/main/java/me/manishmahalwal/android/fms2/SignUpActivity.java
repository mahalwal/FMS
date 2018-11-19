package me.manishmahalwal.android.fms2;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    ProgressBar progressBar;
    EditText editTextEmail, editTextPassword, editTextPhone, editTextRoomNumber, editTextName;
    Spinner dropdown;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        dropdown = findViewById(R.id.spinner1);
        String[] items = new String[]{"Male", "Female"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextRoomNumber = findViewById(R.id.editTextRoomNumber);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.buttonSignUp).setOnClickListener(this);
        findViewById(R.id.textViewLogin).setOnClickListener(this);
    }

    private void registerUser() {
        String name = editTextName.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String phoneNo = editTextPhone.getText().toString().trim();
        String rollNo = editTextRoomNumber.getText().toString().trim();
        String gender=dropdown.getSelectedItem().toString();

        User user = new User(name, email, password, phoneNo, rollNo, gender);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("ListOfUser").child(user.email);

        myRef.setValue(user);
        Log.e("SignUpActivity", "newUserRegister");
        if (email.isEmpty()) {
            editTextEmail.setError("Email is required");
            editTextEmail.requestFocus();
            return;
        }

        if (rollNo.isEmpty()) {
            editTextRoomNumber.setError("Room Number is required");
            editTextRoomNumber.requestFocus();
            return;
        }

        if (phoneNo.isEmpty()) {
            editTextPhone.setError("Phone Number is required");
            editTextPhone.requestFocus();
            return;
        }


        if (name.isEmpty()) {
            editTextName.setError("Name is required");
            editTextName.requestFocus();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("Please enter a valid email");
            editTextEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            editTextPassword.setError("Password is required");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Minimum length of password should be 6");
            editTextPassword.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Log.e("SignUpActivity", "Authentication");
                    finish();
                    startActivity(new Intent(SignUpActivity.this, Student.class));
                }
                else {
                    if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                        Toast.makeText(getApplicationContext(), "You are already registered", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
//    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonSignUp:
                registerUser();
                break;

            case R.id.textViewLogin:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;
        }
    }
}