package thePackmaster.cards.powerfulpack;


import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.FocusPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static thePackmaster.SpireAnniversary5Mod.*;
import static thePackmaster.util.Wiz.*;


public class Fractal extends AbstractPowerfulCard {
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
    protected Texture getPortraitImage() {
        if (upgraded) {
            return ImageMaster.loadImage("anniv5Resources/images/cards/FractalUpgraded_p.png");
        }
        return super.getPortraitImage();
    }

    @Override
    public void  upgrade() {
        loadCardImage("anniv5Resources/images/cards/FractalUpgraded.png");
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


