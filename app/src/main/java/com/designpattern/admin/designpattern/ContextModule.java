package com.designpattern.admin.designpattern;

import android.content.Context;
import android.util.Log;

import com.designpattern.admin.designpattern.V.DataAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by prora on 10/16/2016.
 */

@Module
public class ContextModule {
	private Context context;

	public ContextModule(Context context) {
		this.context = context;
	}

	@Provides
	@ContextScope
	public Context provideContext() {
		return context;
	}
}
