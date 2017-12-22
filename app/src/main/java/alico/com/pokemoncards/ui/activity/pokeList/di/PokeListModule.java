package alico.com.pokemoncards.ui.activity.pokeList.di;

import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.ui.activity.pokeList.PokeListActivity;
import alico.com.pokemoncards.ui.activity.pokeList.core.PokeListModel;
import alico.com.pokemoncards.ui.activity.pokeList.core.PokeListPresenter;
import alico.com.pokemoncards.ui.activity.pokeList.core.PokeListView;
import alico.com.pokemoncards.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alicanozkara on 20.12.2017.
 */

@Module
public class PokeListModule {

    PokeListActivity activity;

    public PokeListModule(PokeListActivity context) {
        this.activity = context;
    }

    @PokeListScope
    @Provides
    PokeListView provideView(){
        return new PokeListView(activity);
    }

    @PokeListScope
    @Provides
    PokeListPresenter providePresenter(RxSchedulers schedulers, PokeListView view, PokeListModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new PokeListPresenter(schedulers, model, view, subscriptions);
    }

    @PokeListScope
    @Provides
    PokeListActivity provideContext(){
        return activity;
    }

    @PokeListScope
    @Provides
    PokeListModel provideModel(Api api){
        return new PokeListModel(activity, api);
    }

}
