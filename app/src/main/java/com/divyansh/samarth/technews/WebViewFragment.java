package com.divyansh.samarth.technews;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class WebViewFragment extends Fragment {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    NewsItem newsItem;
    ArrayList<NewsItem> newsItemArrayList;
    SwipeRefreshLayout swipeRefreshLayout;
    String url;

    public WebViewFragment(String url) {
        // Required empty public constructor
        this.url = url;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv2);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout2);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 1);
        recyclerView.setLayoutManager(layoutManager);
        final WebViewFragment.FetchFeedTask fetchFeedTask = new WebViewFragment.FetchFeedTask();
        fetchFeedTask.execute();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                fetchFeedTask.execute();
            }
        });

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getActivity(), recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        NewsItem newsItem = newsItemArrayList.get(position);
                        Intent intent = new Intent(getActivity(), WebViewActivity.class);
                        intent.putExtra("key_object", newsItem.getLink());
                        startActivity(intent);

                    }

                    @Override
                    public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );


        return view;

    }

    public ArrayList<NewsItem> parseFeed(InputStream inputStream) throws XmlPullParserException, IOException {
        String title = null;
        String link = null;
        String description = null;
        String img = null;
        boolean isItem = false;
        ArrayList<NewsItem> newsItems = new ArrayList<>();

        try {
            XmlPullParser xmlPullParser = Xml.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xmlPullParser.setInput(inputStream, null);

            xmlPullParser.nextTag();
            while (xmlPullParser.next() != XmlPullParser.END_DOCUMENT) {
                int eventType = xmlPullParser.getEventType();

                String name = xmlPullParser.getName();
                if (name == null)
                    continue;

                if (eventType == XmlPullParser.END_TAG) {
                    if (name.equalsIgnoreCase("item"))
                    {
                        isItem = false;
                        continue;
                    }


                }

                if (eventType == XmlPullParser.START_TAG) {
                    if (name.equalsIgnoreCase("item")) {
                        isItem = true;
                        continue;
                    }
                }

                Log.d("MainActivity", "Parsing name ==> " + name);
                String result = "";
                if (xmlPullParser.next() == XmlPullParser.TEXT) {
                    result = xmlPullParser.getText();
                    xmlPullParser.nextTag();
                }

                if (name.equalsIgnoreCase("title")) {
                    title = result;
                } else if (name.equalsIgnoreCase("link")) {
                    link = result;
                } else if (name.equalsIgnoreCase("description")) {
                    description = result;
                } else if (name.equalsIgnoreCase("media:thumbnail")) {
                    img = xmlPullParser.getAttributeValue(0);
                }

                if (title != null && link != null && description != null && img != null) {
                    if (isItem) {
                        newsItem = new NewsItem(title, link, description, img);
                        newsItems.add(newsItem);
                    }

                    title = null;
                    link = null;
                    description = null;
                    img = null;
                    isItem = false;
                }
                else if(title != null && link != null && description != null){
                    if (isItem) {
                        newsItem = new NewsItem(title, link, description, img);
                        newsItems.add(newsItem);
                    }

                    title = null;
                    link = null;
                    description = null;
                    img = null;
                    isItem = false;
                }
            }

            return newsItems;
        } finally {
            inputStream.close();
        }
    }

    private class FetchFeedTask extends AsyncTask<Void, Void, Boolean> {

        private String urlLink = url;

        @Override
        protected void onPreExecute() {
            swipeRefreshLayout.setRefreshing(true);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            if (TextUtils.isEmpty(urlLink))
                return false;

            try {
                if (!urlLink.startsWith("http://") && !urlLink.startsWith("https://"))
                    urlLink = "http://" + urlLink;

                URL url = new URL(urlLink);
                InputStream inputStream = url.openConnection().getInputStream();
                newsItemArrayList = parseFeed(inputStream);
                return true;
            } catch (IOException e) {
                Log.e(TAG, "Error", e);
            } catch (XmlPullParserException e) {
                Log.e(TAG, "Error", e);
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            swipeRefreshLayout.setRefreshing(false);

            if (success) {

                // Fill RecyclerView
                FetchNewsAdapterWeb adapter = new FetchNewsAdapterWeb(getActivity(), newsItemArrayList);
                recyclerView.setAdapter(adapter);
            } else {
                Toast.makeText(getActivity(),
                        "Something happened..",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }
}
