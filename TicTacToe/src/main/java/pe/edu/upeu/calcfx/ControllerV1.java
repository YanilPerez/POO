package pe.edu.upeu.calcfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class ControllerV1 {

Stage ventStage = new Stage();

public void callventStage(MouseEvent mouseEvent){

    try {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Inicio.fxml"));
        ventStage.setTitle("ventana2");
        ventStage.setScene(new Scene(root,800, 600));
        ventStage.show();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

}
}
