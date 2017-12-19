package alico.com.pokemoncards.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by alicanozkara on 14/08/2017.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }

}
