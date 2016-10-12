package com.designpattern.admin.designpattern.M.Strategy;

import com.designpattern.admin.designpattern.M.Model;
import com.designpattern.admin.designpattern.M.Object.DataModel;

import java.util.List;

/**
 * Created by DucDt on 9/15/2016.
 */

public class ParseDataCallback {

	private Model model;

	public ParseDataCallback(Model model){
		this.model = model;
	}

	public void onParseDataDone(List<DataModel> dataModelList){
		model.returnDataForPresenter(dataModelList);
	}
}
