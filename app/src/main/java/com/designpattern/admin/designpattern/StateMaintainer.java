package com.designpattern.admin.designpattern;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.designpattern.admin.designpattern.M.ProvidedModelOps;
import com.designpattern.admin.designpattern.P.ProvidedPresenterOps;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by prora on 10/11/2016.
 */

public class StateMaintainer {

	protected final String TAG = getClass().getName();
	private HashMap<Integer, ProvidedPresenterOps> dataState = new HashMap<>();
	private static StateMaintainer instance;

	private StateMaintainer() {

	}

	public static StateMaintainer getInstance() {
		if (instance == null) {
			instance = new StateMaintainer();
		}
		return instance;
	}

	//creates activity responsible to maintain the objects
	public boolean firstTimeIn(int activityId) {
		try {
			ProvidedPresenterOps providedPresenterOps = dataState.get(activityId);
			if (providedPresenterOps == null) {
				return true;
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			Log.e(TAG, "firstTimeIn: ", e);
			return false;
		}
	}

	public void updateState(int activityId, ProvidedPresenterOps providedPresenterOps) {
		dataState.put(activityId, providedPresenterOps);
	}

	public ProvidedPresenterOps getState(int activityId) {
		return dataState.get(activityId);
	}

}
