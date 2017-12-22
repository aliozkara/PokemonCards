package alico.com.pokemoncards.model.rest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import alico.com.pokemoncards.model.rest.card.Card;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class CardApiModel {

    @SerializedName("cards")
    @Expose
    private List<Card> cards = null;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
