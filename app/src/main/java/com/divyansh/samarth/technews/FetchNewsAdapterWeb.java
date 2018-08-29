package com.divyansh.samarth.technews;

import android.content.Context;
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

/**
 * Created by Divyansh on 25-03-2018.
 */

public class FetchNewsAdapterWeb extends RecyclerView.Adapter<FetchNewsAdapterWeb.FeedModelViewHolder> {
    private Context context;
    private ArrayList<NewsItem> newsItemArrayList;

    public FetchNewsAdapterWeb(Context context, ArrayList<NewsItem> newsItemArrayList) {
        this.context = context;
        this.newsItemArrayList = newsItemArrayList;
    }

    @Override
    public FetchNewsAdapterWeb.FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout_web, parent, false);
        FetchNewsAdapterWeb.FeedModelViewHolder feedModelViewHolder = new FetchNewsAdapterWeb.FeedModelViewHolder(view);
        return feedModelViewHolder;
    }

    @Override
    public void onBindViewHolder(FetchNewsAdapterWeb.FeedModelViewHolder holder, int position) {
        NewsItem newsItem = newsItemArrayList.get(position);
        String imgUrl = newsItem.getImg();
        String title = newsItem.getTitle();
        String desc = newsItem.getDescription();
        String webcontent;
        if (position % 2 == 0) {
            webcontent = "<html><head></head><body style='background: rgba(31, 94, 201, 0.8);color:#fff'><h1>"+title+"</h1>"+desc+"</body></html>";
        } else if (position % 3 == 0) {
            webcontent = "<html><head></head><body style='background: rgba(132, 31, 201, 0.8);color:#fff'><h1>"+title+"</h1>"+desc+"</body></html>";
        } else if (position % 5 == 0) {
            webcontent = "<html><head></head><body style='background: rgba(16, 197, 70, 0.8);color:#fff'><h1>"+title+"</h1>"+desc+"</body></html>";
        } else {
            webcontent = "<html><head></head><body style='background: rgba(248, 54, 11, 0.8);color:#fff'><h1>"+title+"</h1>"+desc+"</body></html>";
        }
        holder.wbview.loadDataWithBaseURL("", webcontent, "text/html", "UTF-8", "");
    }

    @Override
    public int getItemCount() {
        return newsItemArrayList.size();
    }

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        WebView wbview;

        public FeedModelViewHolder(View itemView) {
            super(itemView);
           wbview = (WebView)itemView.findViewById(R.id.wbview);
        }
    }
}
