package com.atce.androidb21;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder> {


    Context context;
    List<Student> studentList;
    OnStudentClick onStudentClick;

    public void setOnStudentClick(OnStudentClick onStudentClick) {
        this.onStudentClick = onStudentClick;
    }

    public StudentAdapter(Context context, List<Student> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.student_item,null,false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student=studentList.get(position);
        holder.txtName.setText(student.getName());
        holder.txtPhone.setText(student.getPhone());
        holder.txtAddress.setText(student.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStudentClick.onClick(position);
            }
        });
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeStudent(student.node);
            }
        });


    }

    private void removeStudent(String node) {
        DatabaseReference db= FirebaseDatabase.getInstance().getReference("Students");
        db.child(node).removeValue();
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }
}
