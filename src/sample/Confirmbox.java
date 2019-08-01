package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Confirmbox {

    static Boolean anser;

        public static boolean displey(String title, String messsage){
            Stage window = new Stage();
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle(title);
            window. setMinWidth(250);
            window.setOnCloseRequest(e->closeConfirmBox());

            Label label = new Label();
            label.setText(messsage);

            Button yesButton =  new Button("Yes");
            Button noButton  =  new Button("No");

            yesButton.setOnAction(e ->{
                anser=true;
                window.close();
            });
            noButton.setOnAction(e ->{
                anser=false;
                window.close();
            });
            HBox buttons = new HBox(20);
            buttons.getChildren().addAll(yesButton,noButton);
            buttons.setAlignment(Pos.CENTER);
            VBox layout = new VBox(20);
            layout.getChildren().addAll(label,buttons);
            layout.setAlignment(Pos.CENTER);
            Scene scene= new Scene(layout,250,150);
            window.setScene(scene);
            window.showAndWait();
            return anser;
        }

    private static boolean closeConfirmBox() {
            return false;
    }


}
