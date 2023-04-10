package thePackmaster.cards.powerfulpack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;
import com.megacrit.cardcrawl.powers.EnergizedPower;
import thePackmaster.powers.powerfulpack.GrowingMomentumCardsPower;
import thePackmaster.powers.powerfulpack.GrowingMomentumEnergyPower;
import thePackmaster.powers.powerfulpack.StrengthStormPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;
import static thePackmaster.util.Wiz.atb;


public class GrowingMomentum extends AbstractPowerfulCard {
    public final static String ID = makeID("GrowingMomentum");

    public GrowingMomentum() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new GrowingMomentumEnergyPower(p, 1));
        if (upgraded) {
            applyToSelf(new GrowingMomentumCardsPower(p, 1));
        }
    }

    @Override
    public void upp() {

    }
}


