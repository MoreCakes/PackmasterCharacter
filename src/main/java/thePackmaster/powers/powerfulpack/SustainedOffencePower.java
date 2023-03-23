package thePackmaster.powers.powerfulpack;


import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.OnReceivePowerPower;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DamageRandomEnemyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.actions.powerfulpack.UpdatePowerDescriptionAction;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;


public class SustainedOffencePower extends AbstractPackmasterPower implements NonStackablePower, OnReceivePowerPower {
    public static final String POWER_ID = makeID("SustainedOffencePower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String DESCRIPTIONS[] = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    private  int damage;


    public SustainedOffencePower(AbstractCreature owner, int damage) {
        super(POWER_ID,NAME,PowerType.BUFF,false,owner,1);
        isTwoAmount = true;
        this.damage = damage;
        updateDescription();
    }

    @Override
    public void atEndOfTurn (boolean isPlayer) {
        updateDescription();
        if (!AbstractDungeon.getMonsters().areMonstersBasicallyDead()) {
            for (int i = 0; i < amount; i++) {
                addToTop(new DamageRandomEnemyAction(
                        new DamageInfo(this.owner, amount2, DamageInfo.DamageType.THORNS),
                        AbstractGameAction.AttackEffect.SLASH_VERTICAL
                ));
                this.flash();
            }
        }
    }

    @Override
    public boolean isStackable(AbstractPower power) {
        if (power instanceof SustainedOffencePower) {
            return ((SustainedOffencePower) power).damage == this.damage;
        } else {
            return false;
        }
    }

    @Override
    public void updateDescription() {
        amount2 = damage + countStrength();
        if (amount == 1) {
            description = DESCRIPTIONS[0] + amount2 + DESCRIPTIONS[1];
        } else {
            description = DESCRIPTIONS[0] + amount2 + DESCRIPTIONS[2] + amount + DESCRIPTIONS[3];
        }
    }

    private int countStrength() {
        int strength = 0;
        for (AbstractPower p : this.owner.powers) {
            if (p.ID == StrengthPower.POWER_ID) {
                strength += p.amount;
            }
        }
        return strength;
    }


    @Override
    public boolean onReceivePower(AbstractPower power, AbstractCreature target, AbstractCreature source) {
        if (power.ID == StrengthPower.POWER_ID) {
            addToTop(new UpdatePowerDescriptionAction(this));
        }
        return true;
    }

}




