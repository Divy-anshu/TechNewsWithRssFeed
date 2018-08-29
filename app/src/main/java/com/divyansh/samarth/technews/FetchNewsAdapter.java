package com.divyansh.samarth.technews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Divyansh on 23-03-2018.
 */

public class FetchNewsAdapter extends RecyclerView.Adapter<FetchNewsAdapter.FeedModelViewHolder> {
    private Context context;
    private ArrayList<NewsItem> newsItemArrayList;

    public FetchNewsAdapter(Context context, ArrayList<NewsItem> newsItemArrayList) {
        this.context = context;
        this.newsItemArrayList = newsItemArrayList;
    }

    @Override
    public FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout,parent,false);
        FeedModelViewHolder feedModelViewHolder = new FeedModelViewHolder(view);
        return feedModelViewHolder;
    }

    @Override
    public void onBindViewHolder(FeedModelViewHolder holder, int position) {
        NewsItem newsItem = newsItemArrayList.get(position);
        String imgUrl = newsItem.getImg();
        String title = newsItem.getTitle();
        String desc = newsItem.getDescription();
        Picasso.with(context).load(imgUrl).placeholder(context.getDrawable(R.drawable.image_not_found)).into(holder.iv);
        holder.txttitle.setText(title);
        holder.txtdesc.setText(desc);
        if (position % 2 == 0) {
            holder.lv.setBackgroundResource(R.drawable.bg1);
        }
       else if(position%3==0){
            holder.lv.setBackgroundResource(R.drawable.bg2);
        }
        else if(position%5==0){
            holder.lv.setBackgroundResource(R.drawable.bg3);
        }
        else {
           holder.lv.setBackgroundResource(R.drawable.bg5);
        }
    }

    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        ImageView iv;
        TextView txttitle;
        TextView txtdesc;
        LinearLayout lv;
        public FeedModelViewHolder(View itemView) {
            super(itemView);
            iv = (ImageView)itemView.findViewById(R.id.img);
            txttitle = (TextView)itemView.findViewById(R.id.title);
            txtdesc= (TextView) itemView.findViewById(R.id.desc);
            lv = (LinearLayout)itemView.findViewById(R.id.lv);
        }
    }
}
