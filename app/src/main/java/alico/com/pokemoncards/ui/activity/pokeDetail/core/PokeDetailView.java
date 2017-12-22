package alico.com.pokemoncards.ui.activity.pokeDetail.core;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toolbar;

import alico.com.pokemoncards.R;
import alico.com.pokemoncards.ui.activity.pokeDetail.PokeDetailActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeDetailView {

    @BindView(R.id.wrapper)
    RelativeLayout wrapper;
    @BindView(R.id.activity_pokedetail_tb_toolbar)
    Toolbar activity_pokedetail_tb_toolbar;

    View view;
    PokeDetailActivity context;

    Disposable disposable;

    public PokeDetailView(PokeDetailActivity activity) {
        FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(activity).inflate(R.layout.activity_pokedetail, parent, true);
        ButterKnife.bind(this, view);
        this.context = activity;

        initView();
    }

    public View view(){
        return view;
    }

    private void initView(){

    }

}
