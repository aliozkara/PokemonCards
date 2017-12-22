package alico.com.pokemoncards.ui.activity.pokeList.di;

import alico.com.pokemoncards.application.builder.AppComponent;
import alico.com.pokemoncards.ui.activity.pokeList.PokeListActivity;
import dagger.Component;

/**
 * Created by alicanozkara on 20.12.2017.
 */

@PokeListScope
@Component(dependencies = {AppComponent.class}, modules = {PokeListModule.class})
public interface PokeListComponent {
    void inject(PokeListActivity activity);
}
