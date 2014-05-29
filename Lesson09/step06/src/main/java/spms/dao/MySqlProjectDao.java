package spms.dao;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spms.vo.Project;

//@Repository 애노테이션으로 변경
@Repository
public class MySqlProjectDao implements ProjectDao {
  SqlSessionFactory sqlSessionFactory;

  @Autowired
  public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
    this.sqlSessionFactory = sqlSessionFactory;
  }

  public List<Project> selectList(HashMap<String,Object> paramMap) 
  		throws Exception {
    SqlSession sqlSession = sqlSessionFactory.openSession();
    try {
      return sqlSession.selectList("spms.dao.ProjectDao.selectList", paramMap);
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
    	Project original = sqlSession.selectOne(
    			"spms.dao.ProjectDao.selectOne", project.getNo());
    	
    	Hashtable<String,Object> paramMap = new Hashtable<String,Object>();
    	if (!project.getTitle().equals(original.getTitle())) {
    		paramMap.put("title", project.getTitle());
    	}
    	if (!project.getContent().equals(original.getContent())) {
    		paramMap.put("content", project.getContent());
    	}
    	if (project.getStartDate().compareTo(original.getStartDate()) != 0) {
    		paramMap.put("startDate", project.getStartDate());
    	}
    	if (project.getEndDate().compareTo(original.getEndDate()) != 0) {
    		paramMap.put("endDate", project.getEndDate());
    	}
    	if (project.getState() != original.getState()) {
    		paramMap.put("state", project.getState());
    	}
    	if (!project.getTags().equals(original.getTags())) {
    		paramMap.put("tags", project.getTags());
    	}
    	
    	if (paramMap.size() > 0) {
    		paramMap.put("no", project.getNo());
    		int count = sqlSession.update("spms.dao.ProjectDao.update", paramMap);
    		sqlSession.commit();
    		return count;
    	} else {
    		return 0;
    	}
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
