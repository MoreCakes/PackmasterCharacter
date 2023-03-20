package thePackmaster.cards.instadeathpack;

import thePackmaster.cards.AbstractPackmasterCard;

public abstract class AbstractInstadeathCard extends AbstractPackmasterCard {
    public AbstractInstadeathCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        super(cardID, cost, type, rarity, target, "astrologer","astrologer/orb.png");
    }

    public AbstractInstadeathCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color, "astrologer","astrologer/orb.png");
    }
}
