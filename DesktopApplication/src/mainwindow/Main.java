package mainwindow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("JavaFX Welcome");
        
        //GridPane with Gap and Padding Properties
        GridPane grid = new GridPane();
        
        //changes the default position of the grid from the top left of the scene to the center.
        grid.setAlignment(Pos.CENTER);
        
        //The gap properties manage the spacing between the rows and columns
        grid.setHgap(10);
        grid.setVgap(10);
        
        //manages the space around the edges of the grid pane
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome");
        //scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20)); REMOVED AND DONE IN CSS
        
        //Create an ID for text node (for CSS)
        scenetitle.setId("welcome-text");
        
        //adds the scenetitle variable to the layout grid. The numbering for columns and rows
        //in the grid starts at zero, and scenetitle is added in column 0, row 0. The last two
        //arguments of the grid.add() method set the column span to 2 and the row span to 1.
        grid.add(scenetitle, 0, 0, 2, 1);

        //create a Label object with text User Name at column 0, row 1
        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        //text field is added to the grid pane at column 1, row 1
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //create a Label object with text Password at column 0, row 2
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        //Creating a password field at column 1, row 2
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Sign in");
        
        //creates an HBox layout pane named hbBtn with spacing of 10 pixels
        HBox hbBtn = new HBox(10);
        
        //positions a node at the bottom of the space vertically and at the right edge of the space horizontally
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        
        //The button is added as a child of the HBox pane
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        
        //a Text control for displaying the "sign in" press message
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        //setOnAction() method is used to register an event handler that sets the actiontarget object to Sign in
        //button pressed when the user presses the button
        btn.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                //actiontarget.setFill(Color.FIREBRICK); REMOVED AND DONE IN CSS
            	
            	//Create an ID for text node (for CSS)
            	actiontarget.setId("actiontarget");
            	
                actiontarget.setText("Sign in button pressed");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        
        //initialize the style sheets variable of the Scene class to point to the CSS
        scene.getStylesheets().add
        (Main.class.getResource("Login.css").toExternalForm());
        
        primaryStage.show();
    }
}