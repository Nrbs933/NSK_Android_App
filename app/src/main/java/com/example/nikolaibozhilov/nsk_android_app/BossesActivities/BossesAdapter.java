package com.example.nikolaibozhilov.nsk_android_app.BossesActivities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.nikolaibozhilov.nsk_android_app.IOnItemClicked;
import com.example.nikolaibozhilov.nsk_android_app.R;
import com.example.nikolaibozhilov.nsk_android_app.model.Bosses;


import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Nikolai Bozhilov on 13-Oct-16.
 */

public class BossesAdapter extends RecyclerView.Adapter<BossesAdapter.ViewHolder> {
    private static List<Bosses> mDataset;

    private static IOnItemClicked callback;

    public void setCallBack(IOnItemClicked callback){
        this.callback = callback;
    }



    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout bossParent;
        public TextView bossNameTxt;

        public ViewHolder(View v) {
            super(v);

            bossNameTxt = (TextView) v.findViewById(R.id.bossNameTxt);
            bossParent = (LinearLayout) v.findViewById(R.id.bossParent);

            bossParent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(callback!=null)
                        callback.onBossItemClicked(mDataset.get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public BossesAdapter(List<Bosses> data, IOnItemClicked callback) {
        mDataset = data;
        this.setCallBack(callback);
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BossesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                         int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bosses_items_view_row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters

        BossesAdapter.ViewHolder vh = new BossesAdapter.ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BossesAdapter.ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);

        holder.bossParent.setBackgroundResource(mDataset.get(position).getBackgroundImageInMemory());
        holder.bossNameTxt.setText(mDataset.get(position).getBossName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

