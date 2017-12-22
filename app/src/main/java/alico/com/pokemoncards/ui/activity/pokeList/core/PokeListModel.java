package alico.com.pokemoncards.ui.activity.pokeList.core;


import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.model.rest.CardApiModel;
import alico.com.pokemoncards.ui.activity.pokeList.PokeListActivity;
import alico.com.pokemoncards.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeListModel {

    PokeListActivity context;
    Api api;

    public PokeListModel(PokeListActivity context, Api api) {
        this.context = context;
        this.api = api;
    }

    Observable<Boolean> isNetworkAvailable(){
        return NetworkUtils.isNetworkAvailableObservable(context);
    }

    Observable<CardApiModel> cards(int pageSize){
        return api.cards(pageSize);
    }

}
