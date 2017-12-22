package alico.com.pokemoncards.ui.activity.pokeList.core;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import alico.com.pokemoncards.R;
import alico.com.pokemoncards.adapters.PokeListAdapter;
import alico.com.pokemoncards.model.item.CardItem;
import alico.com.pokemoncards.model.rest.CardApiModel;
import alico.com.pokemoncards.model.rest.card.Card;
import alico.com.pokemoncards.ui.activity.pokeList.PokeListActivity;
import alico.com.pokemoncards.utils.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeListView {

    @BindView(R.id.wrapper)
    RelativeLayout wrapper;
    @BindView(R.id.activity_pokelist_tb_toolbar)
    Toolbar activity_pokelist_tb_toolbar;
    @BindView(R.id.activity_pokelist_srl_refresh)
    SwipeRefreshLayout activity_pokelist_srl_refresh;
    @BindView(R.id.activity_pokelist_rv_list)
    RecyclerView activity_pokelist_rv_list;

    private View view;
    private PokeListActivity context;
    private PokeListAdapter adapter;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
    private Disposable disposable;

    private List<Object> data;
    private int offset = 0;
    private boolean loading = false;


    public PokeListView(PokeListActivity activity) {
        FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(activity).inflate(R.layout.activity_pokelist, parent, true);
        ButterKnife.bind(this, view);
        this.context = activity;

    }

    public View view(){
        return view;
    }

    public void initView(){

        data = new ArrayList<>();

        adapter = new PokeListAdapter(context,data,activity_pokelist_rv_list);
        activity_pokelist_rv_list.setAdapter(adapter);
        activity_pokelist_rv_list.setLayoutManager(new StaggeredGridLayoutManager(2, 1));

        io.reactivex.Observable.just(true)
                .timer(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(s->{
                    context.getCards(Constants.ITEM_LIMIT);
                });

    }

    public void connectionError(){

    }

    public void apiError(Throwable error){

    }

    public void cards(CardApiModel response){

        if(response.getCards().size() == 0){
            return;
        }

        for (int i = 0; i<response.getCards().size(); i++) {

            Card card =  response.getCards().get(i);

            data.add(new CardItem(card.getImageUrl(), card.getId()));

        }

        adapter.notifyItemRangeChanged(0, data.size());
        adapter.notifyDataSetChanged();

    }


}
