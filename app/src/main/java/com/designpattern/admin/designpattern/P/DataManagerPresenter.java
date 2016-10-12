package com.designpattern.admin.designpattern.P;

import android.app.Activity;
import android.util.Log;

import com.designpattern.admin.designpattern.M.ProvidedModelOps;
import com.designpattern.admin.designpattern.V.RequiredViewOps;
import com.designpattern.admin.designpattern.M.Object.DataModel;
import com.designpattern.admin.designpattern.M.Strategy.Thethao247ParserModel;
import com.designpattern.admin.designpattern.M.Strategy.Thethao24HParserModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by DucDt on 9/14/2016.
 */

public class DataManagerPresenter implements ProvidedPresenterOps, RequiredPresenterOps {
	private static final List<String> domainList = new ArrayList<>(
			Arrays.asList(
					Thethao24HParserModel.DOMAIN,
					Thethao247ParserModel.DOMAIN
			)
	);
    private ProvidedModelOps modelMVP;
    private RequiredViewOps viewMVP;
    private static final String TAG = DataManagerPresenter.class.getSimpleName();
    private Activity context;
	private List<String> currentList = new ArrayList<>();

	public DataManagerPresenter(RequiredViewOps requiredViewOps, Activity activity) {
		this.context = activity;
		this.viewMVP = requiredViewOps;
		currentList.add(domainList.get(0));
	}

	public void setModelMVP(ProvidedModelOps providedModelOps){
		this.modelMVP = providedModelOps;
	}

	private void getDataFromDomain(String domain) {
        modelMVP.presenterNeedDataFromNetwork(domain, context, this);
	}


	public void displayNewData(List<DataModel> dataModelList){
		viewMVP.loadAdapterList(dataModelList);
	}

	@Override
	public void getExistData() {
		List<DataModel> dataModelList = modelMVP.getExistData();
		if(dataModelList != null && !dataModelList.isEmpty()){
			Log.d(TAG, "getExistData: " + dataModelList.size());
			displayNewData(dataModelList);
		}
	}

	@Override
	public void getDomainList() {
        viewMVP.loadDomainList(domainList, currentList);
	}

	@Override
	public void getDataFromNetwork(List<String> domainList) {
        if (domainList != null && !domainList.isEmpty()) {
	        currentList = domainList;
            for (String domain : domainList) {
                Log.d(TAG, "selectedStrings: " + domain);
                getDataFromDomain(domain);
            }
        } else {
            displayNewData(new ArrayList<DataModel>());
        }
	}

	@Override
	public void setView(RequiredViewOps requiredViewOps, Activity activity) {
		this.context = activity;
		this.viewMVP = requiredViewOps;
	}

	@Override
    public void getDataNetworkFromModel(List<DataModel> dataModelList) {
        viewMVP.loadAdapterList(dataModelList);
    }
}
