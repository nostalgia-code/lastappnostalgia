package com.example.nostalgia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddLocations extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mDatabase;
    private Button btnsave ;

    private EditText editTextName;
    private EditText editTextLatitude;
    private EditText editTextLongitude;
    String NameLOC;
    double lat , lng;
    Intent intent;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_locations);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editTextName=(EditText)findViewById(R.id.name);
        editTextLatitude=(EditText)findViewById(R.id.Lat);
        editTextLongitude=(EditText)findViewById(R.id.Long);

        btnsave=(Button)findViewById(R.id.btnsave);
        btnsave.setOnClickListener(this);


        final String Points = getIntent().getStringExtra("data");

        //Toast.makeText(getApplicationContext() , Points + " " , Toast.LENGTH_LONG).show();
        String[] parts = Points.split(",", 2);
        String part1 = parts[0];
        String part2 = parts[1];
        editTextLatitude.setText(part1);
        editTextLongitude.setText(part2);



    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


            MenuInflater menuInflater = getMenuInflater();
            menuInflater.inflate(R.menu.tohome, menu);

            return true;




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.TOHOME: {

                Intent in1 = new Intent(AddLocations.this, Main.class);
                startActivity(in1);

            }


            break;


        }
        return true;
    }



            private void saveUserInformation(){


        String ln=editTextLatitude.getText().toString().trim();
        String lg = editTextLongitude.getText().toString().trim();
        NameLOC = editTextName.getText().toString().trim();









        if(NameLOC.isEmpty() ||ln.isEmpty() ||lg.isEmpty()  )/* ||  TextUtils.isEmpty(editTextLatitude.getText().toString())||  TextUtils.isEmpty(editTextLongitude.getText().toString()))*/ {
            Toast.makeText(getApplicationContext(), "Fields can't be empty.", Toast.LENGTH_LONG).show();
        }
        else{


            lat = Double.parseDouble(editTextLatitude.getText().toString().trim());
            lng = Double.parseDouble(editTextLongitude.getText().toString().trim());









            DatabaseReference M = FirebaseDatabase.getInstance().getReference();
            firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
            HashMap<String, Object> hashMap = new HashMap<>();

            hashMap.put("Name", NameLOC);
            hashMap.put("ID", firebaseUser.getUid());
            hashMap.put("latitude", lat);
            hashMap.put("Longitude", lng);

            M.child("LoctionsUsers").push().setValue(hashMap);

            //  mDatabase.child("LoctionsUsers").child(firebaseUser.getUid()).child("Loc"+i+"").setValue(userInformation);

            // Showing Toast message after successfully data submit.
            Toast.makeText(AddLocations.this, "Data Saved", Toast.LENGTH_LONG).show();



        }
    }




    @Override
    public void onClick(View view) {
        if (view==btnsave){
            saveUserInformation( );
            editTextName.getText().clear();
            editTextLatitude.getText().clear();
            editTextLongitude.getText().clear();
        }
    }
}
