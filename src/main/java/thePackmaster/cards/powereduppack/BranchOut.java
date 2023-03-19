package thePackmaster.cards.powereduppack;


import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.FlexibleDiscoveryAction;
import thePackmaster.packs.AbstractCardPack;

import java.util.ArrayList;

import static thePackmaster.SpireAnniversary5Mod.*;
import static thePackmaster.util.Wiz.getRandomItem;


public class BranchOut extends AbstractPoweredUpCard {
    public final static String ID = makeID("BranchOut");

    public BranchOut() {
        super(ID, 2, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 5;
        tags.add(CardTags.HEALING);
        FleetingField.fleeting.set(this, true);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCardPack> potentialPacks;
        if (allPacksMode) {
            potentialPacks = allPacks;
        } else {
            potentialPacks = new ArrayList<>();
            for (AbstractCardPack pack : allPacks) {
                if (!currentPoolPacks.contains(pack)) {
                    potentialPacks.add(pack);
                }
            }
        }

        ArrayList<AbstractCard> potentialCards = new ArrayList<>();
        for (AbstractCardPack pack : potentialPacks) {
            for (AbstractCard card : pack.cards) {
                if (card.type == CardType.POWER && card.rarity != CardRarity.SPECIAL &&
                        card.rarity != CardRarity.CURSE && !card.hasTag(CardTags.HEALING)) {
                    potentialCards.add(card.makeCopy());
                }
            }
        }

        ArrayList<AbstractCard> cards = new ArrayList<>();
        while (cards.size() < magicNumber) {
            AbstractCard card = getRandomItem(potentialCards);
            if (!cards.contains(card)) {
                cards.add(card);
            }
        }

        addToTop(new FlexibleDiscoveryAction(cards, selectedCard -> {
            AbstractDungeon.player.masterDeck.addToTop(selectedCard);
            selectedCard.update();
        }, false));
    }

    @Override
    public void upp() {
        upgradeBaseCost(1);
    }
}


