package spms.listeners;

// SqlSessionFactory 객체 준비
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spms.context.ApplicationContext;

@WebListener
public class ContextLoaderListener implements ServletContextListener {
  static ApplicationContext applicationContext;
  
  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }
   
  @Override
  public void contextInitialized(ServletContextEvent event) {
    try {
      applicationContext = new ApplicationContext();
      
      String resource = "spms/dao/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory = 
          new SqlSessionFactoryBuilder().build(inputStream);
      
      applicationContext.addBean("sqlSessionFactory", sqlSessionFactory);
      
      ServletContext sc = event.getServletContext();
      String propertiesPath = sc.getRealPath(
          sc.getInitParameter("contextConfigLocation"));
      
      applicationContext.prepareObjectsByProperties(propertiesPath);
      
      applicationContext.prepareObjectsByAnnotation("");
      
      applicationContext.injectDependency();
      
    } catch(Throwable e) {
      e.printStackTrace();
    }
  }
  
  @Override
  public void contextDestroyed(ServletContextEvent event) {}
}
