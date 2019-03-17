package com.example.startup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public  class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private Context mContext;
    private List<Teacher> teachers;
    private OnItemClickListener mListener;

    public RecyclerAdapter(Context context, List<Teacher> uploads) {
        mContext = context;
        teachers = uploads;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.activity_row_model, parent, false);
        return new RecyclerViewHolder(v);
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Teacher currentTeacher = teachers.get(position);
        holder.nameTextView.setText(currentTeacher.getName());
        holder.descriptionTextView.setText(currentTeacher.getDescription());
        holder.dateTextView.setText("Starts at: " + currentTeacher.getTime());
        Picasso.with(mContext)
                .load(currentTeacher.getImageUrl())
                .placeholder(R.drawable.loginlogo2)
                .fit()
                .centerCrop()
                .into(holder.teacherImageView);
    }

    @Override
    public int getItemCount() {
        return teachers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        public TextView nameTextView,descriptionTextView,dateTextView;
        public ImageView teacherImageView;

        public RecyclerViewHolder( View itemView) {
            super(itemView);
            nameTextView =itemView.findViewById ( R.id.nameTextView );
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
            teacherImageView = itemView.findViewById(R.id.teacherImageView);

            itemView.setOnClickListener(this);
            /*itemView.setOnCreateContextMenuListener(this);*/
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

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
