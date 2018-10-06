package com.example.olenburg.projectwo.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.olenburg.projectwo.R;
import com.example.olenburg.projectwo.model.Cinema;

import java.util.List;

public class ResAdapter extends RecyclerView.Adapter<ResAdapter.ViewHolder> {

    private List<Cinema> data;

    public ResAdapter(List<Cinema> data) {
        this.data = data;

    }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.movie_show, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.title.setText(data.get(i).getName() + "     ( " + data.get(i).getCountries() + " )");
            viewHolder.count_vote.setText(data.get(i).getCount_vote());
            Glide.with(viewHolder.v.getContext()).load(data.get(i).getImage()).into(viewHolder.im);

        }

        @Override
        public int getItemCount() {
            if (data == null) return 0;
            return data.size();
        }
        public void setData(List<Cinema> data) {
            this.data = data;
            notifyDataSetChanged();
        }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View v;
        public TextView title, count_vote;
        public ImageView im;

        public ViewHolder(View v) {
            super(v);
            this.v = v;
            title = v.findViewById(R.id.title);
            im = v.findViewById(R.id.icon);
            count_vote = v.findViewById(R.id.count_vote);
        }


    }
}
