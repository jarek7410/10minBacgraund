package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Export extends JFrame{

    private static File place = new File("characters/");
    private JFileChooser dir=new JFileChooser(place);
    public Export(){
        dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dir.setAcceptAllFileFilterUsed(false);
        dir.setDialogTitle("Choose save place");
        int a=dir.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
            place=dir.getSelectedFile();
        } else {
            System.out.println("Open command cancelled by user .\n" );
        }
    }

    public static void displey(PlayerData[] data, int players){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("saveing");
        window. setMinWidth(250);

        Label label = new Label();
        label.setText("witch charakter you wont to save?\n(key in int number)\n(from 1 to "+(players+1)+")");
        TextField name=new TextField();
        name.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER)
                if(isInt(name.getText())){
                    int a=Integer.parseInt(name.getText())-1;
                    if(a<=players){
                        try {
                            new Export();
                            if(!place.exists()) place.mkdir();

                            PrintWriter zapis = new PrintWriter(place+"/"+data[a].name+".txt");
                            zapis.println("name: "+data[a].name);
                            zapis.println("1.step");
                            zapis.print(data[a].gets1());
                            zapis.println("2.step");
                            zapis.print(data[a].gets2());
                            zapis.println("3.step");
                            zapis.print(data[a].gets3());
                            zapis.println("4.step");
                            zapis.print(data[a].gets4());
                            zapis.println("5.step");
                            zapis.print(data[a].gets5());
                            zapis.println("");
                            zapis.close();
                            AlertBox.displey("saved","the "+data[a].name+"'s data was saved.");
                            window.close();
                        } catch (IOException e) {
                            AlertBox.displey("ERROE","something doesn't work\n(\"Save\")");
                        }
                    }else{
                        AlertBox.displey("to big","you hew less players then "+(a)+".\nkey in smaller number");
                        name.setText("");
                    }

                }else AlertBox.displey("Player number", "Players number must be intiger number");


        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,name);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout,250,150);
        window.setScene(scene);
        window.showAndWait();
    }
    private static boolean isInt(String text) {
        try{
            int i= Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
}
