package pe.edu.upeu.calcfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pe.edu.upeu.calcfx.modelo.Jugador;
import pe.edu.upeu.calcfx.modelo.TipoImagen;

import java.io.IOException;

public class ControllerTTT {

    private Stage stage;
    private String comenzarJuego = "X";
    private int xContador = 0;
    private int oContador = 0;
    private Jugador jugador1;
    private Jugador jugador2;

    @FXML
    Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;
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
            if (verificarGanador()) {
                actualizarPuntaje();
            } else if (verificarEmpate()) {
                declararEmpate();
            } else {
                cambiarTurno();
            }
        }
    }

    private void cambiarTurno() {
        comenzarJuego = comenzarJuego.equals("X") ? "O" : "X";
    }

    private boolean verificarGanador() {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0].getText().equals(comenzarJuego) &&
                    tablero[i][1].getText().equals(comenzarJuego) &&
                    tablero[i][2].getText().equals(comenzarJuego)) {
                resaltarGanador(tablero[i][0], tablero[i][1], tablero[i][2]);
                return true;
            }
            if (tablero[0][i].getText().equals(comenzarJuego) &&
                    tablero[1][i].getText().equals(comenzarJuego) &&
                    tablero[2][i].getText().equals(comenzarJuego)) {
                resaltarGanador(tablero[0][i], tablero[1][i], tablero[2][i]);
                return true;
            }
        }
        if (tablero[0][0].getText().equals(comenzarJuego) &&
                tablero[1][1].getText().equals(comenzarJuego) &&
                tablero[2][2].getText().equals(comenzarJuego)) {
            resaltarGanador(tablero[0][0], tablero[1][1], tablero[2][2]);
            return true;
        }
        if (tablero[0][2].getText().equals(comenzarJuego) &&
                tablero[1][1].getText().equals(comenzarJuego) &&
                tablero[2][0].getText().equals(comenzarJuego)) {
            resaltarGanador(tablero[0][2], tablero[1][1], tablero[2][0]);
            return true;
        }
        return false;
    }

    private boolean verificarEmpate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j].getText().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void declararEmpate() {
        System.out.println("¡Es un empate!");
        reiniciarTablero();
    }

    private void resaltarGanador(Button... botones) {
        for (Button btn : botones) {
            btn.setStyle("-fx-background-color: orange;");
        }
    }

    private void actualizarPuntaje() {
        String ganador = (comenzarJuego.equals("X")) ? jugador1.getNombre() : jugador2.getNombre();
        System.out.println("¡" + ganador + " ha ganado!");

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

    @FXML
    public void showTicTacToe(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/TicTacToe.fxml"));
        Parent root = loader.load();
        ControllerTTT controller = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        currentStage.close();

        jugador1 = new Jugador(TipoImagen.EQUIS);
        jugador1.setNombre(txtJugador1.getText().isEmpty() ? "Jugador 1" : txtJugador1.getText());

        jugador2 = new Jugador(TipoImagen.CIRCULO);
        jugador2.setNombre(txtJugador2.getText().isEmpty() ? "Jugador 2" : txtJugador2.getText());

        controller.lblNombreJ1.setText(jugador1.getNombre());
        controller.lblNombreJ2.setText(jugador2.getNombre());
    }

    public void setStage(Stage primaryStage) {
        stage = primaryStage;
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
}
