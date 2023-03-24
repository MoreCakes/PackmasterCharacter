package thePackmaster.cards.powerfulpack;


import basemod.cardmods.EtherealMod;
import basemod.cardmods.ExhaustMod;
import basemod.helpers.CardModifierManager;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.actions.FlexibleDiscoveryAction;
import thePackmaster.packs.AbstractCardPack;

import java.util.ArrayList;

import static thePackmaster.SpireAnniversary5Mod.*;
import static thePackmaster.util.Wiz.*;


public class Envision extends AbstractPowerfulCard {
    public final static String ID = makeID("Envision");

    public Envision() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        ArrayList<AbstractCard> potentialCards = getCardsMatchingPredicate((c) -> c.type == CardType.POWER
                && !c.hasTag(CardTags.HEALING) && c.rarity != CardRarity.SPECIAL && c.rarity != CardRarity.CURSE);
        AbstractCard card = getRandomItem(potentialCards);
        if (upgraded) {
            card.upgrade();
        }
        CardModifierManager.addModifier(card, new EtherealMod());
        atb(new MakeTempCardInHandAction(card));
    }

    @Override
    public void upp() {}
}


