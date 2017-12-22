package alico.com.pokemoncards.model.rest.card;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alicanozkara on 22.12.2017.
 */

public class Card {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nationalPokedexNumber")
    @Expose
    private Integer nationalPokedexNumber;
    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;
    @SerializedName("imageUrlHiRes")
    @Expose
    private String imageUrlHiRes;
    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("supertype")
    @Expose
    private String supertype;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("hp")
    @Expose
    private String hp;
    @SerializedName("retreatCost")
    @Expose
    private List<String> retreatCost = null;
    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("rarity")
    @Expose
    private String rarity;
    @SerializedName("series")
    @Expose
    private String series;
    @SerializedName("set")
    @Expose
    private String set;
    @SerializedName("setCode")
    @Expose
    private String setCode;
    @SerializedName("attacks")
    @Expose
    private List<Attack> attacks = null;
    @SerializedName("weaknesses")
    @Expose
    private List<Weakness> weaknesses = null;
    @SerializedName("evolvesFrom")
    @Expose
    private String evolvesFrom;
    @SerializedName("ability")
    @Expose
    private Ability ability;
    @SerializedName("resistances")
    @Expose
    private List<Resistance> resistances = null;
    @SerializedName("text")
    @Expose
    private List<String> text = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public void setNationalPokedexNumber(Integer nationalPokedexNumber) {
        this.nationalPokedexNumber = nationalPokedexNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrlHiRes() {
        return imageUrlHiRes;
    }

    public void setImageUrlHiRes(String imageUrlHiRes) {
        this.imageUrlHiRes = imageUrlHiRes;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public List<String> getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(List<String> retreatCost) {
        this.retreatCost = retreatCost;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetCode() {
        return setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public List<Weakness> getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(List<Weakness> weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(String evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public List<Resistance> getResistances() {
        return resistances;
    }

    public void setResistances(List<Resistance> resistances) {
        this.resistances = resistances;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }

}
