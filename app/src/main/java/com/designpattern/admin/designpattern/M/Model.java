package com.designpattern.admin.designpattern.M;

import android.app.Activity;
import android.util.Log;

import com.designpattern.admin.designpattern.P.RequiredPresenterOps;
import com.designpattern.admin.designpattern.M.Object.DataModel;
import com.designpattern.admin.designpattern.M.Strategy.DataParserModel;
import com.designpattern.admin.designpattern.M.Strategy.DataParserFactoryModel;
import com.designpattern.admin.designpattern.M.Strategy.ParseDataCallback;
import com.designpattern.admin.designpattern.M.Strategy.ThethaoDataParserFactoryModel;

import java.util.List;

/**
 * Created by mamram on 9/22/2016.
 */
public class Model implements ProvidedModelOps {

    private static final String TAG = Model.class.getSimpleName();
    DataParserFactoryModel factory;
    RequiredPresenterOps requiredPresenterOps;
	List<DataModel> listDataModel;

    public Model() {
        this.factory = new ThethaoDataParserFactoryModel();
    }

    @Override
    public void presenterNeedDataFromNetwork(String domain, Activity context, RequiredPresenterOps inRequiredPresenterOps) {
        try {
            this.requiredPresenterOps = inRequiredPresenterOps;
            DataParserModel dataParserModel = factory.createDataParser(domain, context);
            dataParserModel.parse(new ParseDataCallback(this));
        } catch (NullPointerException e) {
            Log.e(TAG, "presenterNeedDataFromNetwork: ", e);
        }
    }

	@Override
	public List<DataModel> getExistData() {
		return listDataModel;
	}


	public void returnDataForPresenter(List<DataModel> dataModelList){
	    listDataModel = dataModelList;
		Log.d(TAG, "returnDataForPresenter: " + listDataModel.size());
		requiredPresenterOps.getDataNetworkFromModel(dataModelList);
    }
}
