package pe.edu.upeu.calcfx.modelo;

public class Jugador {
    private String nombre;
    private TipoImagen tipoImagen;

    public Jugador(){}
    public Jugador(TipoImagen tipoImagen){
        this.tipoImagen = tipoImagen;
    }
    public Jugador(String nombre,TipoImagen tipoImagen){
        this.nombre = nombre;
        this.tipoImagen = tipoImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoImagen getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(TipoImagen tipoImagen) {
        this.tipoImagen = tipoImagen;
    }
}
