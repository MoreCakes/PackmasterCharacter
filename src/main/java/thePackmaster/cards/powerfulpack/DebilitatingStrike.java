package thePackmaster.cards.powerfulpack;


import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import thePackmaster.actions.powerfulpack.PowerfulChargeAction;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToEnemy;
import static thePackmaster.util.Wiz.atb;


public class DebilitatingStrike extends AbstractPowerfulCard {
    public final static String ID = makeID("DebilitatingStrike");

    public DebilitatingStrike() {
        super(ID, 1, CardType.ATTACK, CardRarity.SPECIAL, CardTarget.ENEMY, CardColor.COLORLESS);
        damage = baseDamage = 6;
        magicNumber = baseMagicNumber = 1;
        tags.add(CardTags.STRIKE);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.SLASH_DIAGONAL);
        applyToEnemy(m, new VulnerablePower(m, magicNumber, false));
        applyToEnemy(m, new WeakPower(m, magicNumber, false));
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}


