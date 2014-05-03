package exam.test04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test04/beans.xml");
		
		Score score1 = (Score) ctx.getBean("score1");
		System.out.println(score1);
		
		Score score2 = (Score) ctx.getBean("score2");
		System.out.println(score2);
		
		Score score3 = (Score) ctx.getBean("score3");
		System.out.println(score3);
		
		Score score4 = (Score) ctx.getBean("score4");
		System.out.println(score4);
		
		Score score5 = (Score) ctx.getBean("score5");
		System.out.println(score5);
		
	}
}