package thePackmaster.cards.powerfulpack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.powerfulpack.DoubleUpPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;


public class DoubleUp extends AbstractPowerfulCard {
    public final static String ID = makeID("DoubleUp");

    public DoubleUp() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new DoubleUpPower(p, magicNumber));

    }

    @Override
    public void upp() {
        this.isInnate = true;
    }
}


