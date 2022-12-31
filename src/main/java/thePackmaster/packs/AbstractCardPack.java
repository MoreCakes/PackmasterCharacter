package thePackmaster.packs;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardLibrary;
import thePackmaster.patches.CardParentPackPatch;

import java.util.ArrayList;

public abstract class AbstractCardPack {
    public String packID;
    public String name;
    public String description;
    public String author;
    public ArrayList<AbstractCard> cards;
    public AbstractCard previewPackCard;

    public AbstractCardPack(String id, String name, String description, String author) {
        this.packID = id;
        this.name = name;
        this.description = description;
        this.author = author;
        this.cards = new ArrayList<>();
        initializePack();
    }

    public abstract ArrayList<String> getCards();

    public void initializePack() {
        for (String s : getCards()) {
            AbstractCard c = CardLibrary.getCard(s);
            CardParentPackPatch.parentPack.set(c, this);
            cards.add(c.makeStatEquivalentCopy());

        }
        previewPackCard = new CardPackPreview(packID, this);

    }
}
