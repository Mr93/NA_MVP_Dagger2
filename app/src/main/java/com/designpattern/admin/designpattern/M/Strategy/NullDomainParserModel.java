package com.designpattern.admin.designpattern.M.Strategy;

import android.util.Log;
import com.designpattern.admin.designpattern.M.Object.DataModel;

import java.util.ArrayList;

/**
 * Created by DucDt on 9/15/2016.
 */

public class NullDomainParserModel implements DataParserModel {

	private static final String TAG = NullDomainParserModel.class.getSimpleName();

	private static NullDomainParserModel instance;

	private NullDomainParserModel() {

	}

	public static NullDomainParserModel getInstance() {
		if (instance == null) {
			instance = new NullDomainParserModel();
		}
		return instance;
	}

	@Override
	public void parse(ParseDataCallback callback) {
		Log.d(TAG, "parse: Null domain parse");
		callback.onParseDataDone(new ArrayList<DataModel>());
	}
}
