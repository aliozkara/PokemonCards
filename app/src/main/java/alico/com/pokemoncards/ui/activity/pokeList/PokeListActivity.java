package alico.com.pokemoncards.ui.activity.pokeList;

import android.os.Bundle;

import javax.inject.Inject;

import alico.com.pokemoncards.application.App;
import alico.com.pokemoncards.base.BaseActivity;
import alico.com.pokemoncards.ui.activity.pokeList.core.PokeListPresenter;
import alico.com.pokemoncards.ui.activity.pokeList.core.PokeListView;
import alico.com.pokemoncards.ui.activity.pokeList.di.DaggerPokeListComponent;
import alico.com.pokemoncards.ui.activity.pokeList.di.PokeListModule;

public class PokeListActivity extends BaseActivity {


    @Inject
    PokeListView view;
    @Inject
    PokeListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerPokeListComponent.builder().appComponent(App.getNetComponent()).pokeListModule(new PokeListModule(this)).build().inject(this);
        setContentView(view.view());

        presenter.onCreate();

    }


    public void getCards(int pageSize, int page){
        presenter.cards(pageSize, page);
    }

    public void getCardSearch(String name ,int pageSize, int page){
        presenter.cardSearch(name, pageSize, page);
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
