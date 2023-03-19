package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.powereduppack.PowerfulChargeAction;
import thePackmaster.powers.powereduppack.DoubleUpPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class PowerfulCharge extends AbstractPoweredUpCard {
    public final static String ID = makeID("PowerfulCharge");

    public PowerfulCharge() {
        super(ID, 2, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY);
        damage = baseDamage = 12;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.BLUNT_LIGHT);
        atb(new PowerfulChargeAction());
    }

    @Override
    public void upp() {
        upgradeDamage(4);
    }
}


