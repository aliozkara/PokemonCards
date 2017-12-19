package alico.com.pokemoncards.application.builder;

import android.content.Context;

import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.utils.rx.RxSchedulers;
import dagger.Component;

/**
 * Created by alicanozkara on 14/08/2017.
 */

@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, ApiServiceModule.class})
public interface AppComponent {

    Context getAppContext();

    RxSchedulers rxSchedulers();

    Api apiService();
}
