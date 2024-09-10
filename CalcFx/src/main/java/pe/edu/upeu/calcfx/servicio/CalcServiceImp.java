package pe.edu.upeu.calcfx.servicio;

import org.springframework.stereotype.Service;
import pe.edu.upeu.calcfx.modelo.CalcTO;
import java.util.ArrayList;
import java.util.List;

@Service
public class CalcServiceImp implements CalcServicel{

    List<CalcTO> dbOper = new ArrayList<>();
    @Override
    public void guardarResltados(CalcTO to) {
        dbOper.add(to);
    }

    @Override
    public List<CalcTO> obtenerResltados() {
        return dbOper;
    }
    @Override
    public void actualizarResltado(CalcTO to, int index) {
        dbOper.set(index, to);
    }
    @Override
    public void eliminarResltado( int index) {
        dbOper.remove(index);
    }


}
