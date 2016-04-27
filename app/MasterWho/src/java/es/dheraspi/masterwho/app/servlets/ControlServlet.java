/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.servlets;

import es.dheraspi.masterwho.app.model.DAO;

import java.io.IOException;
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
        
        DAO dao = getDao();
        dao.setRegion(region);
        dao.setSummoner(name);
        
        user.setName(name); user.setRegion(region);
        
        request.setAttribute("user", user);
        request.getRequestDispatcher("/inicio.jsp").forward(request, response);
    }

    private void doShowChamps(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DAO dao = getDao();
        List<MasterWhoChampion> champs = dao.getMasteries();
        
        request.setAttribute("champs", champs);
        request.getRequestDispatcher("/champmasterylist.jsp").forward(request, response);
    }
    
    private void doPlayMasterWho(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        DAO dao = getDao();
        List<MasterWhoChampion> champs = dao.getMasteries();
        LinkedList<MasterWhoChampion> toplaners = new LinkedList<>();
        LinkedList<MasterWhoChampion> junglers = new LinkedList<>();
        LinkedList<MasterWhoChampion> midlaners = new LinkedList<>();
        LinkedList<MasterWhoChampion> adcs = new LinkedList<>();
        LinkedList<MasterWhoChampion> supports = new LinkedList<>();
        
        for (MasterWhoChampion champ: champs)
        {
            List<String> tags = champ.getChampion().getTags();
            for (String tag: tags)
            {
                switch (tag)
                {
                    case "Fighter":
                        if (!toplaners.contains(champ))toplaners.add(champ);
                        if (!junglers.contains(champ))junglers.add(champ);
                        if (!midlaners.contains(champ))midlaners.add(champ);
                        break;
                    case "Assasin":
                        if (!toplaners.contains(champ))junglers.add(champ);
                        if (!midlaners.contains(champ))midlaners.add(champ);
                        break;
                    case "Tank":
                        if (!toplaners.contains(champ))toplaners.add(champ);
                        if (!junglers.contains(champ))junglers.add(champ);
                        if (!supports.contains(champ))supports.add(champ);
                        break;
                    case "Mage":
                        if (!toplaners.contains(champ))toplaners.add(champ);
                        if (!midlaners.contains(champ))midlaners.add(champ);
                        break;
                    case "Marksman":
                        if (!adcs.contains(champ))adcs.add(champ);
                        break;
                    case "Support":
                        if (!supports.contains(champ))supports.add(champ);
                        break;
                }
            }
        }
        
        request.setAttribute("toplaners", toplaners);
        request.setAttribute("junglers", junglers);
        request.setAttribute("midlaners", midlaners);
        request.setAttribute("adcs", adcs);
        request.setAttribute("supports", supports);
        
        request.getRequestDispatcher("/teambuilder.jsp").forward(request, response);
    }
}
