package com.example.startup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapterWorkshops extends RecyclerView.Adapter<RecyclerAdapterWorkshops.RecyclerViewHolder> {
    private Context mContext;
    private List<Workshops_class> workshops;
    private OnItemClickListener mListener;

    public RecyclerAdapterWorkshops(Context context, List<Workshops_class> uploads) {
        mContext = context;
        workshops = uploads;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.row_model_workshops, parent, false);
        return new RecyclerViewHolder(v);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        Workshops_class currentWorkshop = workshops.get(position);
        holder.topicTextView.setText(currentWorkshop.getTopic());
        holder.facilitatorTextView.setText(currentWorkshop.getFacilitator());
        holder.timeTextView.setText(currentWorkshop.getTime());
        holder.currentlyEnrolledTextView.setText(currentWorkshop.getCurrentlyEnrolled());
        holder.capacityOfWorkshopTextView.setText(currentWorkshop.getCapacityOfWorkshop());
        Picasso.with(mContext)
                .load(currentWorkshop.getImageUrl())
                .placeholder(R.drawable.loginlogo2)
                .fit()
                .centerCrop()
                .into(holder.workshopImageView);
    }

    @Override
    public int getItemCount() {
        return workshops.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView topicTextView,facilitatorTextView,timeTextView,currentlyEnrolledTextView,capacityOfWorkshopTextView;
        public ImageView workshopImageView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            topicTextView =itemView.findViewById ( R.id.topicTextView );
            facilitatorTextView = itemView.findViewById(R.id.facilitatorTextView);
            timeTextView = itemView.findViewById(R.id.timeTextView);
            currentlyEnrolledTextView = itemView.findViewById(R.id.currentlyEnrolledTextView);
            capacityOfWorkshopTextView = itemView.findViewById(R.id.capacityOfWorkshopTextView);
            workshopImageView = itemView.findViewById(R.id.workshopImageView);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }


    }

    public void setOnItemClickListener(RecyclerAdapterWorkshops.OnItemClickListener listener) {
        mListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
