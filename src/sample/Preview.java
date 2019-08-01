package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Preview {

    public static void displey(int a,PlayerData[] data){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("preview");
        window. setMinWidth(250);

        Label label = new Label();
        String s="name: "+data[a].name+"\n";
        s+="1.step"+"\n";
        s+=data[a].gets1();
        s+="2.step"+"\n";
        s+=data[a].gets2();
        s+="3.step"+"\n";
        s+=data[a].gets3();
        s+="4.step"+"\n";
        s+=data[a].gets4();
        s+="5.step"+"\n";
        s+=data[a].gets5();
        label.setText(s);
        Button closeButton = new Button("close the window");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout,200,400);
        window.setScene(scene);
        window.showAndWait();
    }
}
