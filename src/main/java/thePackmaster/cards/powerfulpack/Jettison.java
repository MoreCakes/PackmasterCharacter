package thePackmaster.cards.powerfulpack;


import com.evacipated.cardcrawl.mod.stslib.actions.common.SelectCardsInHandAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.localization.UIStrings;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;


public class Jettison extends AbstractPowerfulCard {
    public final static String ID = makeID("Jettison");
    private static UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("DiscardAction");
    private static String[] TEXT = uiStrings.TEXT;

    public Jettison() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        block = baseBlock = 8;
        magicNumber = baseMagicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        atb(new SelectCardsInHandAction(1, TEXT[0],false, upgraded,
                (c) -> {return true;},
                (l) -> {
                    boolean powerDiscarded = false;
                    for (AbstractCard c : l) {
                        att(new DiscardSpecificCardAction(c));
                        if (c.type == CardType.POWER) {
                            powerDiscarded = true;
                        }
                    }
                    if (powerDiscarded) {
                        atb(new DrawCardAction(p, magicNumber));
                    }
                }
                ));
    }

    @Override
    public void upp() {
        upgradeBlock(2);
    }
}


