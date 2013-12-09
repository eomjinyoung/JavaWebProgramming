package spms.dao;

import java.util.List;

import spms.vo.Project;

public interface ProjectDao02 {
  List<Project> selectList() throws Exception;
  int insert(Project project) throws Exception;
}
