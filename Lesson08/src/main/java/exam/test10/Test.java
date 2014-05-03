package exam.test10;

import java.util.Map.Entry;
import java.util.Properties;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("exam/test10/beans.xml");
		
		System.out.println("[Propoerties 타입]---------------------");
		Tire spareTire = (Tire) ctx.getBean("spareTire");
		for (Entry<Object,Object> entry : spareTire.getSpec().entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		System.out.println("[Map 타입]---------------------");
		Car car1 = (Car) ctx.getBean("car1");
		for (Entry<String,Object> entry : car1.getOptions().entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
