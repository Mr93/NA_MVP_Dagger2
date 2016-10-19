package com.designpattern.admin.designpattern.V;

import android.app.Activity;
import android.content.Context;

import com.designpattern.admin.designpattern.M.Object.DataModel;

import java.util.List;

/**
 * Created by mamram on 9/21/2016.
 */
public interface RequiredViewOps {
    void loadDomainList(List<String> domains, List<String> selection);
    void loadAdapterList(List<DataModel> listDataModel);

	Context returnContext();
}

