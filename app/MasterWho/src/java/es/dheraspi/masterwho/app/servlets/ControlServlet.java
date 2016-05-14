/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.servlets;

import com.robrua.orianna.api.core.RiotAPI;
import com.robrua.orianna.type.core.common.Region;
import com.robrua.orianna.type.core.summoner.Summoner;
import es.dheraspi.masterwho.app.model.DAO;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
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
            case "/showchamps.do":      doShowChamps(request, response);
                break;
            case "/playmasterwho.do":   doPlayMasterWho(request, response);
                break;
            case "/inicio.do":          doInicio(request, response);
                break;
            case "/validateteam.do":    doValidateTeam(request, response);
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

    private void doInicio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        User user = new User();
        String name = request.getParameter("name");
        String region = request.getParameter("region");
        RiotAPI.setRegion(Region.valueOf(region));
        
        DAO dao = getDao();
        Summoner summoner = RiotAPI.getSummonerByName(name);
        
        ServletContext sc = request.getServletContext();
        sc.setAttribute("summoner", summoner);
        request.getRequestDispatcher("/inicio.jsp").forward(request, response);
    }

    private void doShowChamps(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DAO dao = getDao();
        ServletContext sc = request.getServletContext();
        Summoner summoner = (Summoner) sc.getAttribute("summoner");
        List<MWChampion> champs = dao.getMasteries(summoner);
        
        request.setAttribute("champs", champs);
        request.getRequestDispatcher("/champmasterylist.jsp").forward(request, response);
    }
    
    private void doPlayMasterWho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        DAO dao = getDao();
        ServletContext sc = request.getServletContext();
        Summoner summoner = (Summoner) sc.getAttribute("summoner");
        List<MWChampion> champs = dao.getMasteries(summoner);
        Collection<MWChampion> team = new LinkedList<>();
        
        team.add(champs.get(0));
        team.add(champs.get(1));
        team.add(champs.get(2));
        team.add(champs.get(3));
        team.add(champs.get(4));
        
        sc.setAttribute("team", team);
        request.getRequestDispatcher("/teambuilder.jsp").forward(request, response);
    }

    private void doValidateTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException    
    {
        DAO dao = getDao();
        ServletContext sc = request.getServletContext();
        
        String name = request.getParameter("name");
        String region = request.getParameter("region");
        
        RiotAPI.setRegion(Region.valueOf(region));
        Summoner summoner2 = RiotAPI.getSummonerByName(name);
        List<MWChampion> champs2 = dao.getMasteries(summoner2);
        
        Collection<MWChampion> enemyTeam = new LinkedList<>();
        
        enemyTeam.add(champs2.get(0));
        enemyTeam.add(champs2.get(1));
        enemyTeam.add(champs2.get(2));
        enemyTeam.add(champs2.get(3));
        enemyTeam.add(champs2.get(4));
        
        sc.setAttribute("enemyTeam", enemyTeam);
        sc.setAttribute("summoner2", summoner2);
        request.getRequestDispatcher("/battleground.jsp").forward(request, response);
    }
}
