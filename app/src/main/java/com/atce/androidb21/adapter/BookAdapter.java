package com.atce.androidb21.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.atce.androidb21.R;
import com.atce.androidb21.model.ApplicationModel;
import com.atce.androidb21.model.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {
    private List<Book> appList;

    public BookAdapter(List<Book> appList) {
        this.appList = appList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.application_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book app = appList.get(position);
        holder.appName.setText(app.getTitle()+"\n"+app.getEdition()+"\n"+app.getId());
        // Set app icon using Glide or Picasso library
//        Glide.with(holder.itemView.getContext())
//                .load(app.getAppIcon())
//                .diskCacheStrategy(DiskCacheStrategy.DATA)
//                .into(holder.appIcon);
//        Picasso.get().load(app.getAppIcon()).into(holder.appIcon);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(), "ID:"+app.getId(), Toast.LENGTH_LONG).show();
                showDialogtoUpdate(holder.itemView.getContext(),app);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(holder.itemView.getContext());
                builder.setTitle("Delete Book")
                        .setMessage("Are you sure you want delete Book "+app.getTitle()+" ?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Book book=Book.findById(Book.class,app.getId());
                                book.delete();
                                Toast.makeText(holder.itemView.getContext(), "Book Deleted Successfully!", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        }).setNegativeButton("Cancel",null).show();
                return true;
            }
        });

    }

    private void showDialogtoUpdate(Context context, Book book) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.update_sqlite_dialog,null);
        AlertDialog.Builder builder=new AlertDialog.Builder(context);

        EditText edtEdition=view.findViewById(R.id.edtEdition);
        EditText edtTitle=view.findViewById(R.id.edtTitle);
        Button btnSave=view.findViewById(R.id.btnSave);
        edtTitle.setText(book.getTitle()+"");
        edtEdition.setText(book.getEdition()+"");

        builder.setView(view);
        AlertDialog dialog=builder.create();
        dialog.show();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book updated=Book.findById(Book.class,book.getId());
                updated.setTitle(edtTitle.getText().toString());
                updated.setEdition(edtEdition.getText().toString());
                updated.save();
                Toast.makeText(context, "Book Updated Successfully!", Toast.LENGTH_SHORT).show();
                edtTitle.setText("");
                edtEdition.setText("");
                dialog.dismiss();
            }
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView appName;
        ImageView appIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            appName = itemView.findViewById(R.id.app_name);
            appIcon = itemView.findViewById(R.id.app_icon);
        }
    }
}
