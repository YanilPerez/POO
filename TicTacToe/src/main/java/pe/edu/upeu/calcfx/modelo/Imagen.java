package pe.edu.upeu.calcfx.modelo;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Imagen extends JLabel {
    private String ruta ="";

    @Override
    protected void paintComponent(Graphics gg) {
        Graphics2D g= (Graphics2D) gg;
        URL rutaAbsoluta = getClass().getResource(ruta); //ing en cualquier dis
        if(rutaAbsoluta!=null){
            ImageIcon imagen = new ImageIcon(rutaAbsoluta);
            g.drawImage(imagen.getImage(),0,0,this.getWidth(),this.getHeight(),null);
        }
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
