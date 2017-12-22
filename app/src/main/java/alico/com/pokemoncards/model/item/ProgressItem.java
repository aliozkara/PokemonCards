package alico.com.pokemoncards.model.item;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class ProgressItem {

    private boolean isStart;

    public ProgressItem(boolean isStart) {
        this.isStart = isStart;
    }


    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean getStart() {
        return isStart;
    }

}
