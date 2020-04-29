package com.byu.number_game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import java.util.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import android.widget.ImageView;


public class RecycleviewAdaptor extends RecyclerView.Adapter<RecycleviewAdaptor.ViewHolder> {
    private static final String TAG = "recycleviewAdaptor";
    private List<GuessResult> myResult = new ArrayList<>();

    public RecycleviewAdaptor(List<GuessResult> myResult)
    {
        this.myResult = myResult;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_holder,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.guess.setText(myResult.get(position).getGuess());
        holder.result.setText(myResult.get(position).getResult());
        holder.icon.setImageResource(R.drawable.ic_clear_black_24dp);
    }

    @Override
    public int getItemCount() {
        return myResult.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

            TextView guess;
            TextView result;
            ImageView icon;
            LinearLayout parentLayout;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                icon = itemView.findViewById(R.id.icon);
                result = itemView.findViewById(R.id.result);
                guess = itemView.findViewById(R.id.guess);
                parentLayout = itemView.findViewById(R.id.parent_layout);
            }
        }
    }

