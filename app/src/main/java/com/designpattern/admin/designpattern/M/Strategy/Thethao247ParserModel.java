package com.designpattern.admin.designpattern.M.Strategy;

import android.app.Activity;
import android.util.Log;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.util.XmlDom;
import com.designpattern.admin.designpattern.M.Object.DataModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DucDt on 9/14/2016.
 */

public class Thethao247ParserModel implements DataParserModel {

    private static final String TAG = Thethao247ParserModel.class.getName();
    private static final String URL = "http://thethao247.vn/home.rss";
    public static final String DOMAIN = "thethao247.vn";

    private static Thethao247ParserModel instance;

    AQuery aQuery;

    private Thethao247ParserModel(Activity context) {
        aQuery = new AQuery(context);

    }

    public static Thethao247ParserModel getInstance(Activity context) {
        if (instance == null) {
            instance = new Thethao247ParserModel(context);
        }
        return instance;
    }

    @Override
    public void parse(final ParseDataCallback callback) {
        aQuery.ajax(URL, XmlDom.class, new AjaxCallback<XmlDom>() {
            @Override
            public void callback(String url, XmlDom xmlDom, AjaxStatus status) {
                if (xmlDom != null) {
                    try {
	                    List<DataModel> lstDataModel = new ArrayList<DataModel>();
                        List<XmlDom> items = xmlDom.tags("item");
                        for (int i = 0; i < items.size(); i++) {
                            XmlDom item = items.get(i);
                            DataModel map = new DataModel();
                            XmlDom title = item.child("title");
                            XmlDom link = item.child("link");
                            XmlDom image = item.child("image");
                            XmlDom pubDate = item.child("pubDate");
                            String cDataReplace = title.text();
                            String textTitle = cDataReplace.replace("<![CDATA[", "");
                            textTitle = textTitle.replace("]]>", "");
                            String textLink = link.text();
                            String textImage = image.text();
                            String textpubDate = pubDate.text();
                            map.setTitle(textTitle);
                            map.setLink(textLink);
                            map.setImage(textImage);
                            map.setPubDate(textpubDate);
                            map.setDomain(DOMAIN);
                            lstDataModel.add(map);
                        }
	                    callback.onParseDataDone(lstDataModel);
	                    Log.d(TAG, "callback: list data  : " + lstDataModel.size());
                    } catch (Exception e) {
                        Log.e(TAG, "callback: ", e);
                    }
                }
            }
        });
    }
}
