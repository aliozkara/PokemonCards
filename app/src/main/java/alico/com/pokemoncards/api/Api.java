package alico.com.pokemoncards.api;

import alico.com.pokemoncards.model.rest.CardDetailApiModel;
import retrofit2.http.Path;
import rx.Observable;

import alico.com.pokemoncards.model.rest.CardApiModel;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alicanozkara on 19.12.2017.
 */

public interface Api {

    @GET("cards")
    Observable<CardApiModel> cards(@Query("pageSize") int pageSize, @Query("page") int page);

    @GET("cards")
    Observable<CardApiModel> cardSearch(@Query("name") String name, @Query("pageSize") int pageSize, @Query("page") int page);

    @GET("cards/{id}")
    Observable<CardDetailApiModel> cardDetail(@Path("id") String id);
}
