package thePackmaster.actions.powereduppack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class UpdateStrikeFormDescriptionAction extends AbstractGameAction {
    private  AbstractCreature creatureToUpdate;
    private  String powerToUpdate;

    public UpdateStrikeFormDescriptionAction(AbstractCreature creatureToUpdate, String powerToUpdate) {
        this.powerToUpdate = powerToUpdate;
        this.creatureToUpdate = creatureToUpdate;
    }

    @Override
    public void update() {
        for (AbstractPower p : creatureToUpdate.powers) {
            if (p.ID == powerToUpdate) {
                p.updateDescription();
            }
        }
    }
}