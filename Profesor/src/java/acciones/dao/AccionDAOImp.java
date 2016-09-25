/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acciones.dao;

//import acciones.model.Accion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import acciones.model.Accion;
import profesores.util.UtilDB;

/**
 *
 * @author tyrrang
 */
public class AccionDAOImp implements AccionDAO{
    
    private Connection connection;

    public AccionDAOImp(){
        connection = UtilDB.getConnection();
    }
    
    @Override
    public void agregarAccion(Accion accion) {
         String sql = "INSERT INTO accionremedial (nombre,activo,materia,"
                 + "cuatrimestre,maestro)"
                + " VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accion.getNombre());
            ps.setString(2, accion.getActivo());
            ps.setString(3, accion.getMateria());
            ps.setInt(4, accion.getCuatrimestre());
            ps.setString(5, accion.getMaestro());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarAccion(int id_accion_remedial) {
    String sql = "DELETE FROM accionremedial WHERE id_accion_remedial=? ";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id_accion_remedial);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarAccion(Accion accion) {
         String sql = "UPDATE accionremedial SET nombre=?, activo=?, "
                 + "materia=?, cuatrimestre=?, maestro=?"
                + " WHERE id_accion_remedial=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, accion.getNombre());
            ps.setString(2, accion.getActivo());
            ps.setString(3, accion.getMateria());
            ps.setInt(4, accion.getCuatrimestre());
            ps.setString(5, accion.getMaestro());
            ps.setInt(6, accion.getIdAccion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Accion> desplegarAcciones() {
        List<Accion> acciones = new ArrayList<Accion>();
        try {
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM accionremedial");
            while (rs.next()) {
                
                Accion accion = new Accion(rs.getInt("id_accion_remedial"),
                       
                        rs.getString("nombre"),
                        rs.getString("activo"),
                        rs.getString("materia"),
                        rs.getInt("cuatrimestre"),
                        rs.getString("maestro"));
                acciones.add(accion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acciones;
    
    }

    @Override
    public Accion elegirAccion(int idAccion) {
        
         Accion accion = null;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM accionremedial "
                    + "WHERE id_accion_remedial=?");
            ps.setInt(1, idAccion);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                accion = new Accion(
                        rs.getInt("id_accion_remedial"),
                        rs.getString("nombre"),
                        rs.getString("activo"),
                        rs.getString("materia"),
                        rs.getInt("cuatrimestre"),
                        rs.getString("maestro"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(accion);
        return accion;
    }
    
}
