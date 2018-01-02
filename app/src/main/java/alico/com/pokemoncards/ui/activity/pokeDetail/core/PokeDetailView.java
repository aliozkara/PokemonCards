package alico.com.pokemoncards.ui.activity.pokeDetail.core;

import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import alico.com.pokemoncards.R;
import alico.com.pokemoncards.model.bus.CardBusModel;
import alico.com.pokemoncards.model.rest.CardDetailApiModel;
import alico.com.pokemoncards.ui.activity.pokeDetail.PokeDetailActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeDetailView {

    @BindView(R.id.wrapper)
    RelativeLayout wrapper;
    @BindView(R.id.activity_pokedetail_tb_toolbar)
    Toolbar activity_pokedetail_tb_toolbar;
    @BindView(R.id.activity_pokedetail_iv_show)
    ImageView activity_pokedetail_iv_show;

    View view;
    PokeDetailActivity context;

    public PokeDetailView(PokeDetailActivity activity) {
        FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(activity).inflate(R.layout.activity_pokedetail, parent, true);
        ButterKnife.bind(this, view);
        this.context = activity;

        initView();
        listener();
    }

    public View view(){
        return view;
    }

    private void initView() {
    }

    public void connectionError(){
        Timber.e("CONNECTION ERROR");
    }

    public void apiError(Throwable error){
        Timber.e("API ERROR %s", error.toString());
    }

    public void card(CardDetailApiModel response){
        Timber.e("DATA %s", response);

        activity_pokedetail_tb_toolbar.setTitle(response.getCard().getName());
        Picasso.with(context).load(response.getCard().getImageUrlHiRes()).into(activity_pokedetail_iv_show);
    }

    public void onEvent(CardBusModel model) {
        context.getCard(model.getId());
    }

    private void listener(){
        activity_pokedetail_tb_toolbar.setNavigationOnClickListener(view -> context.finish());
    }

}
