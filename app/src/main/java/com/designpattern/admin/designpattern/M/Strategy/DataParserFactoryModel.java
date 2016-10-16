package com.designpattern.admin.designpattern.M.Strategy;

import android.app.Activity;

/**
 * Created by DucDt on 9/14/2016.
 */

public interface DataParserFactoryModel {
    DataParserModel createDataParser(String domain, Activity activity);
}
