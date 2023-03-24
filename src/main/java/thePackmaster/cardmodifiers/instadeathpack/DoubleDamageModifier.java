package thePackmaster.cardmodifiers.instadeathpack;

import basemod.abstracts.AbstractCardModifier;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class DoubleDamageModifier extends AbstractCardModifier {
    @Override
    public float modifyDamageFinal(float damage, DamageInfo.DamageType type, AbstractCard card, AbstractMonster target) {
        return damage * 2;
    }

    @Override
    public AbstractCardModifier makeCopy() {
        return new DoubleDamageModifier();
    }
}
