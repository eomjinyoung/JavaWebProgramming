package exam.test14;

import java.text.SimpleDateFormat;
import java.util.Properties;

import org.springframework.beans.factory.config.AbstractFactoryBean;

public class TireFactoryBean extends AbstractFactoryBean<Tire> {
	String maker;
	
	public void setMaker(String maker) {
	  this.maker = maker;
  }
	
	@Override
	public Class<?> getObjectType() {
	  return exam.test13.Tire.class;
	}
	
	protected Tire createInstance() {
		if (maker.equals("Hankook")) {
			return createHankookTire();
		} else {
			return createKumhoTire();
		}
	}
	
	private Tire createHankookTire() {
		Tire tire = new Tire();
		tire.setMaker("Hankook");
		
		Properties specProp = new Properties();
		specProp.setProperty("width", "205");
		specProp.setProperty("ratio", "65");
		specProp.setProperty("rim.diameter", "14");
		tire.setSpec(specProp);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			tire.setCreatedDate(dateFormat.parse("2014-5-5"));
		} catch (Exception e) {}
		
		return tire;
	}
	
	private Tire createKumhoTire() {
		Tire tire = new Tire();
		tire.setMaker("Kumho");
		
		Properties specProp = new Properties();
		specProp.setProperty("width", "185");
		specProp.setProperty("ratio", "75");
		specProp.setProperty("rim.diameter", "16");
		tire.setSpec(specProp);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			tire.setCreatedDate(dateFormat.parse("2014-3-1"));
		} catch (Exception e) {}
		
		return tire;
	}
}
