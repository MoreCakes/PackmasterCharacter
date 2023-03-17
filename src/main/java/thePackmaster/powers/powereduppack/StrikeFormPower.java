package thePackmaster.powers.powereduppack;


import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.actions.common.AttackDamageRandomEnemyAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;


public class StrikeFormPower extends AbstractPackmasterPower implements NonStackablePower{
    public static final String POWER_ID = makeID("StrikeFormPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String DESCRIPTIONS[] = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    private  AbstractCard card;


    public StrikeFormPower(AbstractCreature owner, AbstractCard card) {
        super(POWER_ID,NAME,PowerType.BUFF,false,owner,1);
        this.card = card;
        isTwoAmount = true;
        amount2 = card.damage;
        updateDescription();
    }

    @Override
    public void atEndOfTurn (boolean isPlayer) {
        for (int i = 0; i < amount ; i++) {
            addToBot(new AttackDamageRandomEnemyAction(card));
        }
    }

    @Override
    public  void onAfterUseCard (AbstractCard card, UseCardAction action) {
        updateDescription();
    }

    @Override
    public  void atStartOfTurn () {
        updateDescription();
    }

    @Override
    public boolean isStackable(AbstractPower power) {
        if (power instanceof StrikeFormPower) {
            return ((StrikeFormPower) power).getDamage() == this.getDamage();
        } else {
            return false;
        }
    }

    public int getDamage() {
        card.calculateCardDamage(null);
        return  card.damage;
    }

    @Override
    public void updateDescription() {
        if (card != null) {
            card.calculateDamageDisplay(null);
            amount2 = card.damage;
            if (amount == 1) {
                description = DESCRIPTIONS[0] + card.damage + DESCRIPTIONS[1];
            } else {
                description = DESCRIPTIONS[0] + card.damage + DESCRIPTIONS[2] + amount + DESCRIPTIONS[3];
            }
        }
    }

}




