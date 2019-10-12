package quadrilaterae;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application
{
    private static final java.util.Random RANDOM = new java.util.Random();
    private static final CardUser player = new CardUser(true);
    private static final CardUser npc = new CardUser(false);
    private Card selectedCard;
    private Card previousCard;
    private Card insertCard;
    
    @Override
    public void start(Stage stage)
    {
        Config.initialize();
        BorderPane gameScreen = new BorderPane();
        HeldCards oppCards = new HeldCards();
        Board board = new Board();
        HeldCards playerCards = new HeldCards();
        
        gameScreen.setBackground(new Background(new BackgroundImage(
                                                Config.getImages().get(10),
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT)));
        
        oppCards.setBackground(new Background(new BackgroundImage(
                                                Config.getImages().get(13),
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT)));
        
        playerCards.setBackground(new Background(new BackgroundImage(
                                                Config.getImages().get(13),
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT)));
        
        /*board.setBackground(new Background(new BackgroundImage(
                                                Config.getImages().get(1),
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundPosition.CENTER,
                                                BackgroundSize.DEFAULT)));*/

        gameScreen.setPrefSize(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        oppCards.add(new Card(1, 2, 1, 2, "Slime", false, false, npc, 0));
        oppCards.add(new Card(2, 1, 2, 1, "Wolf", false, false, npc, 2));
        oppCards.add(new Card(2, 2, 1, 1, "Goblin", false, false, npc, 4));
        oppCards.add(new Card(1, 2, 2, 1, "Bandit", false, false, npc, 6));
        oppCards.add(new Card(1, 1, 2, 2, "Knight", false, false, npc, 8));
        
        playerCards.add(new Card(1, 2, 1, 2, "Slime", true, true, player, 0));
        playerCards.add(new Card(2, 1, 2, 1, "Wolf", true, true, player, 2));
        playerCards.add(new Card(2, 2, 1, 1, "Goblin", true, true, player, 4));
        playerCards.add(new Card(1, 2, 2, 1, "Bandit", true, true, player, 6));
        playerCards.add(new Card(1, 1, 2, 2, "Knight", true, true, player, 8));
        
        gameScreen.setOnMouseClicked((MouseEvent mouseEvent) ->
        {
            if(mouseEvent.getButton() == MouseButton.PRIMARY)
            {
                if(mouseEvent.getTarget().getClass().getName().equals("quadrilaterae.Card"))
                {
                    Card aCard = (Card) mouseEvent.getTarget();
                    if(aCard.getOwner() == player)
                    {
                        try
                        {
                            if(previousCard == null)
                            {
                                previousCard = selectedCard;
                            }
                            selectedCard = (Card) mouseEvent.getTarget();
                            if(selectedCard != previousCard)
                            {
                                selectedCard.setTranslateX(selectedCard.getTranslateX() - 155);
                                previousCard.setTranslateX(35);
                                previousCard = selectedCard;
                            }
                        }
                        catch(NullPointerException e)
                        {
                        }
                    }
                }
                else if(mouseEvent.getTarget().getClass().getName().equals("javafx.scene.layout.Pane"))
                {
                    Pane aPane = (Pane) mouseEvent.getTarget();
                    if(selectedCard != null)
                    {
                        insertCard = selectedCard;
                        board.addCard(insertCard, playerCards, Board.getColumnIndex(aPane), Board.getRowIndex(aPane));
                        //player.claimCardPlayer(insertCard, board);
                        insertCard = null;
                        selectedCard = null;
                        npc.takeTurn(oppCards, board);
                    }
                }
                else
                {
                    insertCard = null;
                    selectedCard = null;
                    playerCards.updatePositions();
                }
            }
            else if(mouseEvent.getButton() == MouseButton.SECONDARY)
            {
                playerCards.updatePositions();
                if(selectedCard != null)
                {
                    selectedCard = null;
                }
                if(previousCard != null)
                {
                    previousCard = null;
                }
                System.out.println(mouseEvent.getSource().getClass().getName());
                System.out.println(mouseEvent.getTarget().getClass().getName());
            }
        });
        
        gameScreen.setLeft(oppCards);
        gameScreen.setCenter(board);
        gameScreen.setRight(playerCards);
        
        Scene scene = new Scene(gameScreen, 1600, 900);
        stage.setTitle("Quadrilaterae");
        stage.setResizable(false);
        //stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }
    // Returns random integer number from 0 to max - 1
    public static int random(int max) {
        return (int) (RANDOM.nextDouble() * max);
    }    
    
    public static void main(String[] args)
    {
        launch(args);
    }
}
