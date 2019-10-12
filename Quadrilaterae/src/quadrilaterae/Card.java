package quadrilaterae;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

public class Card extends Pane
{
    private final Background CARD_HIDDEN;
    private final Background cardShownP;
    private final Background cardShownO;
    private final int ATTACK_UP;
    private final int ATTACK_RIGHT;
    private final int ATTACK_DOWN;
    private final int ATTACK_LEFT;
    private final String CARD_NAME;
    private boolean claimed;
    private boolean visible;
    private CardUser ownedBy;
    private int x;
    private int y;
    
    public Card(int ATTACK_UP, int ATTACK_RIGHT, int ATTACK_DOWN, int ATTACK_LEFT, String CARD_NAME, boolean claimed, boolean visible, CardUser ownedBy, int cardNumber)
    {
        this.CARD_HIDDEN = new Background(new BackgroundImage(
                                            Config.getImages().get(12),
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundPosition.DEFAULT,
                                            BackgroundSize.DEFAULT));
        this.cardShownP = new Background(new BackgroundImage(
                                            Config.getImages().get(cardNumber+1),
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundPosition.DEFAULT,
                                            BackgroundSize.DEFAULT));
        this.cardShownO = new Background(new BackgroundImage(
                                            Config.getImages().get(cardNumber),
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundRepeat.NO_REPEAT,
                                            BackgroundPosition.DEFAULT,
                                            BackgroundSize.DEFAULT));
        
        this.ATTACK_UP = ATTACK_UP;
        this.ATTACK_RIGHT = ATTACK_RIGHT;
        this.ATTACK_DOWN = ATTACK_DOWN;
        this.ATTACK_LEFT = ATTACK_LEFT;
        this.CARD_NAME = CARD_NAME;
        this.claimed = claimed;
        this.visible = visible;
        this.ownedBy = ownedBy;
        
        this.prefWidth(150);
        this.prefHeight(250);
        
        if(this.claimed == true)
        {
            this.setBackground(cardShownP);
        }
        else
        {
            this.setBackground(CARD_HIDDEN);
        }
    }
    
    public void setCoords(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public int getX()
    {
        return this.x;
    }
    
    public int getY()
    {
        return this.y;
    }
    
    public CardUser getOwner()
    {
        return this.ownedBy;
    }
    
    public void setCardVisible(boolean value)
    {
        this.visible = value;
    }
    
    public void setCardClaimed(boolean value)
    {
        this.claimed = value;
    }
    
    public boolean getClaimed()
    {
        return this.claimed;
    }
    
    public int getAttackUp()
    {
        return this.ATTACK_UP;
    }
    
    public int getAttackRight()
    {
        return this.ATTACK_RIGHT;
    }
    
    public int getAttackDown()
    {
        return this.ATTACK_DOWN;
    }
    
    public int getAttackLeft()
    {
        return this.ATTACK_LEFT;
    }
    
    public void showCard()
    {
        if(this.visible == true)
        {
            if(this.claimed == true)
            {
                this.setBackground(cardShownP);
            }
            else
            {
                this.setBackground(cardShownO);
            }
        }
    }
    
    public void update()
    {
        this.setTranslateX(0);
        this.setTranslateY(0);
    }
    
    public String checkStats(Card opponentCard)
    {
        String result;
        if(this.getAttackUp() > opponentCard.getAttackDown())
        {
            result = "Up";
            return result;
        }
        else if(this.getAttackRight() > opponentCard.getAttackLeft())
        {
            result = "Right";
            return result;
        }
        else if(this.getAttackDown() > opponentCard.getAttackUp())
        {
            result = "Down";
            return result;
        }
        else if(this.getAttackLeft() > opponentCard.getAttackRight())
        {
            result = "Left";
            return result;
        }
        else
        {
            result = "Beaten";
            return result;
        }
    }
    
    public void battle(Card opponentCard, CardUser user, String direction)
    {
        if(direction.equals("Up"))
        {
            if(this.getAttackUp() > opponentCard.getAttackDown())
            {
                if(user.isPlayer())
                {
                    opponentCard.setCardClaimed(true);
                    opponentCard.showCard();
                }
                else
                {
                    opponentCard.setCardClaimed(false);
                    opponentCard.showCard();
                }
            }
        }
        else if(direction.equals("Right"))
        {
            if(this.getAttackRight() > opponentCard.getAttackLeft())
            {
                if(user.isPlayer())
                {
                    opponentCard.setCardClaimed(true);
                    opponentCard.showCard();
                }
                else
                {
                    opponentCard.setCardClaimed(false);
                    opponentCard.showCard();
                }
            }
        }
        else if(direction.equals("Down"))
        {
            if(this.getAttackDown() > opponentCard.getAttackUp())
            {
                if(user.isPlayer())
                {
                    opponentCard.setCardClaimed(true);
                    opponentCard.showCard();
                }
                else
                {
                    opponentCard.setCardClaimed(false);
                    opponentCard.showCard();
                }
            }
        }
        else if(direction.equals("Left"))
        {
            if(this.getAttackLeft() > opponentCard.getAttackRight())
            {
                if(user.isPlayer())
                {
                    opponentCard.setCardClaimed(true);
                    opponentCard.showCard();
                }
                else
                {
                    opponentCard.setCardClaimed(false);
                    opponentCard.showCard();
                }
            }
        }
    }
}