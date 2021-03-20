package com.example.actividad3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    // Atts.
    public ArrayList<Model> item_list;
    public ModelAdapter(ArrayList<Model> arrayList) {
        item_list = arrayList;
    }

    @Override
    public ModelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);

        // create ViewHolder
        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ModelAdapter.ViewHolder holder, int position) {

        final int pos = position;

        holder.item_name.setText(item_list.get(position).getItemName());
        holder.chkSelected.setChecked(item_list.get(position).isSelected());
        holder.chkSelected.setTag(item_list.get(position));
        holder.image.setImageResource(item_list.get(position).getImage());

        // Listener Handler del click
        holder.chkSelected.setOnClickListener(new View.OnClickListener() {
            // Cuando clickea.
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                Model model = (Model) cb.getTag();
                model.setSelected(cb.isChecked());
                item_list.get(pos).setSelected(cb.isChecked());
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView item_name;
        public CheckBox chkSelected;
        public ImageView image;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            image = (ImageView) itemLayoutView.findViewById(R.id.imageView);
            item_name = (TextView) itemLayoutView.findViewById(R.id.txt_Name);
            chkSelected = (CheckBox) itemLayoutView.findViewById(R.id.chk_selected);
        }
    }

    @Override
    public int getItemCount() {
        return item_list.size();
    }
}