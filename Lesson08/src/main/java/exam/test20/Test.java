package exam.test20;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test20/beans.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1.getEngine());
	}
}
