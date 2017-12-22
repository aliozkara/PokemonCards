package alico.com.pokemoncards.ui.activity.pokeDetail.di;

import alico.com.pokemoncards.api.Api;
import alico.com.pokemoncards.ui.activity.pokeDetail.PokeDetailActivity;
import alico.com.pokemoncards.ui.activity.pokeDetail.core.PokeDetailModel;
import alico.com.pokemoncards.ui.activity.pokeDetail.core.PokeDetailPresenter;
import alico.com.pokemoncards.ui.activity.pokeDetail.core.PokeDetailView;
import alico.com.pokemoncards.utils.rx.RxSchedulers;
import dagger.Module;
import dagger.Provides;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alicanozkara on 20.12.2017.
 */

@Module
public class PokeDetailModule {


    PokeDetailActivity activity;

    public PokeDetailModule(PokeDetailActivity context) {
        this.activity = context;
    }

    @PokeDetailScope
    @Provides
    PokeDetailView provideView(){
        return new PokeDetailView(activity);
    }

    @PokeDetailScope
    @Provides
    PokeDetailPresenter providePresenter(RxSchedulers schedulers, PokeDetailView view, PokeDetailModel model) {
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new PokeDetailPresenter(schedulers, model, view, subscriptions);
    }

    @PokeDetailScope
    @Provides
    PokeDetailActivity provideContext(){
        return activity;
    }

    @PokeDetailScope
    @Provides
    PokeDetailModel provideModel(Api api){
        return new PokeDetailModel(activity, api);
    }

}
