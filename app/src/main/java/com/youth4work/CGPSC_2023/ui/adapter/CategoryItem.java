package com.youth4work.CGPSC_2023.ui.adapter;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.fastadapter.items.AbstractItem;

import com.squareup.picasso.Picasso;
import com.youth4work.CGPSC_2023.R;
import com.youth4work.CGPSC_2023.network.model.Category;

public class CategoryItem extends AbstractItem<CategoryItem, CategoryItem.ViewHolder> {
    public Category category;
    String className;
    Context mContext;

    public CategoryItem(Category category, String className, Context cntext) {
        this.category = category;
        this.className = className;
        this.mContext = cntext;
    }

    @Override
    public int getType() {
        return R.id.category_item_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.item_main_category;
    }

    @Override
    public void bindView(ViewHolder viewHolder) {
        super.bindView(viewHolder);
        viewHolder.txtparentCat.setVisibility(View.GONE);
        //viewHolder.txtparentCat.setText(category.getParentCategory());
        viewHolder.txtAsp.setText(category.getAttempts()>1000?category.getAttempts()/1000+"k Aspirants":category.getAttempts()+" Aspirants");
        viewHolder.txtCat.setText(category.getCategory());

            if (!category.getSubCategoryImg().equals("") && category.getSubCategoryImg() != null)
            Picasso.with(mContext).load(category.getSubCategoryImg()).into(viewHolder.imgCat);


    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardCat;
        ImageView imgCat;
        TextView txtparentCat,txtCat,txtAsp;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardCat=itemView.findViewById(R.id.card_cat);
            imgCat=itemView.findViewById(R.id.img_cat);
            txtparentCat=itemView.findViewById(R.id.txt_parent_cat);
            txtAsp=itemView.findViewById(R.id.txt_asp);
            txtCat=itemView.findViewById(R.id.txt_cat);
        }
    }
}