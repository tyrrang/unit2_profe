package acciones.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import acciones.dao.AccionDAO;
import acciones.dao.AccionDAOImp;
import acciones.model.Accion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author tyrrang
 */
public class AccionController extends HttpServlet{
    private final String LISTA_ACCIONES = "/lista_acciones.jsp";
    private final String AGREGAR_CAMBIAR = "/accion.jsp";
    private AccionDAO dao;
    
    public AccionController() {
        dao = new AccionDAOImp();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String forward = "";
         
        response.getWriter().println(action);    
        if (action.equalsIgnoreCase("borrar")) {
            forward = LISTA_ACCIONES;
            int idAccion = Integer.parseInt(request.getParameter("idAccion"));
            dao.borrarAccion(idAccion);
            request.setAttribute("acciones", dao.desplegarAcciones());
        } else if (action.equalsIgnoreCase("cambiar")) {
            forward = AGREGAR_CAMBIAR;
            int idAccion = Integer.parseInt(request.getParameter("idAccion"));
            
            Accion accion = dao.elegirAccion(idAccion);
            System.out.println(accion);
            request.setAttribute("accion", accion);
        } else if (action.equalsIgnoreCase("agregar")) {
            forward = AGREGAR_CAMBIAR;
        } else {
            forward = LISTA_ACCIONES;
            request.setAttribute("acciones", dao.desplegarAcciones());
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);

        view.forward(request, response);
    }
    
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Accion accion = new Accion();
        accion.setNombre(request.getParameter("nombre"));
        accion.setActivo(request.getParameter("activo"));
        accion.setMateria(request.getParameter("materia"));
        accion.setCuatrimestre(Integer.parseInt(request.getParameter("cuatrimestre")));
        accion.setMaestro(request.getParameter("maestro"));
        
        String idAccion = request.getParameter("idAccion");

        if (idAccion == null || idAccion.isEmpty()) {
            dao.agregarAccion(accion);
        } else {
            accion.setIdAccion(Integer.parseInt(idAccion));
            dao.cambiarAccion(accion);
        }

        RequestDispatcher view = request.getRequestDispatcher(LISTA_ACCIONES);
        request.setAttribute("acciones", dao.desplegarAcciones());
        view.forward(request, response);

    }
    
    
}
