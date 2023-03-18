package thePackmaster.powers.powereduppack;


import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.DexterityPower;
import thePackmaster.actions.powereduppack.UpdatePowerDescriptionAction;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;


public class SustainedDefencePower extends AbstractPackmasterPower implements NonStackablePower, OnReceivePowerPower {
    public static final String POWER_ID = makeID("SustainedDefencePower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String DESCRIPTIONS[] = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public int block;

    public SustainedDefencePower(AbstractCreature owner, int block) {
        super(POWER_ID,NAME,PowerType.BUFF,false,owner,1);
        isTwoAmount = true;
        this.block = block;
        updateDescription();
    }

    @Override
    public void atEndOfTurn (boolean isPlayer) {
        amount2 = block + countDexterity();
        for (int i = 0; i < amount ; i++) {
            owner.addBlock(amount2);
            this.flash();
        }
    }

    private int countDexterity() {
        int dexterity = 0;
        for (AbstractPower p : this.owner.powers) {
            if (p.ID == DexterityPower.POWER_ID) {
                dexterity += p.amount;
            }
        }
        return dexterity;
    }

    @Override
    public boolean isStackable(AbstractPower power) {
        if (power instanceof SustainedDefencePower) {
            return ((SustainedDefencePower) power).block == this.block;
        } else {
            return false;
        }
    }

    @Override
    public void updateDescription() {
        amount2 = block + countDexterity();
        if (amount == 1) {
            description = DESCRIPTIONS[0] + amount2 + DESCRIPTIONS[1];
        } else {
            description = DESCRIPTIONS[0] + amount2 + DESCRIPTIONS[2] + amount + DESCRIPTIONS[3];
        }
    }


    @Override
    public boolean onReceivePower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power.ID == DexterityPower.POWER_ID) {
            addToTop(new UpdatePowerDescriptionAction(this));
        }
        return true;
    }
}




