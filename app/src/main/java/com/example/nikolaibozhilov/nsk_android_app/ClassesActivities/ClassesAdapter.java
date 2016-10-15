package com.example.nikolaibozhilov.nsk_android_app.ClassesActivities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nikolaibozhilov.nsk_android_app.IOnItemClicked;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Classes;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 11-Oct-16.
 */
public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.ViewHolder> {
    private static List<Classes> mDataset;

    private static IOnItemClicked callback;

    public void setCallBack(IOnItemClicked callback){
        this.callback = callback;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtClassName;
        public TextView txtClassRole;
        public ImageView imgClass;
        public LinearLayout classParent;

        public ViewHolder(View v) {
            super(v);
            txtClassName = (TextView) v.findViewById(R.id.txtClassItemName);
            txtClassRole = (TextView) v.findViewById(R.id.txtClassItemRole);
            imgClass = (ImageView) v.findViewById(R.id.imgClass);
            classParent = (LinearLayout) v.findViewById(R.id.classParent);

            classParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(callback!=null)
                        callback.onClassItemClicked(mDataset.get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ClassesAdapter(List<Classes> data, IOnItemClicked callback) {
        mDataset = data;
        this.setCallBack(callback);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ClassesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_items_view_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);
        holder.txtClassName.setText(mDataset.get(position).getClassName());

        holder.txtClassRole.setText(mDataset.get(position).getClassRole());

        holder.imgClass.setImageResource(mDataset.get(position).getClassImageURI());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
