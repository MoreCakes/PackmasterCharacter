package thePackmaster.actions.powereduppack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.util.Wiz;

import java.util.ArrayList;

import static thePackmaster.util.Wiz.*;

public class PowerfulChargeAction extends AbstractGameAction {

    public PowerfulChargeAction() {}

    @Override
    public void update() {
        ArrayList<AbstractCard> idealTargets = new ArrayList<>();
        ArrayList<AbstractCard> tolerableTargets = new ArrayList<>();
        for (AbstractCard card : hand().group) {
            if (card.type == AbstractCard.CardType.POWER && card.cost > 0) {
                if (card.costForTurn > 0) {
                    idealTargets.add(card);
                } else {
                    tolerableTargets.add(card);
                }
            }
        }
        AbstractCard target = null;
        if (idealTargets.size() > 0) {
            target = getRandomItem(idealTargets);
        } else if (tolerableTargets.size() > 0) {
            target = getRandomItem(tolerableTargets);
        }
        if (target != null) {
            att(new ReduceCostAction(target));
        }

        isDone = true;
    }
}