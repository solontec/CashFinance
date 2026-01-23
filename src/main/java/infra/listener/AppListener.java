package infra.listener;

import infra.db.DatabaseInit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DatabaseInit.init();
        System.out.println("SQLite pronto para uso");
    }
}
