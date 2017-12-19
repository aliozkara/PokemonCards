package alico.com.pokemoncards.application.builder;

import alico.com.pokemoncards.utils.rx.AppRxSchedulers;
import alico.com.pokemoncards.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;

/**
 * Created by alicanozkara on 14/08/2017.
 */

@Module
public class RxModule {
    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
