package packageInterface;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.FileNotFoundException;
import javafx.stage.FileChooser;

import java.io.FileInputStream;


public class UI extends Application {

    public static Pane backgroundPane = new Pane();


    public void start(Stage stage) throws Exception{

        Button uploadButton = new Button("Upload Image");
        uploadButton.setPrefSize(100,100);

        uploadButton.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
            FileChooser imgUploader = new FileChooser();
            imgUploader.setTitle("Upload Image");

        });

        backgroundPane.getChildren().add(uploadButton);

        Scene inputScene = new Scene(backgroundPane,400,500);

        stage.setScene(inputScene);
        stage.show();



    }

    public static void main(String[] args){

        launch(args);

    }

}
