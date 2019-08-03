package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class Export extends JFrame{
    static Stage window;
    private static File place = new File("characters/");
    private static boolean exported;
    private JFileChooser dir=new JFileChooser(place);
    public Export(){
        dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dir.setAcceptAllFileFilterUsed(false);
        dir.setDialogTitle("Choose save place");
        dir.setSelectedFile(place);
        int a=dir.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
            exported =true;
            place=dir.getSelectedFile();
        } else {
            System.out.println("Open command cancelled by user .\n" );
            AlertBox.displey("STOP","Expotring was stopped");
            exported =false;
        }
    }

    public static void displey(PlayerData[] data, int a){
        window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Exported");
        window. setMinWidth(250);

        Label label = new Label();
        label.setText("Player "+(a+1)+" was exported");
        new Export();
                        if(exported){
                            try {

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
                            } catch (IOException e) {
                                AlertBox.displey("ERROE","something doesn't work\n(\"Save\")");
                            }
                        }else {
                            AlertBox.displey("ERROE","something doesn't work\n(\"Save\")");
                            label.setText("Player "+(a+1)+" wasn't exported");
                        }
        Button close = new Button("Ok");
        close.setOnAction(event -> window.close());
        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,new Separator(),close);
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
