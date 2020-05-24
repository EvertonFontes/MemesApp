package com.EFYSoftware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class FlipAdapter  extends RecyclerView.Adapter<FlipAdapter.ViewHolder>{

    private Context context;
    private List<Memes> listMemes;

    public FlipAdapter(Context context, List<Memes> listMemes) {
        this.context = context;
        this.listMemes = listMemes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.flip_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Memes meme = listMemes.get(position);
        holder.name_meme.setText(meme.getName());

        Picasso.get().load(meme.getUrl()).placeholder(R.drawable.image).into(holder.image_meme);
    }

    @Override
    public int getItemCount() {
        return listMemes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_meme;
        TextView name_meme;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_meme = itemView.findViewById(R.id.image_meme);
            name_meme = itemView.findViewById(R.id.txt_name_meme);

        }
    }
}





