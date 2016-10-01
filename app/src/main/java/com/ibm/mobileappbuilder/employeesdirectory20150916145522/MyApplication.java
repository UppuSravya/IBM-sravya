

package com.ibm.mobileappbuilder.employeesdirectory20150916145522;

import android.app.Application;
import ibmmobileappbuilder.injectors.ApplicationInjector;
import android.support.multidex.MultiDexApplication;
import ibmmobileappbuilder.push.BluemixPushWrapper;


/**
 * You can use this as a global place to keep application-level resources
 * such as singletons, services, etc.
 */
public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationInjector.setApplicationContext(this);
        BluemixPushWrapper bluemixPushWrapper = new BluemixPushWrapper();
        bluemixPushWrapper.register(this,
            "https://github.com/pulls",
            "github"
        );
    }
}

