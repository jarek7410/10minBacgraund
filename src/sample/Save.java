package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class Save extends JFrame{
    private static File place = new File("saves/");
    private static boolean saving;

    private final static int SAVING_WORKS_VERSION = 0;

    private JFileChooser dir=new JFileChooser(place);
    public Save(){
        dir.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        dir.setAcceptAllFileFilterUsed(false);
        dir.setDialogTitle("Choose save place");
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

    public static void displey(PlayerData[] data,int players){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("save");
        window. setMinWidth(250);
        Button closeButton = new Button("save");
        closeButton.setOnAction(event -> {
            new Save();
            if(saving){
                try{
                    if(!place.exists()) place.mkdir();
                    SaveLoad save = new SaveLoad(place.getName()+"/save.1mbg");
                    save.openSaveStream();
                    save.writeInt(SAVING_WORKS_VERSION);
                    save.writeShort((short) players);
                    for(PlayerData playerData:data){
                        save.writeString(playerData.name);
                        save.writeInt(playerData.gets1Size());
                        for(String s:playerData.gets1Strings())
                            save.writeString(s);
                        save.writeInt(playerData.gets2Size());
                        for(String s:playerData.gets2Strings())
                            save.writeString(s);
                        save.writeInt(playerData.gets3Size());
                        for(String s:playerData.gets3Strings())
                            save.writeString(s);
                        save.writeInt(playerData.gets4Size());
                        for(String s:playerData.gets4Strings())
                            save.writeString(s);
                        save.writeInt(playerData.gets5Size());
                        for(String s:playerData.gets5Strings())
                            save.writeString(s);
                    }
                    save.closeSavestream();
                    System.out.println("saved");
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
