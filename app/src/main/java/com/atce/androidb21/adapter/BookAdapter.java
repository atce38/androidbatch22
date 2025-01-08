package com.atce.androidb21.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
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
        holder.appName.setText(app.getTitle()+"\n"+app.getEdition());
        // Set app icon using Glide or Picasso library
//        Glide.with(holder.itemView.getContext())
//                .load(app.getAppIcon())
//                .diskCacheStrategy(DiskCacheStrategy.DATA)
//                .into(holder.appIcon);
//        Picasso.get().load(app.getAppIcon()).into(holder.appIcon);

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
