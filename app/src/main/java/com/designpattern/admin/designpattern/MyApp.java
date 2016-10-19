package com.designpattern.admin.designpattern;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.designpattern.admin.designpattern.P.PresenterModule;
import com.designpattern.admin.designpattern.V.RequiredViewOps;

/**
 * Created by prora on 10/9/2016.
 */

public class MyApp extends Application {

    private PresenterComponent presenterComponent;
	private ContextComponent contextComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

	public void createComponents(RequiredViewOps requiredViewOps) {
		presenterComponent = DaggerPresenterComponent.builder()
                .presenterModule(new PresenterModule(requiredViewOps))
                .build();
		contextComponent = DaggerContextComponent.builder()
				.presenterComponent(presenterComponent)
				.contextModule(new ContextModule(getApplicationContext()))
				.build();

    }

    public PresenterComponent getPresenterComponent(){
        return presenterComponent;
    }

	public ContextComponent getContextComponent() {
		return contextComponent;
	}
}
