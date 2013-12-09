package spms.dao;

import java.util.List;

import spms.vo.Project;

public interface ProjectDao01 {
  List<Project> selectList() throws Exception;
}
