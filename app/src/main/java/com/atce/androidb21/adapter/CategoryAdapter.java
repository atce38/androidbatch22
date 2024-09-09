package com.atce.androidb21.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.atce.androidb21.R;
import com.atce.androidb21.model.CategoryModel;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private List<CategoryModel> categoryList;

    public CategoryAdapter(List<CategoryModel> categoryList) {
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CategoryModel category = categoryList.get(position);
        holder.categoryName.setText(category.getCategoryName());

        // Set up the horizontal RecyclerView
        ApplicationAdapter applicationAdapter = new ApplicationAdapter(category.getApplicationList());
        holder.horizontalRecyclerView.setLayoutManager(
                new LinearLayoutManager(holder.itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.horizontalRecyclerView.setAdapter(applicationAdapter);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        RecyclerView horizontalRecyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            horizontalRecyclerView = itemView.findViewById(R.id.horizontal_recycler_view);
        }
    }

}
