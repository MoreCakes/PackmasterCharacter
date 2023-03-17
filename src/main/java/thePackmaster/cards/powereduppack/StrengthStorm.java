package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.downfallpack.AwakenDeathPower;
import thePackmaster.powers.powereduppack.StrengthStormPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class StrengthStorm extends AbstractPoweredUpCard {
    public final static String ID = makeID("StrengthStorm");

    public StrengthStorm() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new StrengthStormPower(p, magicNumber), magicNumber));

    }

    @Override
    public void upp() {

    }
}


