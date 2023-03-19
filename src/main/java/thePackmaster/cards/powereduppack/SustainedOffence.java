package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.powers.powereduppack.SustainedOffencePower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;
import static thePackmaster.util.Wiz.p;


public class SustainedOffence extends AbstractPoweredUpCard {
    public final static String ID = makeID("SustainedOffence");

    public SustainedOffence() {
        super(ID, 2, CardType.POWER, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 6;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new SustainedOffencePower(p, magicNumber), 1));
    }

    @Override
    public void applyPowers () {
        super.applyPowers();

        updateDescription(magicNumber + countStrength());
    }

    private int countStrength() {
        int strength = 0;
        for (AbstractPower p : p().powers) {
            if (p.ID == StrengthPower.POWER_ID) {
                strength += p.amount;
            }
        }
        return strength;
    }

    private void updateDescription(int damage) {
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0] + damage + cardStrings.EXTENDED_DESCRIPTION[1];

        initializeDescription();
    }

    @Override
    public void upp() {
        upMagic(3);
    }
}


