package com.designpattern.admin.designpattern;

import android.content.Context;

import com.designpattern.admin.designpattern.P.PresenterModule;
import com.designpattern.admin.designpattern.P.ProvidedPresenterOps;
import com.designpattern.admin.designpattern.V.DataAdapter;
import com.designpattern.admin.designpattern.V.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by prora on 10/9/2016.
 */

@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
	ProvidedPresenterOps presenter();
	//Context context();
	//Context context();
}
