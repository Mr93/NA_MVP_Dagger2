package com.designpattern.admin.designpattern.M.Strategy;

import android.app.Activity;
import android.content.Context;

/**
 * Created by DucDt on 9/14/2016.
 */

public interface DataParserFactoryModel {
    DataParserModel createDataParser(String domain, Context activity);
}
