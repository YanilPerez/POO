package pe.edu.upeu.calcfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.stereotype.Component;

@Component
public class TicTaControl {

    Button [][]tablero;
    @FXML
Button btn00, btn01,btn02,btn10,btn11,btn12,btn20,btn21,btn22;

    boolean turno=true;

    @FXML
    public void initialize() {
        tablero=new Button[][]{
                {btn00, btn01,btn02},
                {btn10,btn11,btn12},
                {btn20,btn21,btn22},
        };
    }
    @FXML
    void accionButton(ActionEvent e){
       Button b =(Button) e.getSource();
       b.setText(turno?"X":"O");
       turno=!turno;

    }
}
