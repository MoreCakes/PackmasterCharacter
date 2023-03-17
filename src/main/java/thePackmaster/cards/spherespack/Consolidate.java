package thePackmaster.cards.spherespack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.FocusPower;
import thePackmaster.SpireAnniversary5Mod;

public class Consolidate extends AbstractSpheresCard {
    public static final String ID = SpireAnniversary5Mod.makeID("Consolidate");
    private static final int COST = 1;
    private static final int FOCUS = 1;

    public Consolidate() {
        super(ID, COST, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        this.magicNumber = this.baseMagicNumber = FOCUS;
    }

    @Override
    public void upp() {
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        this.addToBot(new AbstractGameAction() {
            @Override
            public void update() {
                if (!upgraded) {
                    AbstractDungeon.player.removeNextOrb();
                }
                AbstractDungeon.player.removeNextOrb();
                this.isDone = true;
            }
        });
        this.addToBot(new ApplyPowerAction(p, p, new FocusPower(p, this.magicNumber)));
    }
}
