package exam.test07;

public class Car {
	String			model; // 모델명
	Engine 			engine; // 엔진
	Tire[]			tires; // 타이어
	
	public Car() {}
	
	public Car(String model, Engine engine) {
		this.model = model;
		this.engine = engine;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	
	public Tire[] getTires() {
		return tires;
	}

	public void setTires(Tire[] tires) {
		this.tires = tires;
	}

	@Override
	public String toString() {
		StringBuffer carInfo = new StringBuffer();
		carInfo.append("[Car:" + model);
		carInfo.append("\n  " + engine.toString());
		if (tires != null) {
			for (Tire tire : tires) {
				carInfo.append("\n  " + tire.toString());
			}
		}
		carInfo.append("\n]");
	  return carInfo.toString();
	}
}
