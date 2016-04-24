/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.servlets;

import com.robrua.orianna.type.core.championmastery.ChampionMastery;
import com.robrua.orianna.type.core.staticdata.Champion;
import es.dheraspi.masterwho.app.model.DAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david
 */
@WebServlet(name = "Control", urlPatterns = {"*.do"})
public class ControlServlet extends HttpServlet {

    private DAO getDao()
    {
        ServletContext sc = this.getServletContext();
        DAO dao = (DAO) sc.getAttribute("dao");
        
        return dao;
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String servletPath = request.getServletPath();
        
        switch ( servletPath )
        {
            case "/playmasterwho.do":   doPlayMasterWho(request, response);
                break;
            case "/inicio.do":          doInicio(request, response);
                break;
            default:
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void doPlayMasterWho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        DAO dao = getDao();
        List<MasterWhoChampion> champs = dao.getMasteries();
        
        request.setAttribute("champs", champs);
        request.getRequestDispatcher("/masterwho.jsp").forward(request, response);
    }

    private void doInicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        User user = new User();
        String name = request.getParameter("name");
        String region = request.getParameter("region");
        
        DAO dao = getDao();
        dao.setRegion(region);
        dao.setSummoner(name);
        
        user.setName(name); user.setRegion(region);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/inicio.jsp").forward(request, response);
    }
}
