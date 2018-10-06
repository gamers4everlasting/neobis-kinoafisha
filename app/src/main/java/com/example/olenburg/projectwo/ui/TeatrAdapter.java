package com.example.olenburg.projectwo.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.olenburg.projectwo.R;
import com.example.olenburg.projectwo.model.Teatr;

import java.util.List;

public class TeatrAdapter extends RecyclerView.Adapter<TeatrAdapter.ViewHolder> {
    private List<Teatr> data;
    private OnItemClickListener listener;


    public TeatrAdapter(List<Teatr> data, OnItemClickListener listener) {
        this.data = data;
        this.listener = listener;
    }

    public interface OnItemClickListener {
        void onTeatrClick(String id);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.teatr_show, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TeatrAdapter.ViewHolder viewHolder, int i) {
        viewHolder.name.setText(data.get(i).getName());
        viewHolder.count_vote.setText(data.get(i).getCount_vote());
        viewHolder.telefon.setText("Тел: "+ data.get(i).getPhone());
        viewHolder.adress.setText("Адрес: " + data.get(i).getAddress());

        Glide.with(viewHolder.v.getContext()).load(data.get(i).getImage()).into(viewHolder.pic);
        viewHolder.bind(data.get(i).getId(), listener);
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public void setData(List<Teatr> data) {
        this.data = data;
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private View v;
        public TextView name, count_vote, telefon, adress;
        public ImageView pic;

        public ViewHolder(View v) {
            super(v);
            this.v = v;
            name = v.findViewById(R.id.name);
            pic = v.findViewById(R.id.pic);
            count_vote = v.findViewById(R.id.count_vote);
            telefon = v.findViewById(R.id.telfon);
            adress = v.findViewById(R.id.adress);
        }

        public void bind(final String id, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onTeatrClick(id);
                }
            });
            Log.e("......id: ",  id);
        }

    }
}


