package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.powereduppack.StrengthStormPower;
import thePackmaster.powers.powereduppack.UnlimitedPowerPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class UnlimitedPower extends AbstractPoweredUpCard {
    public final static String ID = makeID("UnlimitedPower");

    public UnlimitedPower() {
        super(ID, 3, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new UnlimitedPowerPower(p, magicNumber), magicNumber));

    }

    @Override
    public void upp() {
        this.isInnate = true;
    }
}


