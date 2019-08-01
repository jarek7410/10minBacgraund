package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayersList {
    static Stage window;

    public static void displey(int players,PlayerData[] data){

        window = new Stage();

        window.setTitle("Plaeyers list");
        window.setOnCloseRequest(event -> {
            event.consume();
            closewindow();
        });

        VBox layout = new VBox(0);
        for(int i=0;i<=players;i++){
            layout.getChildren().add(new Label((i+1)+". "+data[i].name));
        }

        layout.setAlignment(Pos.CENTER);


        Scene scene= new Scene(layout,170,(17*(players+1))+16);
        window.setScene(scene);
        window.show();
    }

    protected static void closewindow() {
        Main.setCharacterListItemCheck();
        window.close();
    }
}
