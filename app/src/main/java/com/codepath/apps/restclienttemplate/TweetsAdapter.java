package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.ViewHolder>{
    Context context;
    List<Tweet> tweets;
    public TweetsAdapter(Context context, List<Tweet> tweets){
        this.context=context;
        this.tweets=tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tweet tweet = tweets.get(position);
        // Bind the tweet with view holder
        holder.bind(tweet);
    }
    public void addAll(List<Tweet> list) {
        tweets.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return tweets.size();
    }
    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }
    // Pass the context and list of tweets
    //
    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tv_body;
        TextView tv_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView);
            tv_name=itemView.findViewById(R.id.tv_name);
            tv_body=itemView.findViewById(R.id.tv_detail);
        }

        public void bind(Tweet tweet) {

            tv_body.setText(tweet.body);

            tv_name.setText(tweet.user.displayname);
            Glide.with(context)
                    .load(tweet.user.img_url)

                    .into(imageView);
        }
    }
}
