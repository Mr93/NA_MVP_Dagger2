package com.designpattern.admin.designpattern;

import com.designpattern.admin.designpattern.V.MainActivity;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by prora on 10/16/2016.
 */
@ContextScope
@Component (dependencies = PresenterComponent.class, modules = ContextModule.class)
public interface ContextComponent {
	void inject(MainActivity activity);
}
