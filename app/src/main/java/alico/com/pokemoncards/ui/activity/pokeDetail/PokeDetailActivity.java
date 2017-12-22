package alico.com.pokemoncards.ui.activity.pokeDetail;

import android.os.Bundle;

import javax.inject.Inject;

import alico.com.pokemoncards.application.App;
import alico.com.pokemoncards.base.BaseActivity;
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



}
