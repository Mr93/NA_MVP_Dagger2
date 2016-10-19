package com.designpattern.admin.designpattern.M;

import android.app.Activity;
import android.content.Context;

import com.designpattern.admin.designpattern.M.Object.DataModel;
import com.designpattern.admin.designpattern.P.RequiredPresenterOps;

import java.util.List;

/**
 * Created by mamram on 9/22/2016.
 */
public interface ProvidedModelOps {
    void presenterNeedDataFromNetwork(String domain, Context context, RequiredPresenterOps inRequiredPresenterOps);
    List<DataModel> getExistData();
}
