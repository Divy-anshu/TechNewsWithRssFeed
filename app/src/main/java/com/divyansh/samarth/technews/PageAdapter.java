package com.divyansh.samarth.technews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Divyansh on 24-03-2018.
 */

public class PageAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    String site;
    public PageAdapter(FragmentManager fm, int tabCount, String site) {
        super(fm);
        this.tabCount = tabCount;
        this.site=site;
    }

    @Override
    public Fragment getItem(int position) {
        if (site.equals("cnet")) {
            switch (position) {
                case 0:
                    NewsContentFragment newsContentFragment0 = new NewsContentFragment("https://www.cnet.com/rss/all/");
                    return newsContentFragment0;
                case 1:
                    NewsContentFragment newsContentFragment1 = new NewsContentFragment("https://www.cnet.com/rss/news/");
                    return newsContentFragment1;
                case 2:
                    NewsContentFragment newsContentFragment2 = new NewsContentFragment("https://www.cnet.com/rss/reviews/");
                    return newsContentFragment2;
                case 3:
                    NewsContentFragment newsContentFragment3 = new NewsContentFragment("https://www.cnet.com/rss/android-update/");
                    return newsContentFragment3;
                case 4:
                    NewsContentFragment newsContentFragment4 = new NewsContentFragment("https://www.cnet.com/rss/gaming/");
                    return newsContentFragment4;
                case 5:
                    NewsContentFragment newsContentFragment5 = new NewsContentFragment("https://www.cnet.com/rss/cheapskate/");
                    return newsContentFragment5;
                case 6:
                    NewsContentFragment newsContentFragment6 = new NewsContentFragment("https://www.cnet.com/rss/smart-home/");
                    return newsContentFragment6;
                default:
                    return null;
            }

        }
        if (site.equals("techcrunch")) {
            switch (position) {
                case 0:
                    WebViewFragment webViewFragment0 = new WebViewFragment("https://techcrunch.com/feed/");
                    return webViewFragment0;
                case 1:
                    WebViewFragment webViewFragment1 = new WebViewFragment("https://techcrunch.com/social/feed/");
                    return webViewFragment1;
                case 2:
                    WebViewFragment webViewFragment2 = new WebViewFragment("https://techcrunch.com/mobile/feed/");
                    return webViewFragment2;
                case 3:
                    WebViewFragment webViewFragment3 = new WebViewFragment("https://techcrunch.com/enterprise/feed/");
                    return webViewFragment3;
                case 4:
                    WebViewFragment webViewFragment4 = new WebViewFragment("https://techcrunch.com/startups/feed/");
                    return webViewFragment4;
                default:
                    return null;
            }
        }
            if(site.equals("techradar")){
                switch (position){
                    case 0:
                        WebViewFragment webViewFragment0 = new WebViewFragment("https://www.techradar.com/rss");
                        return webViewFragment0;
                    case 1:
                        WebViewFragment webViewFragment1 = new WebViewFragment("https://www.techradar.com/rss/news/computing");
                        return webViewFragment1;
                    case 2:
                        WebViewFragment webViewFragment2 = new WebViewFragment("https://www.techradar.com/rss/news/gaming");
                        return webViewFragment2;
                    case 3:
                        WebViewFragment webViewFragment3 = new WebViewFragment("https://www.techradar.com/rss/news/mobile-computing");
                        return webViewFragment3;
                    case 4:
                        WebViewFragment webViewFragment4 = new WebViewFragment("https://www.techradar.com/rss/news/internet");
                        return webViewFragment4;
                    case 5:
                        WebViewFragment webViewFragment5 = new WebViewFragment("https://www.techradar.com/rss/news/networking");
                        return webViewFragment5;
                    case 6:
                        WebViewFragment webViewFragment6 = new WebViewFragment("https://www.techradar.com/rss/news/software");
                        return webViewFragment6;
                    case 7:
                        WebViewFragment webViewFragment7 = new WebViewFragment("https://www.techradar.com/rss/reviews");
                        return webViewFragment7;
                    default:
                        return null;
                }
            }

        if(site.equals("dataquest")){
            switch (position){
                case 0:
                    NewsContentFragment newsContentFragment0 = new NewsContentFragment("http://www.dqindia.com/article-2/");
                    return newsContentFragment0;
                case 1:
                    NewsContentFragment newsContentFragment1 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=news");
                    return newsContentFragment1;
                case 2:
                    NewsContentFragment newsContentFragment2 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=dqtop20");
                    return newsContentFragment2;
                case 3:
                    NewsContentFragment newsContentFragment3 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=analytics");
                    return newsContentFragment3;
                case 4:
                    NewsContentFragment newsContentFragment4 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=big-data");
                    return newsContentFragment4;
                case 5:
                    NewsContentFragment newsContentFragment5 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=cloud");
                    return newsContentFragment5;
                case 6:
                    NewsContentFragment newsContentFragment6 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=data-center");
                    return newsContentFragment6;
                case 7:
                    NewsContentFragment newsContentFragment7 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=features");
                    return newsContentFragment7;
                case 8:
                    NewsContentFragment newsContentFragment8 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=internet");
                    return newsContentFragment8;
                case 9:
                    NewsContentFragment newsContentFragment9 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=mobility");
                    return newsContentFragment9;
                case 10:
                    NewsContentFragment newsContentFragment10 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=networking");
                    return newsContentFragment10;
                case 11:
                    NewsContentFragment newsContentFragment11 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=security");
                    return newsContentFragment11;
                case 12:
                    NewsContentFragment newsContentFragment12 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=software");
                    return newsContentFragment12;
                case 13:
                    NewsContentFragment newsContentFragment13 = new NewsContentFragment("http://www.dqindia.com/rss2-2/?cat_slug=social-media");
                    return newsContentFragment13;
                default:
                    return null;
            }
        }
        if(site.equals("gadget360")){
            switch (position){
                case 0:
                    NewsContentFragment newsContentFragment0 = new NewsContentFragment("https://gadgets.ndtv.com/rss/feeds");
                    return newsContentFragment0;
                case 1:
                    NewsContentFragment newsContentFragment1 = new NewsContentFragment("https://gadgets.ndtv.com/rss/news");
                    return newsContentFragment1;
                case 2:
                    NewsContentFragment newsContentFragment2 = new NewsContentFragment("https://gadgets.ndtv.com/rss/entertainment/feeds");
                    return newsContentFragment2;
                case 3:
                    NewsContentFragment newsContentFragment3 = new NewsContentFragment("https://gadgets.ndtv.com/rss/360daily/feeds");
                    return newsContentFragment3;
                case 4:
                    NewsContentFragment newsContentFragment4 = new NewsContentFragment("hhttps://gadgets.ndtv.com/rss/games/feeds");
                    return newsContentFragment4;
                case 5:
                    NewsContentFragment newsContentFragment5 = new NewsContentFragment("https://gadgets.ndtv.com/rss/reviews");
                    return newsContentFragment5;
                case 6:
                    NewsContentFragment newsContentFragment6 = new NewsContentFragment("https://gadgets.ndtv.com/rss/mobiles/feeds");
                    return newsContentFragment6;
                case 7:
                    NewsContentFragment newsContentFragment7 = new NewsContentFragment("https://gadgets.ndtv.com/rss/features");
                    return newsContentFragment7;
                case 8:
                    NewsContentFragment newsContentFragment8 = new NewsContentFragment("https://gadgets.ndtv.com/rss/internet/feeds");
                    return newsContentFragment8;
                case 9:
                    NewsContentFragment newsContentFragment9 = new NewsContentFragment("https://gadgets.ndtv.com/rss/telecom/feeds");
                    return newsContentFragment9;
                case 10:
                    NewsContentFragment newsContentFragment10 = new NewsContentFragment("hhttps://gadgets.ndtv.com/rss/polls/feeds");
                    return newsContentFragment10;
                case 11:
                    NewsContentFragment newsContentFragment11 = new NewsContentFragment("https://gadgets.ndtv.com/rss/how-to/feeds");
                    return newsContentFragment11;
                case 12:
                    NewsContentFragment newsContentFragment12 = new NewsContentFragment("https://gadgets.ndtv.com/rss/india/feeds");
                    return newsContentFragment12;
                case 13:
                    NewsContentFragment newsContentFragment13 = new NewsContentFragment("https://gadgets.ndtv.com/rss/social-networking/feeds");
                    return newsContentFragment13;
                default:
                    return null;
            }
        }
        if (site.equals("pcquest")) {
            switch (position) {
                case 0:
                    NewsContentFragment newsContentFragment0 = new NewsContentFragment("http://www.pcquest.com/rss-2-2/?cat_slug=community");
                    return newsContentFragment0;
                case 1:
                    NewsContentFragment newsContentFragment1 = new NewsContentFragment("http://www.pcquest.com/rss-2-2/?cat_slug=cloud-computing");
                    return newsContentFragment1;
                case 2:
                    NewsContentFragment newsContentFragment2 = new NewsContentFragment("http://www.pcquest.com/rss-2-2/?cat_slug=mobile-apps");
                    return newsContentFragment2;
                case 3:
                    NewsContentFragment newsContentFragment3 = new NewsContentFragment("http://www.pcquest.com/rss-2-2/?cat_slug=technology-explained");
                    return newsContentFragment3;
                case 4:
                    NewsContentFragment newsContentFragment4 = new NewsContentFragment("http://www.pcquest.com/rss-2-2/?cat_slug=startups");
                    return newsContentFragment4;
                default:
                    return null;
            }
        }
        if (site.equals("opensource")) {
            switch (position) {
                case 0:
                    WebViewFragment webViewFragment0 = new WebViewFragment("http://opensourceforu.com/feed/");
                    return webViewFragment0;
                case 1:
                    WebViewFragment webViewFragment1 = new WebViewFragment("http://opensourceforu.com/category/developers/feed/");
                    return webViewFragment1;
                case 2:
                    WebViewFragment webViewFragment2 = new WebViewFragment("http://opensourceforu.com/category/admin/feed/");
                    return webViewFragment2;
                case 3:
                    WebViewFragment webViewFragment3 = new WebViewFragment("http://opensourceforu.com/category/cxo/feed/");
                    return webViewFragment3;
                case 4:
                    WebViewFragment webViewFragment4 = new WebViewFragment("http://opensourceforu.com/category/how-tos/feed/");
                    return webViewFragment4;
                case 5:
                    WebViewFragment webViewFragment5 = new WebViewFragment("http://opensourceforu.com/category/basics/feed/");
                    return webViewFragment5;
                default:
                    return null;
            }
        }
        if (site.equals("androidauthority")) {
            switch (position) {
                case 0:
                    WebViewFragment webViewFragment0 = new WebViewFragment("https://www.androidauthority.com/feed/");
                    return webViewFragment0;
                case 1:
                    WebViewFragment webViewFragment1 = new WebViewFragment("https://www.androidauthority.com/news/feed/");
                    return webViewFragment1;
                case 2:
                    WebViewFragment webViewFragment2 = new WebViewFragment("https://www.androidauthority.com/android-development/feed");
                    return webViewFragment2;
                case 3:
                    WebViewFragment webViewFragment3 = new WebViewFragment("https://www.androidauthority.com/reviews/feed/");
                    return webViewFragment3;
                case 4:
                    WebViewFragment webViewFragment4 = new WebViewFragment("https://www.androidauthority.com/apps/feed/");
                    return webViewFragment4;
                case 5:
                    WebViewFragment webViewFragment5 = new WebViewFragment("https://www.androidauthority.com/how-to/");
                    return webViewFragment5;
                default:
                    return null;
            }
        }
        return null;

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}

