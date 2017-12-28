package alico.com.pokemoncards.adapters;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import alico.com.pokemoncards.R;
import alico.com.pokemoncards.listener.OnLoadMoreListener;
import alico.com.pokemoncards.model.item.CardItem;
import alico.com.pokemoncards.model.item.ProgressItem;
import alico.com.pokemoncards.ui.holder.CardHolder;
import alico.com.pokemoncards.ui.holder.ProgressHolder;
import alico.com.pokemoncards.utils.Constants;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class PokeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_DEFAULT = 0;
    private static final int TYPE_PROGRESS = 1;

    private Activity activity;
    private LayoutInflater layoutInflater;
    private List<Object> list;
    private OnLoadMoreListener onLoadMoreListener;


    private int visibleThreshold = Constants.ITEM_LIMIT;
    private int lastVisibleItem, totalItemCount;
    private boolean isLoading;


    public PokeListAdapter(Activity activity, List<Object> list, RecyclerView recyclerView) {
        super();
        setHasStableIds(true);
        this.activity = activity;
        this.layoutInflater = LayoutInflater.from(activity);
        this.list = list;


        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                    totalItemCount = linearLayoutManager.getItemCount();
                    lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                    if (!isLoading && totalItemCount <= (lastVisibleItem + visibleThreshold)) {
                        if (onLoadMoreListener != null) {
                            onLoadMoreListener.onLoadMore();
                        }
                        isLoading = true;
                    }

            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof CardItem) {
            return TYPE_DEFAULT;
        } else if (list.get(position) instanceof ProgressItem) {
            return TYPE_PROGRESS;
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (i) {
            case TYPE_DEFAULT:
                View v1 = inflater.inflate(R.layout.item_pokelist, viewGroup, false);
                viewHolder = new CardHolder(v1);
                break;
            case TYPE_PROGRESS:
                View v2 = inflater.inflate(R.layout.item_progress, viewGroup, false);
                viewHolder = new ProgressHolder(v2);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case TYPE_DEFAULT:
                CardHolder vh1 = (CardHolder) viewHolder;
                configureDefault(vh1, i);
                break;
            case TYPE_PROGRESS:
                ProgressHolder vh2 = (ProgressHolder) viewHolder;
                configureProgress(vh2, i);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setOnLoadMoreListener(OnLoadMoreListener mOnLoadMoreListener) {
        this.onLoadMoreListener = mOnLoadMoreListener;
    }

    public void setProgress() {
        list.add(new ProgressItem(true));
        notifyItemRangeInserted(0, list.size());
        notifyDataSetChanged();
    }

    public void dismissProgress() {
        list.remove(list.size()-1);
        notifyItemRemoved(list.size()-1);
        notifyItemRangeChanged(list.size()-1, list.size());
    }

    public void setLoaded() {
        isLoading = false;
    }

    private void configureDefault(final CardHolder vh, int position) {

        final CardItem cardItem = (CardItem) list.get(position);

        vh.item_pokelist_sdv_img.setImageURI(Uri.parse(cardItem.getImageUrl()));

    }

    private void configureProgress(final ProgressHolder vh, int position) {

        final ProgressItem cardItem = (ProgressItem) list.get(position);
        if(cardItem.getStart()){
            vh.item_progress_pb_view.setVisibility(View.VISIBLE);
            return;
        }
        vh.item_progress_pb_view.setVisibility(View.GONE);

    }


}
