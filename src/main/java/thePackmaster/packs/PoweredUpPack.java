package thePackmaster.packs;

import com.megacrit.cardcrawl.cards.blue.ForceField;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.powereduppack.StrengthStorm;
import thePackmaster.cards.powereduppack.StrikeForm;
import thePackmaster.cards.powereduppack.UnlimitedPower;

import java.util.ArrayList;

public class PoweredUpPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID("PoweredUpPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public PoweredUpPack() {
        super(ID, NAME, DESC, AUTHOR);
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();
        cards.add(StrengthStorm.ID);

        cards.add(StrikeForm.ID);

        cards.add(UnlimitedPower.ID);
        cards.add(ForceField.ID);
        return cards;
    }
}
