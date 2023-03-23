package thePackmaster.cards.powerfulpack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.powerfulpack.StrengthStormPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class StrengthStorm extends AbstractPowerfulCard {
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


