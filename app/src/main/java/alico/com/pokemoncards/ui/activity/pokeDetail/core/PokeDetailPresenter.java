package alico.com.pokemoncards.ui.activity.pokeDetail.core;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import alico.com.pokemoncards.model.bus.CardBusModel;
import alico.com.pokemoncards.utils.rx.RxSchedulers;
import rx.Subscription;
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

    public void onStart(){
        EventBus.getDefault().register(this);
    }

    public void onCreate(){

    }

    public void onResume(){

    }

    public void onPause(){

    }

    public void onStop(){
        EventBus.getDefault().unregister(this);
    }

    public void onDestroy(){
        subscription.clear();
    }


    public void card(String id){
        subscription.add(setCard(id));
    }

    private Subscription setCard(String id){

        return model.isNetworkAvailable()
                .doOnNext(networkAvailable -> {
                    if(!networkAvailable){
                        view.connectionError();
                    }
                })
                .filter(isNetworkAvailable -> isNetworkAvailable)
                .flatMap(isAvailable -> model.cardDetail(id))
                .subscribeOn(rxSchedulers.internet())
                .observeOn(rxSchedulers.androidThread())
                .subscribe(results -> view.card(results), throwable -> view.apiError(throwable));

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(CardBusModel model) {
        view.onEvent(model);
    }
}
