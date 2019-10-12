/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quadrilaterae;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 *
 * @author JCarter
 */
public class HeldCards extends StackPane
{
    public HeldCards()
    {
        this.setPrefSize(220,750);
    }
    
    public void add(Node e)
    {
        if (this.getChildren().size() < 5)
        {
            this.getChildren().add(e);
            this.updatePositions();
        }
    }
    
    public void remove(Node e)
    {
        if(this.getChildren().size() > 0)
        {
            this.getChildren().remove(e);
            this.updatePositions();
        }
    }
    
    public Node getPositition(int i)
    {
        return this.getChildren().get(i);
    }
    
    public void updatePositions()
    {
        switch (this.getChildren().size())
        {
            case 1:
                this.getChildren().get(0).setTranslateX(35);
                this.getChildren().get(0).setTranslateY(35);
                break;
            case 2:
                this.getChildren().get(0).setTranslateX(35);
                this.getChildren().get(0).setTranslateY(35);
                this.getChildren().get(1).setTranslateX(35);
                this.getChildren().get(1).setTranslateY(160);
                break;
            case 3:
                this.getChildren().get(0).setTranslateX(35);
                this.getChildren().get(0).setTranslateY(35);
                this.getChildren().get(1).setTranslateX(35);
                this.getChildren().get(1).setTranslateY(160);
                this.getChildren().get(2).setTranslateX(35);
                this.getChildren().get(2).setTranslateY(285);
                break;
            case 4:
                this.getChildren().get(0).setTranslateX(35);
                this.getChildren().get(0).setTranslateY(35);
                this.getChildren().get(1).setTranslateX(35);
                this.getChildren().get(1).setTranslateY(160);
                this.getChildren().get(2).setTranslateX(35);
                this.getChildren().get(2).setTranslateY(285);
                this.getChildren().get(3).setTranslateX(35);
                this.getChildren().get(3).setTranslateY(410);
                break;
            case 5:
                this.getChildren().get(0).setTranslateX(35);
                this.getChildren().get(0).setTranslateY(35);
                this.getChildren().get(1).setTranslateX(35);
                this.getChildren().get(1).setTranslateY(160);
                this.getChildren().get(2).setTranslateX(35);
                this.getChildren().get(2).setTranslateY(285);
                this.getChildren().get(3).setTranslateX(35);
                this.getChildren().get(3).setTranslateY(410);
                this.getChildren().get(4).setTranslateX(35);
                this.getChildren().get(4).setTranslateY(535);
                break;
            default:
                break;
        }
    }
}
