package com.android.greenfoodfireb.Sdata;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.greenfoodfireb.R;

import java.util.ArrayList;

public class sAdapter extends RecyclerView.Adapter<sAdapter.viewHolder> {

    public RecycleViewListener listener;


    private ArrayList<sItem> mExampleList;
    public sAdapter(ArrayList<sItem> exampleList,RecycleViewListener listener) {
        mExampleList = exampleList;
        this.listener=listener;
    }


    public static class viewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{


        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        private RecycleViewListener listener;

        public viewHolder(@NonNull View itemView) {
            super( itemView );

            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v,getAdapterPosition());
        }
    }




    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate( R.layout.example_item,
                parent, false);
        viewHolder evh = new viewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        sItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());


    }


    @Override
    public int getItemCount() {
        return mExampleList.size();
    }


    public interface RecycleViewListener{
        void onClick(View v,int position);
    }

    public void filterList(ArrayList<sItem> filteredList) {
        mExampleList = filteredList;
        notifyDataSetChanged();
    }

}
