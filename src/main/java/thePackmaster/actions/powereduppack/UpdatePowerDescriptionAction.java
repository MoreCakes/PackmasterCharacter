package thePackmaster.actions.powereduppack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class UpdatePowerDescriptionAction extends AbstractGameAction {
    private  AbstractPower powerToUpdate;

    public UpdatePowerDescriptionAction(AbstractPower powerToUpdate) {
        this.powerToUpdate = powerToUpdate;
    }

    @Override
    public void update() {
        powerToUpdate.updateDescription();
        isDone = true;
    }
}