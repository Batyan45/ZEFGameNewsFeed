package com.batyan.zefgame.utilities;

import android.text.Html;

import com.batyan.zefgame.model.ArticleModel;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class RSSParser {
    private String rss;
    private List<ArticleModel> items;

    public RSSParser(String rss) {

        this.rss = rss;
        items = new ArrayList<>();
    }

    public List<ArticleModel> getRssItems() {

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(false);

            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(rss));

            boolean insideItem = false;
            ArticleModel articleModel = null;

            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG) {

                    if (xmlPullParser.getName().equalsIgnoreCase("item")) {

                        articleModel = new ArticleModel();
                        insideItem = true;

                    } else if (xmlPullParser.getName().equalsIgnoreCase("title")) {

                        if (insideItem) {
                            String title = xmlPullParser.nextText();
                            articleModel.setTitle(title);
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("link")) {
                        if (insideItem) {
                            String link = xmlPullParser.nextText();
                            articleModel.setLink(link);
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("description")) {
                        if (insideItem) {
                            String description = xmlPullParser.nextText();
                            articleModel.setDescription(Html.fromHtml(description).toString());
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("pubDate")) {
                        if (insideItem) {
                            String pubDate = xmlPullParser.nextText();
                            articleModel.setPubDate(pubDate);
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("guid")) {
                        if (insideItem) {
                            int id = RSSHelper.parseId(xmlPullParser.nextText());
                            articleModel.setId(id);
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("dc:creator")) {
                        if (insideItem) {
                            String creator = xmlPullParser.nextText();
                            articleModel.setAuthor(Html.fromHtml(creator).toString());
                        }
                    } else if (xmlPullParser.getName().equalsIgnoreCase("content:encoded")) {
                        if (insideItem) {
                            String content = xmlPullParser.nextText();
                            articleModel.setText(Html.fromHtml(content).toString());
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG && xmlPullParser.getName().equalsIgnoreCase("item")) {
                    insideItem = false;
                    items.add(articleModel);
                }
                eventType = xmlPullParser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }
        return items;
    }
}

