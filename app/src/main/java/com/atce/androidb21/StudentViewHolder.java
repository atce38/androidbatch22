package com.atce.androidb21;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    public TextView txtName,txtPhone,txtAddress;
    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);

        txtPhone=itemView.findViewById(R.id.txtPhone);
        txtName=itemView.findViewById(R.id.txtName);
        txtAddress=itemView.findViewById(R.id.txtAddress);

    }
}
