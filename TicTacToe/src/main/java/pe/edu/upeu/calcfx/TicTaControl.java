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

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import org.springframework.stereotype.Component;
import pe.edu.upeu.calcfx.modelo.Jugador;
import pe.edu.upeu.calcfx.modelo.TipoImagen;

import java.io.IOException;

@Component
public class TicTaControl {

    private Stage stage;
    private String comenzarJuego = "X";
    private int xContador = 0;
    private int oContador = 0;
    private Jugador jugador1;
    private Jugador jugador2;

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22, btnIniciar;
    @FXML
    TextField txtJugador1, txtJugador2;
    @FXML
    Label lblNombreJ1, lblNombreJ2, lblPuntajeJ1, lblPuntajeJ2;

    private Button[][] tablero;

    @FXML
    public void initialize() {
        tablero = new Button[][]{
                {btn00, btn01, btn02},
                {btn10, btn11, btn12},
                {btn20, btn21, btn22}
        };
    }

    @FXML
    void accionButton(ActionEvent e) {
        Button btn = (Button) e.getSource();
        if (btn.getText().equals("")) {
            btn.setText(comenzarJuego);
            verificarGanador();
            cambiarTurno();
        }
    }

    private void cambiarTurno() {
        comenzarJuego = comenzarJuego.equals("X") ? "O" : "X";
    }

    private void verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].getText().equals(comenzarJuego) &&
                    tablero[i][1].getText().equals(comenzarJuego) &&
                    tablero[i][2].getText().equals(comenzarJuego)) {
                resaltarGanador(tablero[i][0], tablero[i][1], tablero[i][2]);
                actualizarPuntaje();
                return;
            }
            if (tablero[0][i].getText().equals(comenzarJuego) &&
                    tablero[1][i].getText().equals(comenzarJuego) &&
                    tablero[2][i].getText().equals(comenzarJuego)) {
                resaltarGanador(tablero[0][i], tablero[1][i], tablero[2][i]);
                actualizarPuntaje();
                return;
            }
        }
        if (tablero[0][0].getText().equals(comenzarJuego) &&
                tablero[1][1].getText().equals(comenzarJuego) &&
                tablero[2][2].getText().equals(comenzarJuego)) {
            resaltarGanador(tablero[0][0], tablero[1][1], tablero[2][2]);
            actualizarPuntaje();
            return;
        }
        if (tablero[0][2].getText().equals(comenzarJuego) &&
                tablero[1][1].getText().equals(comenzarJuego) &&
                tablero[2][0].getText().equals(comenzarJuego)) {
            resaltarGanador(tablero[0][2], tablero[1][1], tablero[2][0]);
            actualizarPuntaje();
        }
    }

    private void resaltarGanador(Button... botones) {
        for (Button btn : botones) {
            btn.setStyle("-fx-background-color: orange;");
        }
    }

    private void actualizarPuntaje() {
        if (comenzarJuego.equals("X")) {
            xContador++;
            lblPuntajeJ1.setText(String.valueOf(xContador));
        } else {
            oContador++;
            lblPuntajeJ2.setText(String.valueOf(oContador));
        }
        reiniciarTablero();
    }

    public void reiniciarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j].setText("");
                tablero[i][j].setStyle("");
            }
        }
        comenzarJuego = "X";
    }


        boolean turno=true;
        private JComponent mouseEventCierre;


        @FXML

        public void mouseClick(MouseEvent mouseEvent) {
            System.exit(0); //cierre
        }
        public void mousePressed(MouseEvent mouseEvent) throws IOException {
            FXMLLoader  loader = new FXMLLoader(getClass().getResource("/fxml/TicTacToe.fxml"));
            Parent root = loader.load();

        }
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
            Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            currentStage.close();


            jugador1 = new Jugador(TipoImagen.EQUIS);  // Asignarnombres
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



