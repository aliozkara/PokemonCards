package alico.com.pokemoncards.application.builder;


import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.utils.Constants;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiServiceModule {

    @AppScope
    @Provides
    Api provideApiService(OkHttpClient client, GsonConverterFactory gson, RxJavaCallAdapterFactory rxAdapter) {

        Retrofit retrofit = new Retrofit.Builder().client(client)
                .baseUrl(Constants.BASE_URL).addConverterFactory(gson).
                        addCallAdapterFactory(rxAdapter).build();

        return retrofit.create(Api.class);
    }


}
