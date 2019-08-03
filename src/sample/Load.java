package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.dataOperation.SaveLoad;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Load extends JFrame {
    private static File place = new File("saves/save.1mbg");
    private static boolean saving;

    private final static int SAVING_WORKS_VERSION = 0;

    private JFileChooser dir=new JFileChooser(place);
    public Load(){
        dir.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileFilter fileFilter=new FileNameExtensionFilter("10minBackground save file","1mbg","jpg");
        dir.setFileFilter(fileFilter);
        dir.setDialogTitle("Choose load file");
        dir.setSelectedFile(place);
        int a=dir.showOpenDialog(this);
        if(a==JFileChooser.APPROVE_OPTION){
            saving =true;
            place=dir.getSelectedFile();
        } else {
            System.out.println("Open command cancelled by user .\n" );
            AlertBox.displey("STOP","Expotring was stopped");
            saving =false;
        }
    }

    public static void displey(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("save");
        window. setMinWidth(250);
        Button closeButton = new Button("loa");
        closeButton.setOnAction(event -> {
            PlayerData[] data = new PlayerData[0];
            int players = 0;
            new Load();
            if(saving){
                try{
                    SaveLoad save = new SaveLoad(place.getName());
                    save.openLoadStream();
                    switch (save.readInt()){
                        case 0:
                            players =(int) save.readShort();
                            data=new PlayerData[players+1];
                            for (int i = 0,c; i <= players; i++) {
                                data[i]=new PlayerData(save.readString());
                                c=save.readInt();
                                for (int j = 0; j < c; j++) {
                                    data[i].adds1(save.readString());
                                }
                                c=save.readInt();
                                for (int j = 0; j < c; j++) {
                                    data[i].adds2(save.readString());
                                }
                                c=save.readInt();
                                for (int j = 0; j < c; j++) {
                                    data[i].adds3(save.readString());
                                }
                                c=save.readInt();
                                for (int j = 0; j < c; j++) {
                                    data[i].adds4(save.readString());
                                }
                                c=save.readInt();
                                for (int j = 0; j < c; j++) {
                                    data[i].adds5(save.readString());
                                }
                            }
                            saving=true;
                            break;
                        default:
                            AlertBox.displey("ERROR", "not accept save version\naccept only v: 0");
                            saving=false;
                    }
                    save.closeLoadStream();
                    if (saving) {
                        Main.load(data,players);
                        System.out.println("load");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            window.close();
        });

        VBox layout = new VBox(20);
        layout.getChildren().addAll(closeButton);
        layout.setAlignment(Pos.CENTER);


        Scene scene= new Scene(layout,250,150);
        window.setScene(scene);
        window.showAndWait();
    }
}