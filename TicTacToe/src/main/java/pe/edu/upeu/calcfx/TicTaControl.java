package pe.edu.upeu.calcfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pe.edu.upeu.calcfx.modelo.Jugador;
import pe.edu.upeu.calcfx.modelo.Tablero;
import pe.edu.upeu.calcfx.modelo.TipoImagen;

import javax.swing.*;

import java.io.IOException;

import static javafx.scene.paint.Color.*;
import static javax.swing.text.StyleConstants.setForeground;

@Component
public class TicTaControl {

    private Jugador jugador1;
    private  Jugador jugador2;
    private Tablero tablero;


    @FXML
    Button btn00, btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22,btnIniciar;
    @FXML
    TextField txtJugador1,txtJugador2;
    @FXML
    Label lblNombreJ1,lblNombreJ2;

    boolean turno=true;
    private JComponent mouseEventCierre;

    @FXML
    void accionButton(ActionEvent e){
       Button b =(Button) e.getSource();
       b.setText(turno?"X":"O");
       turno=!turno;

    }

    @FXML

    public void mouseClick(MouseEvent mouseEvent) {
        System.exit(0); //cierre
    }


    public void mousePressed(MouseEvent mouseEvent) throws IOException {
        FXMLLoader  loader = new FXMLLoader(getClass().getResource("/fxml/TicTacToe.fxml"));
        Parent root = loader.load();

    }



private Stage stage;
    public void setStage(Stage primaryStage) {
        stage = primaryStage;


    }
    public void showTicTacToe(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TicTacToe.fxml"));
        Parent root = loader.load();
        TicTaControl controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        jugador1 = new Jugador(TipoImagen.EQUIS);  // Asignar nombres
        if (txtJugador1.getText().isEmpty()) {
            jugador1.setNombre("Jugador 1");
        } else {
            jugador1.setNombre(txtJugador1.getText());
        }

        jugador2 = new Jugador(TipoImagen.CIRCULO);
        if (txtJugador2.getText().isEmpty()) {
            jugador2.setNombre("Jugador 2");
        } else {
            jugador2.setNombre(txtJugador2.getText());
        }
        controller.lblNombreJ1.setText(jugador1.getNombre()); // Actualiza los nombres en V2
        controller.lblNombreJ2.setText(jugador2.getNombre());

    }


    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void showTicTacToe(Jugador jugador1, Jugador Jugador2){
        this.jugador1 =jugador1;
        this.jugador2 = jugador2;
    }
}
