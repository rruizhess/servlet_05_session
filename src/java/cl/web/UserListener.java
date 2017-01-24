/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.web;

import cl.model.User;
import java.util.ArrayList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Web application lifecycle listener.
 *
 * @author roman
 */
@WebListener()
public class UserListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ArrayList<User> lista = new ArrayList();
        lista.add(new User("1-1", "Camilo", "Rojas", "123"));
        lista.add(new User("1-2", "Maria", "Diaz", "123"));
        lista.add(new User("1-3", "Tomas", "Roa", "123"));
        sce.getServletContext().setAttribute("listauser", lista);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
