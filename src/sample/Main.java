package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Main extends Application {
    private static String[] ar;
    private Stage window;
    private Scene scene1;

    public static void main(String[] args) {
        ar=args;
        launch(args);
    }

    private static int players;
    private static PlayerData[] data;
    static Label playersInfo;

    //for run
    static CheckMenuItem characterListItem;
    public static boolean setCharacterListItemCheck(){
        if(characterListItem.isSelected()){
            characterListItem.setSelected(false);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("10min background");

        window.setOnCloseRequest(event -> {
            event.consume();
            closeProgram();
        });


        //File menu Items
        MenuItem saveItem=new MenuItem("_Save...");
        saveItem.setOnAction(event -> {
            Save.displey(data,players);
        });
        MenuItem loadItem=new MenuItem("_Load...");
        loadItem.setOnAction(event -> {
            Load.displey();
        });
        MenuItem savePreviewItem=new MenuItem("Export _Preview...");
        savePreviewItem.setOnAction(event -> {
            Preview.displey(PlayerChose.displey(players,data),data);
        });
        Menu exportPlayers=new Menu("_Export Player to TXT");


        MenuItem exitItem= new MenuItem("E_xit");
        exitItem.setOnAction(event -> closeProgram());
        //File menu
        Menu file=new Menu("_File");
        file.getItems().addAll(
                saveItem,
                loadItem,
                new SeparatorMenuItem(),
                exportPlayers,
                savePreviewItem,
                new SeparatorMenuItem(),
                exitItem
        );


        //View menu Items
        characterListItem = new CheckMenuItem("Character's List display");
        characterListItem.setOnAction(event -> {
            if(characterListItem.isSelected()){
                PlayersList.displey(players,data);
            }else {
                PlayersList.closewindow();
            }
        });
        //View menu
        Menu View= new Menu("_View");
        View.getItems().addAll(characterListItem);

        //Help menu Items
        MenuItem helpItem=new MenuItem("Help");
        helpItem.setOnAction(event -> Hepl.displey());
        //Help menu
        Menu help=new Menu("_Help");
        help.getItems().addAll(helpItem);



        //Menu menu bar
        MenuBar menuBar=new MenuBar();
        menuBar.setVisible(false);
            menuBar.getMenus().addAll(file,View,help);


        playersInfo = new Label("number of players: ");
        TextField inputplayers= new TextField("key in number of players");
        Region region = new Region();
        region.setPrefSize(16,16);



        HBox playerBox = new HBox(0);
        playerBox.getChildren().addAll(region,playersInfo ,inputplayers);

        Label q1text = new Label("idea for step 1: ");
        TextArea inputq1= new TextArea("");
        inputq1.setPrefSize(300,120);
        inputq1.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER){
                System.out.println("q1 answer: "+inputq1.getText());
                String  s=inputq1.getText();
                int k=PlayerChose.displey(players,data);
                data[k].adds1(s);
                inputq1.setText("");
            }
        });
        HBox q1 = new HBox();
        q1.getChildren().addAll(q1text,inputq1);

        Label q2text = new Label("idea for step 2: ");
        TextArea inputq2= new TextArea();
        inputq2.setPrefSize(300,120);
        inputq2.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER){
                System.out.println("q2 answer: "+inputq2.getText());
                data[PlayerChose.displey(players,data)].adds2(inputq2.getText());
                inputq2.setText("");
            }
        });
        HBox q2 = new HBox();
        q2.getChildren().addAll(q2text,inputq2);

        Label q3text = new Label("idea for step 3: ");
        TextArea inputq3= new TextArea();
        inputq3.setPrefSize(300,120);
        inputq3.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER){
                System.out.println("q3 answer: "+inputq3.getText());
                data[PlayerChose.displey(players,data)].adds3(inputq3.getText());
                inputq3.setText("");
            }
        });
        HBox q3 = new HBox();
        q3.getChildren().addAll(q3text,inputq3);

        Label q4text = new Label("idea for step 4: ");
        TextArea inputq4= new TextArea();
        inputq4.setPrefSize(300,120);
        inputq4.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER){
                System.out.println("q4 answer: "+inputq4.getText());
                data[PlayerChose.displey(players,data)].adds4(inputq4.getText());
                inputq4.setText("");
            }
        });
        HBox q4 = new HBox();
        q4.getChildren().addAll(q4text,inputq4);

        Label q5text = new Label("idea for step 5: ");
        TextArea inputq5= new TextArea();
        inputq5.setPrefSize(300,120);
        inputq5.setOnKeyPressed(event -> {
            if(event.getCode()==KeyCode.ENTER){
                System.out.println("q5 answer: "+inputq5.getText());
                data[PlayerChose.displey(players,data)].adds5(inputq5.getText());
                inputq5.setText("");
            }
        });
        HBox q5 = new HBox();
        q5.getChildren().addAll(q5text,inputq5);

        VBox base = new VBox(16);
        base.getChildren().addAll(q1,q2,q3,q4,q5);
        base.setPadding(new Insets(8,32,32,32));
        base.setVisible(false);

        inputplayers.setOnKeyPressed(event ->{
            if(event.getCode()==KeyCode.ENTER)
                if(isInt(inputplayers.getText())){
                    inputplayers.setVisible(false);
                    base.setVisible(true);
                    players=Integer.parseInt(inputplayers.getText());
                    players--;
                    playersInfo.setText(playersInfo.getText()+(players+1));
                    data=new PlayerData[players+1];
                    for(int i=0;i<=players;i++)data[i]=new PlayerData(ChoseName.displey(i));
                    menuBar.setVisible(true);
                    MenuItem mew;
                    for (int i = 0; i <= players; i++) {
                     //   exPlayers[i]=new MenuItem("Player "+(i+1)+"...");
                        mew=new MenuItem("Player _"+(i+1)+"...");
                        mew.setId(""+i);
                        mew.setOnAction(event1 -> {
                            exportPlayerAction(event1);

                        });
                        exportPlayers.getItems().add(mew);

                    }
                }
                else AlertBox.displey("Player number","Players number must be integer number");
        });
        VBox layout = new VBox(8);
        layout.getChildren().addAll(menuBar,playerBox,base);

        scene1 = new Scene(layout, 480, 400);
        window.setScene(scene1);
        window.show();
    }

    public static void load(PlayerData[] data1, int players1){
        data=data1;
        players=players1;
        playersInfo.setText("number of players: "+players1);
    }


    private void exportPlayerAction(Event event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        Export.displey(data,Integer.parseInt(menuItem.getId()));
    }


    private boolean isInt(String text) {
        try{
            int i= Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private void closeProgram(){
        if(Confirmbox.displey("close","Sure you want to exit?")){

            System.out.println("Sefe Exit");
        window.close();
        System.exit(0);}
    }


}
