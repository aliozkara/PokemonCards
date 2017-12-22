package alico.com.pokemoncards.ui.activity.pokeDetail.core;

import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.ui.activity.pokeDetail.PokeDetailActivity;
import alico.com.pokemoncards.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeDetailModel {

    PokeDetailActivity context;
    Api api;

    public PokeDetailModel(PokeDetailActivity context, Api api) {
        this.context = context;
        this.api = api;
    }

    Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

}
