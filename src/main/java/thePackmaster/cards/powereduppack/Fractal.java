package thePackmaster.cards.powereduppack;


import com.badlogic.gdx.graphics.g3d.particles.influencers.DynamicsModifier;
import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.FleetingField;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.unique.AddCardToDeckAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import thePackmaster.actions.FlexibleDiscoveryAction;
import thePackmaster.packs.AbstractCardPack;
import thePackmaster.powers.powereduppack.DoubleUpPower;
import thePackmaster.powers.powereduppack.StrengthStormPower;

import java.util.ArrayList;

import static thePackmaster.SpireAnniversary5Mod.*;
import static thePackmaster.util.Wiz.*;


public class Fractal extends AbstractPoweredUpCard {
    public final static String ID = makeID("Fractal");

    public Fractal() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = baseMagicNumber = 1;
        secondMagic = baseSecondMagic = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p, magicNumber));
        applyToSelf(new DexterityPower(p, magicNumber));
        applyToSelf(new FocusPower(p, magicNumber));
        if (upgraded) {
            AbstractCard offspring = new Fractal();
            for (int i = 1; i < timesUpgraded; i++) {
                offspring.upgrade();
            }
            atb(new MakeTempCardInDiscardAction(offspring, secondMagic));
        }
    }

    @Override
    public boolean canUpgrade () {
        return true;
    }

    @Override
    public void  upgrade() {
        if (upgraded) {
            cardsToPreview.upgrade();
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0]
                    + secondMagic + cardStrings.EXTENDED_DESCRIPTION[1]
                    + cardStrings.EXTENDED_DESCRIPTION[2] + timesUpgraded
                    + cardStrings.EXTENDED_DESCRIPTION[3];
        } else {
            cardsToPreview = new Fractal();
            rawDescription = cardStrings.DESCRIPTION + cardStrings.EXTENDED_DESCRIPTION[0]
                    + secondMagic + cardStrings.EXTENDED_DESCRIPTION[1]
                    + cardStrings.EXTENDED_DESCRIPTION[3];
        }
        timesUpgraded++;
        upgraded = true;
        name = cardStrings.NAME + "+" + timesUpgraded;
        initializeTitle();
        initializeDescription();
    }

    @Override
    public void upp() {
        upgrade();
    }
}


