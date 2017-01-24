/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.web;

import cl.model.Producto;
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
        
        ArrayList<Producto> listap = new ArrayList();
        listap.add(new Producto(1, "Coca-Cola", 500, 5));
        listap.add(new Producto(2, "Sprite", 600, 10));
        listap.add(new Producto(3, "Fanta", 700, 2));
        
        
        sce.getServletContext().setAttribute("listauser", lista);
        sce.getServletContext().setAttribute("listaproducto", listap);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
