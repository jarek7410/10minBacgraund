package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void displey(String title, String messsage){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window. setMinWidth(250);

        Label label = new Label();
        label.setText(messsage);
        Button closeButton = new Button("close the window");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout,250,150);
        window.setScene(scene);
        window.showAndWait();
    }
}
