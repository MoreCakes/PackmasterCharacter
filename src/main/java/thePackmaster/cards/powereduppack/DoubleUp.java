package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.powereduppack.DoubleUpPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class DoubleUp extends AbstractPoweredUpCard {
    public final static String ID = makeID("DoubleUp");

    public DoubleUp() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new DoubleUpPower(p, magicNumber), magicNumber));

    }

    @Override
    public void upp() {
        this.isInnate = true;
    }
}


