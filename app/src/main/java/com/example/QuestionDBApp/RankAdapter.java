package com.example.QuestionDBApp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RankAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<User> data;

    public RankAdapter(Context context,List<User> data){
        this.context = context;
        this.data = data;
    }

    public class RankHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView name;
        private TextView sign;
        private TextView pronumber;

        public RankHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.rank_img);
            name = itemView.findViewById(R.id.rank_name);
            sign = itemView.findViewById(R.id.rank_sign);
            pronumber = itemView.findViewById(R.id.rank_pronumber);
        }
    }
    @NonNull
    @Override
    public RankHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rank_list_item ,viewGroup,false);
        return new RankHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        RankHolder viewholder = (RankHolder) viewHolder;
        User user = data.get(i);
        viewholder.img.setImageResource(user.getUser_img());
        viewholder.name.setText(user.getUser_name());
        viewholder.sign.setText(user.getUser_sign());
        viewholder.pronumber.setText(user.getUser_pronumber());
    }

    @Override
    public int getItemCount() {

        return data.size();
    }
}
