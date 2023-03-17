package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.powereduppack.StrikeFormPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class StrikeForm extends AbstractPoweredUpCard {
    public final static String ID = makeID("StrikeForm");

    public StrikeForm() {
        super(ID, 2, CardType.POWER, CardRarity.COMMON, CardTarget.SELF);
        damage = baseDamage = 6;
        tags.add(CardTags.STRIKE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new StrikeFormPower(p, this), 1));

    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}


