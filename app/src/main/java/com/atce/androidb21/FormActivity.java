package com.atce.androidb21;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class FormActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Spinner citySpinner;
    String [] cities={"Select City","Gujranwala","Lahore","Kamoke","Gujrat"};
    RadioGroup genderGrp;
    Button btnSave;
    String selected_city;
    CheckBox bio,eng,urdu;
    DrawerLayout drawer_layout;
    NavigationView navigation_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer_layout=findViewById(R.id.drawer_layout);
        navigation_view=findViewById(R.id.navigation_view);
        navigation_view.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        citySpinner=findViewById(R.id.citySpinner);
        genderGrp=findViewById(R.id.genderGrp);
        btnSave=findViewById(R.id.btnSave);
        bio=findViewById(R.id.bio);
        eng=findViewById(R.id.eng);
        urdu=findViewById(R.id.urdu);

        ArrayAdapter<String> adapter=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citySpinner.setAdapter(adapter);

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_city=cities[position];


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton rdButton=findViewById(genderGrp.getCheckedRadioButtonId());
                String subjects="";

                Toast.makeText(FormActivity.this, "City: "+selected_city, Toast.LENGTH_SHORT).show();
                Toast.makeText(FormActivity.this, "Gender: "+rdButton.getText().toString(), Toast.LENGTH_SHORT).show();

                if(urdu.isChecked()){
                    subjects+=","+urdu.getText().toString();
                }
                if(eng.isChecked()){
                    subjects+=","+eng.getText().toString();
                }
                if(bio.isChecked()){
                    subjects+=","+bio.getText().toString();
                }
                Toast.makeText(FormActivity.this, "Select Subjects: "+subjects, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.item_settings){
            Toast.makeText(this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item_profile){
            Toast.makeText(this, "Profile is Clicked", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id == R.id.item_settings){
            Toast.makeText(this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item_profile){
            Toast.makeText(this, "Profile is Clicked", Toast.LENGTH_SHORT).show();
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }
}