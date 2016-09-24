/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.dao;

import acciones.model.Accion;
import java.util.List;


/**
 *
 * @author tyrrang
 */
public interface AccionDAO {
    void agregarAccion(Accion accion);
    void borrarAccion(int idAccion);
    void cambiarAccion(Accion accion);
    
    List<Accion> desplegarAcciones();
    Accion elegirAccion (int idAccion);
}
