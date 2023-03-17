package thePackmaster.cards.dimensiongatepack3;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.dimensiongateabstracts.AbstractDimensionalCardTrain;
import thePackmaster.powers.shamanpack.IgnitePower;
import thePackmaster.util.Wiz;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class Inferno extends AbstractDimensionalCardTrain {
    public final static String ID = makeID("Inferno");

    public Inferno() {
        super(ID, 1, CardRarity.UNCOMMON, CardType.ATTACK, CardTarget.ALL_ENEMY);
        baseDamage = 10;
        baseMagicNumber = magicNumber = 2;
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        Wiz.forAllMonstersLiving((mo)->
                Wiz.applyToEnemy(mo, new IgnitePower(mo,10)));

        Wiz.applyToSelf(new IgnitePower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(-1);
    }
}