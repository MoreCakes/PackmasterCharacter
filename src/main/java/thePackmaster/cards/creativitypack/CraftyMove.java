package thePackmaster.cards.creativitypack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.powers.creativitypack.FirewallPower;
import thePackmaster.util.JediUtil;

import static thePackmaster.SpireAnniversary5Mod.makeID;

public class CraftyMove extends AbstractPackmasterCard {

    public final static String ID = makeID(CraftyMove.class.getSimpleName());

    public CraftyMove() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = damage = 6;
    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        boolean cardCreatedThisTurn = JediUtil.cardsCreatedThisTurn.size() > 0;
        addToBot(new DamageAction(m, new DamageInfo(p, damage, damageTypeForTurn),
                cardCreatedThisTurn ? AbstractGameAction.AttackEffect.BLUNT_LIGHT : AbstractGameAction.AttackEffect.BLUNT_HEAVY));
        if (cardCreatedThisTurn)
        {
            addToBot(new GainEnergyAction(1));
            addToBot(new DrawCardAction(1));
        }
    }
}
