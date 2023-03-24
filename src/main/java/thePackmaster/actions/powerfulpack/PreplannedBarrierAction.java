package thePackmaster.actions.powerfulpack;

import basemod.BaseMod;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ReduceCostAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;

import static thePackmaster.util.Wiz.*;

public class PreplannedBarrierAction extends AbstractGameAction {
    private AbstractCard toDraw;
    private AbstractPlayer player;

    public PreplannedBarrierAction(AbstractCard toDraw) {
        this.toDraw = toDraw;
        actionType = ActionType.CARD_MANIPULATION;
        duration = Settings.ACTION_DUR_FAST;
        player = AbstractDungeon.player;
    }

    @Override
    public void update() {
        if (drawPile().contains(toDraw)) {
            if (player.hand.size() < BaseMod.MAX_HAND_SIZE) {
                drawPile().moveToHand(toDraw);
            } else {
                player.createHandIsFullDialog();
            }
        }
        isDone = true;
    }
}