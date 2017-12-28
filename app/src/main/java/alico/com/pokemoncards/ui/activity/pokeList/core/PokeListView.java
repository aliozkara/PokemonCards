package alico.com.pokemoncards.ui.activity.pokeList.core;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.jakewharton.rxbinding2.widget.RxTextView;

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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

/**
 * Created by alicanozkara on 20.12.2017.
 */

public class PokeListView {

    @BindView(R.id.wrapper)
    RelativeLayout wrapper;
    @BindView(R.id.activity_pokelist_tb_toolbar)
    Toolbar activity_pokelist_tb_toolbar;
    @BindView(R.id.activity_pokelist_rv_list)
    RecyclerView activity_pokelist_rv_list;
    @BindView(R.id.activity_pokelist_et_search)
    EditText activity_pokelist_et_search;

    private View view;
    private PokeListActivity context;
    private PokeListAdapter adapter;

    private List<Object> data;
    private int page = 0;
    private boolean loading = false;


    public PokeListView(PokeListActivity activity) {
        FrameLayout parent = new FrameLayout(activity);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(activity).inflate(R.layout.activity_pokelist, parent, true);
        ButterKnife.bind(this, view);
        this.context = activity;

        initView();
        listener();
    }

    public View view(){
        return view;
    }

    public void initView(){

        data = new ArrayList<>();

        activity_pokelist_rv_list.setLayoutManager(new LinearLayoutManager(context));
        adapter = new PokeListAdapter(context,data,activity_pokelist_rv_list);
        activity_pokelist_rv_list.setAdapter(adapter);

        io.reactivex.Observable.just(true)
                .timer(100, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(io.reactivex.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(s-> {
                    startLoading();
                    loading = true;
                    page = 0;
                    context.getCards(Constants.ITEM_LIMIT, page);
                });

    }

    public void connectionError(){
        Timber.e("CONNECTION ERROR");
    }

    public void apiError(Throwable error){
        Timber.e("API ERROR %s", error.toString());
    }

    public void cards(CardApiModel response){

        endLoading();
        loading = false;

        if(response.getCards().size() == 0){
            return;
        }

        for (int i = 0; i<response.getCards().size(); i++) {
            Card card =  response.getCards().get(i);
            data.add(new CardItem(card.getImageUrl(), card.getId()));
        }

        adapter.notifyItemRangeChanged(0, data.size());
        adapter.notifyDataSetChanged();
        adapter.setLoaded();
    }

    private void startLoading(){
        context.runOnUiThread(() -> adapter.setProgress());
    }

    private void endLoading(){
        context.runOnUiThread(() -> adapter.dismissProgress());
    }

    public void clearData() {
        context.runOnUiThread(() -> {
            int size = data.size();
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    data.remove(0);
                }
                adapter.notifyItemRangeRemoved(0, size);
            }
        });

    }


    private void listener(){

        RxTextView.textChanges(activity_pokelist_et_search)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .debounce(1, TimeUnit.SECONDS)
                .subscribe(s -> {
                   if(s.length() != 0){
                       clearData();
                       startLoading();
                       loading = true;
                       page = 0;
                       context.getCardSearch(s.toString(),Constants.ITEM_LIMIT, page);
                   }
                });


        adapter.setOnLoadMoreListener(() -> {
            if(!loading && data.size() >= Constants.ITEM_LIMIT) {
                adapter.setProgress();
                page++;
                if(activity_pokelist_et_search.getText().toString().length() != 0){
                    context.getCardSearch(activity_pokelist_et_search.getText().toString(),Constants.ITEM_LIMIT, page);
                    return;
                }
                context.getCards(Constants.ITEM_LIMIT, page);
            }
        });

        activity_pokelist_rv_list.setOnTouchListener((v, event) -> {
            InputMethodManager inm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
            inm.hideSoftInputFromWindow(v.getWindowToken(),0);
            return false;
        });
    }


}