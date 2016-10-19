package com.designpattern.admin.designpattern.M.Strategy;

import android.app.Activity;
import android.content.Context;

/**
 * Created by DucDt on 9/14/2016.
 */

public class ThethaoDataParserFactoryModel implements DataParserFactoryModel {

	@Override
	public DataParserModel createDataParser(String domain, Context context) {
		if (domain.contains(Thethao24HParserModel.DOMAIN)) {
			return Thethao24HParserModel.getInstance(context);
		} else if (domain.contains(Thethao247ParserModel.DOMAIN)) {
			return Thethao247ParserModel.getInstance(context);
		}
		return NullDomainParserModel.getInstance();
	}


}
