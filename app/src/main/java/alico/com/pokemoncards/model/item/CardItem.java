package alico.com.pokemoncards.model.item;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class CardItem {

    String imageUrl, id;

    public CardItem(String imageUrl, String id) {
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
