//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package thePackmaster.actions.monsterhunterpack;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.vfx.GainPennyEffect;
import com.megacrit.cardcrawl.vfx.combat.FlashAtkImgEffect;

public class DamageButDontKill extends AbstractGameAction {
    private DamageInfo info;
    private int goldAmount;
    private static final float DURATION = 0.1F;
    private static final float POST_ATTACK_WAIT_DUR = 0.1F;
    private boolean skipWait;
    private boolean muteSfx;

    public DamageButDontKill(AbstractCreature target, DamageInfo info, AttackEffect effect) {
        this.goldAmount = 0;
        this.skipWait = false;
        this.muteSfx = false;
        this.info = info;
        this.setValues(target, info);
        this.actionType = ActionType.DAMAGE;
        this.attackEffect = effect;
        this.duration = 0.1F;
    }

    public DamageButDontKill(AbstractCreature target, DamageInfo info, int stealGoldAmount) {
        this(target, info, AttackEffect.SLASH_DIAGONAL);
        this.goldAmount = stealGoldAmount;
    }

    public DamageButDontKill(AbstractCreature target, DamageInfo info) {
        this(target, info, AttackEffect.NONE);
    }

    public DamageButDontKill(AbstractCreature target, DamageInfo info, boolean superFast) {
        this(target, info, AttackEffect.NONE);
        this.skipWait = superFast;
    }

    public DamageButDontKill(AbstractCreature target, DamageInfo info, AttackEffect effect, boolean superFast) {
        this(target, info, effect);
        this.skipWait = superFast;
    }

    public DamageButDontKill(AbstractCreature target, DamageInfo info, AttackEffect effect, boolean superFast, boolean muteSfx) {
        this(target, info, effect, superFast);
        this.muteSfx = muteSfx;
    }

    public void update() {
        if (this.shouldCancelAction() && this.info.type != DamageType.THORNS) {
            this.isDone = true;
        } else {
            if (this.duration == 0.1F) {
                if (this.info.type != DamageType.THORNS && (this.info.owner.isDying || this.info.owner.halfDead)) {
                    this.isDone = true;
                    return;
                }

                AbstractDungeon.effectList.add(new FlashAtkImgEffect(this.target.hb.cX, this.target.hb.cY, this.attackEffect, this.muteSfx));
                if (this.goldAmount != 0) {
                    this.stealGold();
                }
            }

            this.tickDuration();
            if (this.isDone) {
                if (this.attackEffect == AttackEffect.POISON) {
                    this.target.tint.color.set(Color.CHARTREUSE.cpy());
                    this.target.tint.changeColor(Color.WHITE.cpy());
                } else if (this.attackEffect == AttackEffect.FIRE) {
                    this.target.tint.color.set(Color.RED.cpy());
                    this.target.tint.changeColor(Color.WHITE.cpy());
                }

                if (this.info.output >= this.target.currentHealth + target.currentBlock){
                    this.info.output = this.target.currentHealth-1;
                }
                this.target.damage(this.info);
                if (AbstractDungeon.getCurrRoom().monsters.areMonstersBasicallyDead()) {
                    AbstractDungeon.actionManager.clearPostCombatActions();
                }

                if (!this.skipWait && !Settings.FAST_MODE) {
                    this.addToTop(new WaitAction(0.1F));
                }
            }

        }
    }

    private void stealGold() {
        if (this.target.gold != 0) {
            CardCrawlGame.sound.play("GOLD_JINGLE");
            if (this.target.gold < this.goldAmount) {
                this.goldAmount = this.target.gold;
            }

            AbstractCreature var10000 = this.target;
            var10000.gold -= this.goldAmount;

            for(int i = 0; i < this.goldAmount; ++i) {
                if (this.source.isPlayer) {
                    AbstractDungeon.effectList.add(new GainPennyEffect(this.target.hb.cX, this.target.hb.cY));
                } else {
                    AbstractDungeon.effectList.add(new GainPennyEffect(this.source, this.target.hb.cX, this.target.hb.cY, this.source.hb.cX, this.source.hb.cY, false));
                }
            }

        }
    }
}
