package thePackmaster.cards.powerfulpack;


import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.pixiepack.DrawSpecificCardAction;
import thePackmaster.actions.powerfulpack.PreplannedBarrierAction;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;
import static thePackmaster.util.Wiz.drawPile;


public class PreplannedBarrier extends AbstractPowerfulCard {
    public final static String ID = makeID("PreplannedBarrier");

    public PreplannedBarrier() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        block = baseBlock = 10;
    }


    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
    }

    @Override
    public void onPlayCard(AbstractCard c, AbstractMonster m) {
        super.onPlayCard(c, m);
        if (c.type == CardType.POWER && drawPile().contains(this)) {
            atb(new PreplannedBarrierAction(this));
        }
    }

    @Override
    public void upp() {
        upgradeBlock(4);
    }
}


