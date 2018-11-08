package me.manishmahalwal.android.fms2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Student extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public DrawerLayout draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(Student.this,"Started!",Toast.LENGTH_SHORT).show();

        setContentView(R.layout.activity_student);
        Toolbar tb = findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        draw = findViewById(R.id.dl);
        NavigationView nv=findViewById(R.id.nav_view);

        nv.setNavigationItemSelectedListener(this);
        /*View headerview = nv.getHeaderView(0);
        ImageView img = (ImageView)headerview.findViewById(R.id.IV);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ab()).commit();
                Toast.makeText(getApplicationContext(),"ytr", Toast.LENGTH_LONG).show();
            }

        });*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, draw, tb, R.string.ndopen, R.string.ndclose);
        draw.addDrawerListener(toggle);

        toggle.syncState();
        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ComplaintStatusStudent()).commit();
            nv.setCheckedItem(R.id.CS);
        }




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //check and replace with switch and break cases
        if (item.getItemId()==R.id.CS)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ComplaintStatusStudent()).commit();

        }
        else if (item.getItemId()==R.id.C)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new RegisterComplaintStudent()).commit();

        }
        else if (item.getItemId()==R.id.FD)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new FeedbackStudent()).commit();
        }
        else if (item.getItemId()==R.id.CC)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new CompletedComplaintsStudent()).commit();
        }
        else if (item.getItemId()==R.id.LO)
        {
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }

        else if (item.getItemId()==R.id.AB)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new AboutStudent()).commit();
          //  Toast.makeText(getApplicationContext(),"ytr", Toast.LENGTH_LONG).show();

        }


        draw.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed()
    {
        if (draw.isDrawerOpen(GravityCompat.START))
        {
            draw.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

}
