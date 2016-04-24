/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.dheraspi.masterwho.app.listeners;

import es.dheraspi.masterwho.app.model.DAO;
import es.dheraspi.masterwho.app.model.DAORiotGames;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author david
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) 
    {
        ServletContext sc = sce.getServletContext();
        
        try
        {
            DAO dao = new DAORiotGames();
            dao.init();
            sc.setAttribute("dao", dao);
        }catch (Exception ex) {}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
