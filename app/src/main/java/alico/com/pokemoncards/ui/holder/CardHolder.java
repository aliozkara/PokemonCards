package alico.com.pokemoncards.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.facebook.drawee.view.SimpleDraweeView;

import alico.com.pokemoncards.R;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class CardHolder extends RecyclerView.ViewHolder {

    public RelativeLayout wrapper;
    public SimpleDraweeView item_pokelist_sdv_img;


    public CardHolder(View itemView){
        super(itemView);

        wrapper = itemView.findViewById(R.id.wrapper);
        item_pokelist_sdv_img = itemView.findViewById(R.id.item_pokelist_sdv_img);



    }


}
