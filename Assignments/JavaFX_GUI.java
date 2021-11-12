/*
* Jasurbek Mamurov
* U2010164
* Lab Assignment # 8
* JavaFX
* */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;

import java.io.IOException;

public class JavaFX_GUI extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Main actions with the stage
        primaryStage.setTitle("Log In/Out");
        primaryStage.setHeight(250);
        primaryStage.setWidth(350);

        //Creating a grid for all components
        GridPane comp_box = new GridPane();
        //change gaps
        comp_box.setHgap(5);
        comp_box.setVgap(5);
        //add padding
        comp_box.setPadding(new Insets(10,10,0,10));

        //Creating labels
        Label user_name_lbl = new Label("User Name");
        Label password_lbl = new Label("Password");

        //Change styling of the label
        user_name_lbl.setFont(new Font("Arial", 18));
        password_lbl.setFont(new Font("Arial", 18));

        //Setting a text field
        TextField user_name = new TextField();
        //Setting a password field
        PasswordField password = new PasswordField();

        //Setting Components
        Button sub_btn = new Button("Submit");
        Button clr_btn = new Button("Clear");

        //button styling
        sub_btn.setStyle("-fx-background-color: #5900b3; -fx-color: #000000;");
        clr_btn.setStyle("-fx-background-color: #5900b3; -fx-color: #000000;");

        //Add all components to the grid
        comp_box.add(user_name_lbl, 0, 0);
        comp_box.add(user_name, 1, 0);
        comp_box.add(password_lbl, 0, 1);
        comp_box.add(password, 1, 1);
        comp_box.add(sub_btn, 0, 2);
        comp_box.add(clr_btn, 1, 2);

        //Events on buttons//

        //submit is pressed => get text details
        sub_btn.setOnAction(e -> {
            System.out.println(user_name.getText() + " " + " " + password.getText());
        });

        //clear is pressed => clear the text fields
        clr_btn.setOnAction(e ->
        {
            user_name.clear();
            password.clear();
        }
        );

	//Positioning the grid at the center
        comp_box.setAlignment(Pos.CENTER);

        //Creating a scene
        Scene main_scene = new Scene(comp_box,40, 50);

        //Setting the scene to the stage
        primaryStage.setScene(main_scene);

        //Display the stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}