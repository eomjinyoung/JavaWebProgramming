package exam.test07;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test07/beans.xml");
		
		Car car1 = (Car) ctx.getBean("car1");
		System.out.println(car1);
		
		Engine engine = (Engine) ctx.getBean("engine1");
		engine.cc = 3000;
		
		System.out.println(car1);
		
		Car car2 = (Car) ctx.getBean("car2");
		System.out.println(car2);
		
		Car car3 = (Car) ctx.getBean("car3");
		System.out.println(car3);
		
		Car car4 = (Car) ctx.getBean("car4");
		System.out.println(car4);
	}
}
