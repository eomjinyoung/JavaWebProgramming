package exam.test17;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test17/beans.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		Car car2 = (Car) ctx.getBean("car2");
		
		System.out.println(car1);
		System.out.println(car2);
	}
}
