package alico.com.pokemoncards.ui.activity.pokeDetail.di;

import alico.com.pokemoncards.application.builder.AppComponent;
import alico.com.pokemoncards.ui.activity.pokeDetail.PokeDetailActivity;
import dagger.Component;

/**
 * Created by alicanozkara on 20.12.2017.
 */

@PokeDetailScope
@Component(dependencies = {AppComponent.class}, modules = {PokeDetailModule.class})
public interface PokeDetailComponent {
    void inject(PokeDetailActivity activity);
}
