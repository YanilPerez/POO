package pe.edu.upeu.calcfx.control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.springframework.stereotype.Component;

@Component
public class CalcControl {

@FXML
    TextField txtResultado;
@FXML
    public void accionButton(ActionEvent event){
    System.out.println("....Hola");
    Button button= (Button) event.getSource();//
    switch (button.getId()){
        case"btn7","btn8","btn9","btn4","btn5","btn6","btn1","btn2","btn3","btn0":{
            escribirNumeros(button.getText());
        }break;
        case "btnSum","btnDiv","btnRes","btnMul":{
            operador(button.getText());
        } break;
        case "btnIgual":{

        }break;
        case "btnBorrar":{
            txtResultado.clear();
        }
    }
}
public void operador(String event){
    txtResultado.appendText(" "+valor+" ");
        }
public void calcularResultado(){
    String[]valores=txtResultado.getText().split(" ");

    double val1=Double.parseDouble(String.valueOf(valores[0]));
    double val2=Double.parseDouble(String.valueOf(valores[2]));
    switch (valores[1]){
        case "+":{txtResultado.setText(String.valueOf(val1+val2));}break;
        case "-":{txtResultado.setText(String.valueOf(val1-val2));}break;
        case "/":{txtResultado.setText(String.valueOf(val1/val2));}break;
        case "*":{txtResultado.setText(String.valueOf(val1*val2));}break;
    }
}
public void escribirNumeros(String valor){
    txtResultado.appendText(valor);
}
}
