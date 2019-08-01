package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Hepl {

    public static void displey(){
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Help");
        window. setMinWidth(250);

        Label label = new Label();
        label.setText("press enter to confirm\n\nStep 1: Write 5 background and concept elements that you feel are important to your image of the character.\nThese can be a concept overview, a list of important life events, a physical description, a personality profile...\nwhatever you need to get an image in your mind.\n 5 is just a minimum...more elements are encouraged!\nStep 2: List at least two goals for the character.\nAt least one of these goals should be one that the character has, while another should be one that you,\nas a player, want to see developed over the course of the game.\nStep 3: List at least two secrets about your character.\nOne is a secret the character knows, one is a secret that involves him but that he is not actually aware of yet.\nThis will help me in creating plots that center around your character.\nI will also be creating a third secret which you as a player will not be aware of, so expect some surprises!\nStep 4: Describe at least three people that are tied to the character.\nTwo of them are friendly to the character, one is hostile.\nIf you like, you can include an enemy of yours here as well, so I have an instant NPC nemesis to throw at you.\nStep 5: Describe three memories, mannerisms, or quirks that your character has.\nThey don't have to be elaborate, but they should provide some context and flavor.\n");
        Hyperlink linkToGitHub=new Hyperlink("https://github.com/jarek7410/10minBacgraund/");

        Button closeButton = new Button("close the window");
        closeButton.setOnAction(event -> window.close());

        VBox layout = new VBox(20);
        layout.getChildren().addAll(label,closeButton,linkToGitHub);
        layout.setAlignment(Pos.CENTER);

        Scene scene= new Scene(layout,640,400);
        window.setScene(scene);
        window.showAndWait();
    }
}
