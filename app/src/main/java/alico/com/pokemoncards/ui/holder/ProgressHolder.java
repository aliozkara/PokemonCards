package alico.com.pokemoncards.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import alico.com.pokemoncards.R;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class ProgressHolder extends RecyclerView.ViewHolder {

    public ProgressBar item_progress_pb_view;

    public ProgressHolder(View itemView){
        super(itemView);

        item_progress_pb_view = itemView.findViewById(R.id.item_progress_pb_view);


    }


}
