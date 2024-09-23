package com.atce.androidb21;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.Firebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class StudentListActivity extends AppCompatActivity {

    RecyclerView studentListView;
    List<Student> students=new ArrayList<>();
    StudentAdapter adapter;
    DatabaseReference db;
    EditText edtName,edtPhone,edtAddress;
    Button btnUpdate;
    String node;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_list);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db= FirebaseDatabase.getInstance().getReference("Students");


       /* for (int i=0;i<100;i++){
            students.add(new Student("Name:"+(i+1),"123587885"+i,"Address:00"+i));
        }*/
        studentListView=findViewById(R.id.studentListView);
        edtName=findViewById(R.id.edtName);
        edtPhone=findViewById(R.id.edtPhone);
        edtAddress=findViewById(R.id.edtAddress);
        btnUpdate=findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (node !=null){
                    String name=edtName.getText().toString();
                    String phone=edtPhone.getText().toString();
                    String address=edtAddress.getText().toString();
                    updateStudent(name,phone,address);


                }else{
                    Toast.makeText(StudentListActivity.this, "Please Select Student to Update", Toast.LENGTH_SHORT).show();
                }

            }
        });



        studentListView.setHasFixedSize(true);
//        studentListView.setLayoutManager(new GridLayoutManager(this,3));
        studentListView.setLayoutManager(new LinearLayoutManager(this));

         adapter=new StudentAdapter(this,students);
         studentListView.setAdapter(adapter);

         adapter.setOnStudentClick(new OnStudentClick() {
             @Override
             public void onClick(int position) {
                 Student clickedStudent=students.get(position);
                 node=clickedStudent.node;
                 edtName.setText(clickedStudent.getName());
                 edtPhone.setText(clickedStudent.getPhone());
                 edtAddress.setText(clickedStudent.getAddress());


             }
         });

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                students.clear();
                for (DataSnapshot ds:snapshot.getChildren()){
                    Student student=ds.getValue(Student.class);
                    students.add(student);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    private void updateStudent(String name, String phone, String address) {
        Map<String, Object> data=new HashMap<>();
        data.put("name",name);
        data.put("address",address);
        data.put("phone",phone);

        db.child(node).updateChildren(data).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(StudentListActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                node=null;
                edtAddress.setText("");
                edtPhone.setText("");
                edtName.setText("");
                Toast.makeText(StudentListActivity.this, "Data Successfully Updated!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}