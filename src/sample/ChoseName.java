package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ChoseName {

    static String name;
    public static String displey(int i){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("player "+(i+1));
        window. setMinWidth(250);

        Label label = new Label();
        label.setText("chose name:");
        TextField m=new TextField((i+1)+"");
        m.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                name=m.getText();
                window.close();
            }
        });
        Button closeButton = new Button("it is that");
        closeButton.setOnAction(event -> {
                name=m.getText();
                window.close();
            });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,m,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout,250,150);
        window.setScene(scene);
        window.showAndWait();
        return name;
    }
}
