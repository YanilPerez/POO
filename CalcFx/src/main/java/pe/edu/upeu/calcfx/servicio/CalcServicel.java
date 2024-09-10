package pe.edu.upeu.calcfx.servicio;

import pe.edu.upeu.calcfx.modelo.CalcTO;

import java.util.List;

public interface CalcServicel {

    public void guardarResltados(CalcTO to);
    public List<CalcTO> obtenerResltados();
    public void actualizarResltado( CalcTO to, int index);
    public void eliminarResltado( int index);


}
