package spms.vo;

import java.util.Date;

public class Project {
  protected int     no; //프로젝트일련번호
  protected String  title; //프로젝트명
  protected String  content; //설명
  protected Date    startDate; //시작일
  protected Date    endDate; //종료일
  protected int     state; //상태
  protected Date    createdDate; //생성일
  protected String  tags; //태그들
  
  public int getNo() {
    return no;
  }
  public Project setNo(int no) {
    this.no = no;
    return this;
  }
  public String getTitle() {
    return title;
  }
  public Project setTitle(String title) {
    this.title = title;
    return this;
  }
  public String getContent() {
    return content;
  }
  public Project setContent(String content) {
    this.content = content;
    return this;
  }
  public Date getStartDate() {
    return startDate;
  }
  public Project setStartDate(Date startDate) {
    this.startDate = startDate;
    return this;
  }
  public Date getEndDate() {
    return endDate;
  }
  public Project setEndDate(Date endDate) {
    this.endDate = endDate;
    return this;
  }
  public int getState() {
    return state;
  }
  public Project setState(int state) {
    this.state = state;
    return this;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public Project setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
    return this;
  }
  public String getTags() {
    return tags;
  }
  public Project setTags(String tags) {
    this.tags = tags;
    return this;
  }
}
