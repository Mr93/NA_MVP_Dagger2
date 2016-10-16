package com.designpattern.admin.designpattern;

import com.designpattern.admin.designpattern.P.PresenterModule;
import com.designpattern.admin.designpattern.V.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by prora on 10/9/2016.
 */

@Singleton
@Component(modules = {PresenterModule.class})
public interface PresenterComponent {
}
