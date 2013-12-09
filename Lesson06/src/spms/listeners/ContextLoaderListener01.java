package spms.listeners;

//1. 시작 소스
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

//import spms.dao.MemberDao;
import spms.dao.MySqlMemberDao;

//@WebListener
public class ContextLoaderListener01 implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      ServletContext sc = event.getServletContext();
      
      InitialContext initialContext = new InitialContext();
      DataSource ds = (DataSource)initialContext.lookup(
          "java:comp/env/jdbc/studydb");
      
      //MemberDao memberDao = new MemberDao();
      MySqlMemberDao memberDao = new MySqlMemberDao();
      memberDao.setDataSource(ds);
      
      sc.setAttribute("memberDao", memberDao);
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
