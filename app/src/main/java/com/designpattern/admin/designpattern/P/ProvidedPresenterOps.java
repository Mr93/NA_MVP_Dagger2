package com.designpattern.admin.designpattern.P;

import android.app.Activity;

import com.designpattern.admin.designpattern.M.ProvidedModelOps;
import com.designpattern.admin.designpattern.V.RequiredViewOps;

import java.util.List;

/**
 * Created by mamram on 9/21/2016.
 */
public interface ProvidedPresenterOps {
    void getExistData();
    void getDomainList();
    void getDataFromNetwork(List<String> domainList);
    void setView(RequiredViewOps requiredViewOps);
    void setModelMVP(ProvidedModelOps providedModelOps);
    void setPreViewState(RequiredViewOps requiredViewOps);
}
