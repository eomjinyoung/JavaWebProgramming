package spms.dao;

// mybatis 적용
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotation.Component;
import spms.vo.Project;

@Component("projectDao")
public class MySqlProjectDao implements ProjectDao {
  SqlSessionFactory sqlSessionFactory;

  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Project> selectList() throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("spms.dao.ProjectDao.selectList");
    } finally {
      sqlSession.close();
    }
  }

  public int insert(Project project) throws Exception  {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.insert("spms.dao.ProjectDao.insert", project);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
  
  public Project selectOne(int no) throws Exception { 
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectOne("spms.dao.ProjectDao.selectOne", no);
    } finally {
      sqlSession.close();
    }
  }

  public int update(Project project) throws Exception { 
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.update("spms.dao.ProjectDao.update", project);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }  

  public int delete(int no) throws Exception {  
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      int count = sqlSession.delete("spms.dao.ProjectDao.delete", no);
      sqlSession.commit();
      return count;
    } finally {
      sqlSession.close();
    }
  }
}
