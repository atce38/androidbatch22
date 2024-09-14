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
import androidx.fragment.app.Fragment;

import com.atce.androidb21.fragments.HomeFragment;
import com.atce.androidb21.fragments.ProfileFragment;
import com.atce.androidb21.fragments.SettingsFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class FormActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    DrawerLayout drawer_layout;
    NavigationView navigation_view;
    FirebaseAuth mAuth;
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
        mAuth=FirebaseAuth.getInstance();
        setSupportActionBar(toolbar);
        drawer_layout=findViewById(R.id.drawer_layout);
        navigation_view=findViewById(R.id.navigation_view);
        navigation_view.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.open,R.string.close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();
        HomeFragment homeFragment=new HomeFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.fr_container,homeFragment).commit();


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
        if(id == R.id.item_home){
            HomeFragment homeFragment=new HomeFragment();
            loadFragment(homeFragment);
            Toast.makeText(this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
        }
        if(id == R.id.item_settings){
            SettingsFragment settingsFragment=new SettingsFragment();
            loadFragment(settingsFragment);
            Toast.makeText(this, "Settings is Clicked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item_profile){
            ProfileFragment profileFragment=new ProfileFragment();
            loadFragment(profileFragment);
            Toast.makeText(this, "Profile is Clicked", Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.item_logout){
           mAuth.signOut();
           Common.startMyActivity(this,LoginActivity.class);
        }
        drawer_layout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void loadFragment(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.fr_container,fragment).commit();
    }
}