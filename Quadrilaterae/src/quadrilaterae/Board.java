/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilaterae;

import java.util.HashMap;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

/**
 *
 * @author JCarter
 */
public final class Board extends GridPane
{
    public Board()
    {
        this.getColumnConstraints().add(new ColumnConstraints(150));
        this.getColumnConstraints().add(new ColumnConstraints(150));
        this.getColumnConstraints().add(new ColumnConstraints(150));
        this.getRowConstraints().add(new RowConstraints(250));
        this.getRowConstraints().add(new RowConstraints(250));
        this.getRowConstraints().add(new RowConstraints(250));
        
        this.setAlignment(Pos.CENTER);
        this.setHgap(2);
        this.setVgap(2);
        this.setGridLinesVisible(true);
        
        this.add(new Pane(), 0, 0);
        this.add(new Pane(), 1, 0);
        this.add(new Pane(), 2, 0);
        this.add(new Pane(), 0, 1);
        this.add(new Pane(), 1, 1);
        this.add(new Pane(), 2, 1);
        this.add(new Pane(), 0, 2);
        this.add(new Pane(), 1, 2);
        this.add(new Pane(), 2, 2);
    }
    
    @Override
    public void add(Node child, int columnIndex, int rowIndex) {
        setConstraints(child, columnIndex, rowIndex);
        if(columnIndex == 0 && rowIndex == 0)
        {
            this.getChildren().add(0, child);
        }
        else if(columnIndex == 1 && rowIndex == 0)
        {
            this.getChildren().add(1, child);
        }
        else if(columnIndex == 2 && rowIndex == 0)
        {
            this.getChildren().add(2, child);
        }
        else if(columnIndex == 0 && rowIndex == 1)
        {
            this.getChildren().add(3, child);
        }
        else if(columnIndex == 1 && rowIndex == 1)
        {
            this.getChildren().add(4, child);
        }
        else if(columnIndex == 2 && rowIndex == 1)
        {
            this.getChildren().add(5, child);
        }
        else if(columnIndex == 0 && rowIndex == 2)
        {
            this.getChildren().add(6, child);
        }
        else if(columnIndex == 1 && rowIndex == 2)
        {
            this.getChildren().add(7, child);
        }
        else if(columnIndex == 2 && rowIndex == 2)
        {
            this.getChildren().add(8, child);
        }
    }
    
    public void addCard(Card aCard, HeldCards myCards, int x, int y)
    {
        aCard.update();
        aCard.setCoords(x,y);
        this.add(aCard,x,y);
        myCards.updatePositions();
    }
    
    public Node getSlot(int columnIndex, int rowIndex)
    {
        if(columnIndex == 0 && rowIndex == 0)
        {
            return this.getChildren().get(0);
        }
        else if(columnIndex == 1 && rowIndex == 0)
        {
            return this.getChildren().get(1);
        }
        else if(columnIndex == 2 && rowIndex == 0)
        {
            return this.getChildren().get(2);
        }
        else if(columnIndex == 0 && rowIndex == 1)
        {
            return this.getChildren().get(3);
        }
        else if(columnIndex == 1 && rowIndex == 1)
        {
            return this.getChildren().get(4);
        }
        else if(columnIndex == 2 && rowIndex == 1)
        {
            return this.getChildren().get(5);
        }
        else if(columnIndex == 0 && rowIndex == 2)
        {
            return this.getChildren().get(6);
        }
        else if(columnIndex == 1 && rowIndex == 2)
        {
            return this.getChildren().get(7);
        }
        else if(columnIndex == 2 && rowIndex == 2)
        {
            return this.getChildren().get(8);
        }
        return null;
    }
    
    public boolean checkValid(int x, int y)
    {
        return x >= 0 && x <= 2 && y >= 0 && y <= 2;
    }
    
    public HashMap checkBounds(Card aCard)
    {
        HashMap bounds = new HashMap(4);
        
        if(checkValid(aCard.getX(),aCard.getY()-1) && !getSlot(aCard.getX(),aCard.getY()-1).getClass().getName().equals("quadrilaterae.Card")) //Up
        {
            bounds.put(0, true);
        }
        else
        {
            bounds.put(0, false);
        }
        if(checkValid(aCard.getX()+1,aCard.getY()) && !getSlot(aCard.getX()+1,aCard.getY()).getClass().getName().equals("quadrilaterae.Card")) //Right
        {
            bounds.put(1, true);
        }
        else
        {
            bounds.put(1, false);
        }
        if(checkValid(aCard.getX(),aCard.getY()+1) && !getSlot(aCard.getX(),aCard.getY()+1).getClass().getName().equals("quadrilaterae.Card")) //Down
        {
            bounds.put(2, true);
        }
        else
        {
            bounds.put(2, false);
        }
        if(checkValid(aCard.getX()-1,aCard.getY()) && !getSlot(aCard.getX()-1,aCard.getY()).getClass().getName().equals("quadrilaterae.Card")) //Left
        {
            bounds.put(3, true);
        }
        else
        {
            bounds.put(3, false);
        }
        
        return bounds;
    }
}
