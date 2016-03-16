package JavaFX;

import Builders.BoerneMenuWindow;
import Builders.PersonaleMenuWindow;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by FrederikPetersen on 15/03/2016.
 */
public class LoginBox{

    Stage window;
    Button enterButton;
    Button cancelButton;
    TextField passText;
    TextField userText;
    HBox loginBoxBottom;
    HBox loginBoxTop;
    VBox loginWhole;




    public Scene start(Stage primaryStage){
        window = primaryStage;

        loginBoxBottom = new HBox();
        loginBoxBottom.setPadding(new Insets(20,20,20,20));
        loginBoxBottom.setSpacing(20);
        loginBoxBottom.setAlignment(Pos.BOTTOM_RIGHT);

        loginBoxTop = new HBox();
        loginBoxTop.setPadding(new Insets(20,20,20,20));
        loginBoxTop.setSpacing(20);
        loginBoxTop.setAlignment(Pos.BOTTOM_CENTER);

        loginWhole = new VBox();

        enterButton = new Button();
        enterButton.setText("Enter");
        enterButton.setMinSize(60,20);
        enterButton.setOnAction(e -> {

            if (readFromFile(userText.getText(),passText.getText())){

                KategoryMenuWindow ktm = new KategoryMenuWindow();
                window.setScene(ktm.start(window));
            }else {
                userText.setPromptText("Forkert");
            }
        });

        cancelButton = new Button();
        cancelButton.setText("Cancel");
        cancelButton.setMinSize(60,20);
        cancelButton.setOnAction(e -> {
            System.out.println("System Closed");
            window.close();
        });

        passText = new TextField();
        passText.setPromptText("Password");

        userText = new TextField();
        userText.setPromptText("Unsername");

        loginBoxBottom.getChildren().addAll(cancelButton,enterButton);
        loginBoxTop.getChildren().addAll(userText,passText);

        loginWhole.getChildren().addAll(loginBoxTop,loginBoxBottom);

        Scene scene1 = new Scene(loginWhole,400,150);

        return scene1;
    }

    private Boolean readFromFile(String user, String pass){

        Boolean confirmUser = false;

        try{
            File file = new File("Password.txt");
            Scanner scanner = new Scanner(file);

            String realUser = scanner.nextLine();
            String realPass = scanner.nextLine();

            if (realUser.equals(user) && realPass.equals(pass)){
                confirmUser = true;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return confirmUser;
    }
}
