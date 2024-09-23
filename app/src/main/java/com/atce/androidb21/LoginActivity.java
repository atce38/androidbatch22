package com.atce.androidb21;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    EditText edtEmail,edtPassword;
    Button btnSignup,btnSignin,btnForget;
    FirebaseAuth mAtuh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtEmail=findViewById(R.id.edtEmail);
        btnForget=findViewById(R.id.btnForget);
        edtPassword=findViewById(R.id.edtPassword);
        btnSignup=findViewById(R.id.btnSignup);
        btnSignin=findViewById(R.id.btnSignin);
        mAtuh=FirebaseAuth.getInstance();
// Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAtuh.getCurrentUser();
        if(currentUser != null){
            Common.startMyActivity(this,FormActivity.class);
        }
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.startMyActivity(LoginActivity.this,SignupActivity.class);
            }
        });
        btnForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Common.startMyActivity(LoginActivity.this,ResetPassowrdActivity.class);
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtEmail.getText().toString();
                String pass=edtPassword.getText().toString();
                performActionOnCLick(email,pass);

            }
        });
    }

    private void performActionOnCLick(String email, String pass) {
        mAtuh.signInWithEmailAndPassword(email,pass).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Common.startMyActivity(LoginActivity.this,FormActivity.class);
            }
        });
    }
}