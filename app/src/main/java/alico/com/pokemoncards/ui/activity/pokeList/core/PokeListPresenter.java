package alico.com.pokemoncards.ui.activity.pokeList.core;

import alico.com.pokemoncards.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeListPresenter {

    PokeListView view;
    PokeListModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscription;

    public PokeListPresenter(RxSchedulers schedulers, PokeListModel model, PokeListView view, CompositeSubscription sub){
        this.rxSchedulers = schedulers;
        this.view = view;
        this.model = model;
        this.subscription = sub;

        view.initView();
    }

    public void cards(int pageSize){
        subscription.add(setCards(pageSize));
    }

    private Subscription setCards(int pageSize){

        return model.isNetworkAvailable()
                .doOnNext(networkAvailable -> {
                    if(!networkAvailable){
                        view.connectionError();
                    }
                })
                .filter(isNetworkAvailable -> isNetworkAvailable)
                .flatMap(isAvailable -> model.cards(pageSize))
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(results -> view.cards(results), throwable -> view.apiError(throwable));

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
