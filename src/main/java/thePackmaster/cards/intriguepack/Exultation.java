package thePackmaster.cards.intriguepack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Exultation extends AbstractIntrigueCard {
    public final static String ID = makeID("Exultation");

    public Exultation() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 3;
        baseBlock = -1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        Wiz.atb(new AbstractGameAction() {
            @Override
            public void update() {
                for(AbstractCard c : Wiz.p().hand.group)
                {
                    if (c != Exultation.this)
                        promote(c);
                }
                isDone = true;
            }
        });
        blck();
    }

    public void applyPowers() {
        int count = 0;

        for(AbstractCard c : Wiz.p().hand.group)
        {
            if (isPromotable(c) && c != this)
                count++;
        }

        this.baseBlock = count * this.magicNumber;
        super.applyPowers();
        this.rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
