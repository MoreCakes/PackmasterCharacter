package thePackmaster.cards.powereduppack;


import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import thePackmaster.powers.powereduppack.SustainedDefencePower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;


public class SustainedDefence extends AbstractPoweredUpCard {
    public final static String ID = makeID("SustainedDefence");

    public SustainedDefence() {
        super(ID, 2, CardType.POWER, CardRarity.COMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 5;
    }


    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new ApplyPowerAction(p, p, new SustainedDefencePower(p, magicNumber), 1));
    }

    @Override
    public void applyPowers () {
        super.applyPowers();

        updateDescription(magicNumber + countDexterity());
    }

    private int countDexterity() {
        int dexterity = 0;
        for (AbstractPower p : AbstractDungeon.player.powers) {
            if (p.ID == DexterityPower.POWER_ID) {
                dexterity += p.amount;
            }
        }
        return dexterity;
    }

    private void updateDescription(int block) {
        this.rawDescription = cardStrings.EXTENDED_DESCRIPTION[0] + block + cardStrings.EXTENDED_DESCRIPTION[1];

        initializeDescription();
    }

    @Override
    public void upp() {
        upMagic(3);
    }
}


