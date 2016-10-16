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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by DucDt on 9/14/2016.
 */

public class Thethao24HParserModel implements DataParserModel {

	private static final String TAG = Thethao24HParserModel.class.getName();
	private static final String MAIN_URL = "http://www.24h.com.vn/upload/rss/bongda.rss";
	public static final String DOMAIN = "24h.com.vn";

	private static Thethao24HParserModel instance;

	private AQuery aQuery;

	private Thethao24HParserModel(Activity context) {
		aQuery = new AQuery(context);
	}

	public static Thethao24HParserModel getInstance(Activity context) {
		if (instance == null) {
			instance = new Thethao24HParserModel(context);
		}
		return instance;
	}

	@Override
	public void parse(final ParseDataCallback callback) {
		aQuery.ajax(MAIN_URL, XmlDom.class, new AjaxCallback<XmlDom>() {
			@Override
			public void callback(String url, XmlDom xmlDom, AjaxStatus status) {
				if (xmlDom != null) {
					try {
						List<DataModel> lstDataModel = new ArrayList<>();
						List<XmlDom> items = xmlDom.tags("item");
						for (int i = 0; i < items.size(); i++) {
							XmlDom item = items.get(i);
							DataModel map = new DataModel();
							XmlDom title = item.child("title");
							XmlDom description = item.child("description");
							XmlDom link = item.child("link");
							XmlDom ngaydang = item.child("pubDate");
							String textTitle = title.text();
							String cDataReplace = description.text();
							String textDescription = cDataReplace.replace("<![CDATA[", "");
							textDescription = textDescription.replace("]]>", "");
							final Pattern pattern = Pattern.compile("src=\'([^\'>]+)");
							Matcher matcher = pattern.matcher(textDescription);
							String linkngon = null;
							while (matcher.find()) {
								linkngon = matcher.group(1);
							}
							String link_LienKet = link.text();
							String textNgayDang = ngaydang.text();
							map.setTitle(textTitle);
							map.setDescription(textDescription);
							map.setImage(linkngon);
							map.setLink(link_LienKet);
							map.setPubDate(textNgayDang);
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
