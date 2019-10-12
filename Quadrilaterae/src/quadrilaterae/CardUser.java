/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilaterae;

import javafx.scene.Node;

/**
 *
 * @author JCarter
 */
public class CardUser
{
    private boolean player;
    
    public CardUser(boolean player)
    {
        this.player = player;
    }
    
    public boolean isPlayer()
    {
        return this.player;
    }
    
    public void claimCardPlayer(Card myCard, Board gameBoard)
    {
        Node nodeA = gameBoard.getSlot(myCard.getX(), myCard.getY() - 1);
        Node nodeB = gameBoard.getSlot(myCard.getX() + 1, myCard.getY());
        Node nodeC = gameBoard.getSlot(myCard.getX(), myCard.getY() + 1);
        Node nodeD = gameBoard.getSlot(myCard.getX() - 1, myCard.getY());
        
        if(nodeA != null)
        {
            if(nodeA.getClass().getName().equals("quadrilaterae.Card"))
            {
                Card cardUp = (Card) nodeA;
                if(cardUp.getClaimed() == false)
                {
                    myCard.battle(cardUp, this, "Up");
                }
            }
        }
        if(nodeB != null)
        {
            if(nodeB.getClass().getName().equals("quadrilaterae.Card"))
            {
                Card cardRight = (Card) nodeB;
                if(cardRight.getClaimed() == false)
                {
                    myCard.battle(cardRight, this, "Right");
                }
            }
        }
        if(nodeC != null)
        {
            if(nodeC.getClass().getName().equals("quadrilaterae.Card"))
            {
                Card cardDown = (Card) nodeC;
                if(cardDown.getClaimed() == false)
                {
                    myCard.battle(cardDown, this, "Down");
                }
            }
        }
        if(nodeD != null)
        {
            if(nodeD.getClass().getName().equals("quadrilaterae.Card"))
            {
                Card cardLeft = (Card) nodeD;
                if(cardLeft.getClaimed() == false)
                {
                    myCard.battle(cardLeft, this, "Left");
                }
            }
        }
    }
    
    public void takeTurn(HeldCards myCards, Board gameBoard)
    {
        for(Node aNode : gameBoard.getChildren())
        {
            if(aNode.getClass().getName().equals("quadrilaterae.Card"))
            {
                Card opponentCard = (Card) aNode;
                for(Node bNode : myCards.getChildren())
                {
                    Card myCard = (Card) bNode;
                    
                }
            }
        }
    }
}
