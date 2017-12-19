package alico.com.pokemoncards.application;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import alico.com.pokemoncards.application.builder.AppComponent;
import alico.com.pokemoncards.application.builder.AppContextModule;
import alico.com.pokemoncards.application.builder.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by alicanozkara on 19.12.2017.
 */

public class App extends Application {

    private static AppComponent appComponent;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        initialiseLogger();
        initAppComponent();
    }

    private void initAppComponent(){
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }

    private void initialiseLogger(){
        Timber.plant(new Timber.DebugTree());
    }

    public static AppComponent getNetComponent(){
        return appComponent;
    }


}
