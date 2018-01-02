package alico.com.pokemoncards.ui.activity.pokeDetail;

import android.os.Bundle;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import alico.com.pokemoncards.application.App;
import alico.com.pokemoncards.base.BaseActivity;
import alico.com.pokemoncards.model.bus.CardBusModel;
import alico.com.pokemoncards.ui.activity.pokeDetail.core.PokeDetailPresenter;
import alico.com.pokemoncards.ui.activity.pokeDetail.core.PokeDetailView;
import alico.com.pokemoncards.ui.activity.pokeDetail.di.DaggerPokeDetailComponent;
import alico.com.pokemoncards.ui.activity.pokeDetail.di.PokeDetailModule;

public class PokeDetailActivity extends BaseActivity {


    @Inject
    PokeDetailView view;
    @Inject
    PokeDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerPokeDetailComponent.builder().appComponent(App.getNetComponent()).pokeDetailModule(new PokeDetailModule(this)).build().inject(this);
        setContentView(view.view());

        presenter.onCreate();

    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    public void getCard(String id){
        presenter.card(id);
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(CardBusModel model) {
        presenter.onEvent(model);
    }
}
