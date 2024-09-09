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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ApplicationAdapter extends RecyclerView.Adapter<ApplicationAdapter.ViewHolder> {
    private List<ApplicationModel> appList;

    public ApplicationAdapter(List<ApplicationModel> appList) {
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
        ApplicationModel app = appList.get(position);
        holder.appName.setText(app.getAppName());
        // Set app icon using Glide or Picasso library
//        Glide.with(holder.itemView.getContext())
//                .load(app.getAppIcon())
//                .diskCacheStrategy(DiskCacheStrategy.DATA)
//                .into(holder.appIcon);
        Picasso.get().load(app.getAppIcon()).into(holder.appIcon);

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
