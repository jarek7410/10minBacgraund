package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerChose {

    static int anser;

    public static int displey(int playernumber,PlayerData[] data){

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("who");
        window.setOnCloseRequest(event -> {
            closeProgram();
        });

        Label label = new Label();
        label.setText("to who you put it?");

        TextField an=new TextField("type number");
        an.setOnKeyPressed(event -> {
                    if (event.getCode() == KeyCode.ENTER)
                        if (isInt(an.getText())) {
                        anser=Integer.parseInt(an.getText());
                        anser--;
                        if(anser<=playernumber){closeProgram();
                        if(Confirmbox.displey(data[anser].name,"it go to "+data[anser].name+"?"))
                            window.close();}
                        else {
                            AlertBox.displey("to big","you hew less players then "+(anser+1)+".\nkey in smaller number");
                            an.setText("");
                        }

                        } else AlertBox.displey("Player number", "Players number must be intiger number");
                });

        HBox layout = new HBox(20);
        layout.getChildren().addAll(label,an);
        layout.setAlignment(Pos.CENTER);
        Scene scene= new Scene(layout,400,100);
        window.setScene(scene);
        window.showAndWait();
        return anser;
    }
    private static boolean isInt(String text) {
        try{
            int i= Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    private static void closeProgram(){
        System.out.println("player number: "+anser);
    }


}
