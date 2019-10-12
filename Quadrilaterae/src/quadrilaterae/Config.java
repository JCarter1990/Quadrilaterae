package quadrilaterae;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public final class Config {
    
    public static final String IMAGE_DIR = "assets/";
    public static final int SCREEN_WIDTH = 1920;
    public static final int SCREEN_HEIGHT = 1080;

    private static final String[] IMAGES_NAMES = new String[] {
        "1o.png",
        "1p.png",
        "2o.png",
        "2p.png",
        "3o.png",
        "3p.png",
        "4o.png",
        "4p.png",
        "5o.png",
        "5p.png",
        "background.png",
        "board.png",
        "cardBack.png",
        "cardMenu.png",
        "press.png",
        "title.png"
    };

    private static final ObservableList<Image> images = javafx.collections.FXCollections.<Image>observableArrayList();

    public static ObservableList<Image> getImages() {
        return images;
    }

    public static void initialize() {
        for (String imageName : IMAGES_NAMES) {
            Image image = new Image(Config.class.getResourceAsStream(IMAGE_DIR+imageName));
            if (image.isError()) {
                System.out.println("Image "+imageName+" not found");
            }
            images.add(image);
        }
    }

    private Config() {
    }
}

