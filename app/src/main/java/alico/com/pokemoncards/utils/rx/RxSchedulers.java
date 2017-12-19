package alico.com.pokemoncards.utils.rx;

import rx.Scheduler;

/**
 * Created by alicanozkara on 19.12.2017.
 */

public interface RxSchedulers {


    Scheduler runOnBackground();

    Scheduler io();

    Scheduler compute();

    Scheduler androidThread();

    Scheduler internet();


}
