package exam.test11;

public class Engine {
	String 	maker; // 제조사
	int 		cc; // 배기량
	
	public Engine() {}
	
	public Engine(String maker) {
		this.maker = maker;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
	@Override
	public String toString() {
	  return "[Engine:" + maker + "," + cc + "]";
	}
}
