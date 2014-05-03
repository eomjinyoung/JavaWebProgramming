package exam.test01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test01/beans.xml");
		
		Score score = (Score) ctx.getBean("score");
		
		System.out.println("합계:" + score.sum());
		System.out.println("평균:" + score.average());
	}
}
