package alico.com.pokemoncards.ui.activity.pokeDetail.core;

import alico.com.pokemoncards.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeDetailPresenter {

    PokeDetailView view;
    PokeDetailModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscription;

    public PokeDetailPresenter(RxSchedulers schedulers, PokeDetailModel model, PokeDetailView view, CompositeSubscription sub){
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscription = sub;
    }

    public void onCreate(){

    }

    public void onResume(){

    }

    public void onPause(){

    }

    public void onDestroy(){
        subscription.clear();
    }

}
