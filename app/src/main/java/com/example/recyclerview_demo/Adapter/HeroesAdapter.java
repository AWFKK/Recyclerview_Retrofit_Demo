package com.example.recyclerview_demo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recyclerview_demo.Model.Hero;
import com.example.recyclerview_demo.R;

import java.util.List;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.HeroViewHolder> {

    Context mCtx;
    List<Hero> heroList;

    public HeroesAdapter(Context mCtx, List<Hero> heroList) {
        this.mCtx = mCtx;
        this.heroList = heroList;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.gridrecycler_layout, parent, false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        Glide.with(mCtx)
                .load(hero.getImageurl())
                .into(holder.imageView2);

/*        holder.textView.setText("Hero Name: "+hero.getName());
        holder.textView1.setText("Real Name: "+hero.getRealname());
        holder.textView2.setText("First Appearance: "+hero.getFirstappearance());
        holder.textView3.setText("Created By: "+hero.getCreatedby());
        holder.textView4.setText("Team: "+hero.getTeam());
        holder.textView5.setText("Publisher: "+hero.getPublisher());
        holder.textView6.setText("Bio: "+hero.getBio());*/

        holder.textView7.setText("Hero Name: "+hero.getName());
        holder.textView8.setText("Team: "+hero.getTeam());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    class HeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView, imageView2;
        TextView textView, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8;

        public HeroViewHolder(View itemView) {
            super(itemView);

/*            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
            textView4 = itemView.findViewById(R.id.textView4);
            textView5 = itemView.findViewById(R.id.textView5);
            textView6 = itemView.findViewById(R.id.textView6);*/

            imageView2 = itemView.findViewById(R.id.song_image);
            textView7 = itemView.findViewById(R.id.song_name);
            textView8 = itemView.findViewById(R.id.song_author);
        }
    }
}
