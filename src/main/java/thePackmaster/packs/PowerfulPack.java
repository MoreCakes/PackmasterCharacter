package thePackmaster.packs;

import com.megacrit.cardcrawl.cards.blue.ForceField;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.powerfulpack.*;

import java.util.ArrayList;

public class PowerfulPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID("PowerfulPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public PowerfulPack() {
        super(ID, NAME, DESC, AUTHOR);
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        //cards.add(StrengthStorm.ID);

        //cards.add(SustainedOffence.ID);
        //cards.add(SustainedDefence.ID);

        cards.add(DebilitatingStrike.ID);

        cards.add(Jettison.ID);
        cards.add(PowerfulCharge.ID);

        cards.add(ForceField.ID);
        cards.add(Fractal.ID);

        cards.add(DoubleUp.ID);
        cards.add(BranchOut.ID);
        return cards;
    }
}
