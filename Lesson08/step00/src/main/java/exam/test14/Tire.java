package exam.test14;

import java.util.Date;
import java.util.Map.Entry;
import java.util.Properties;

public class Tire {
	String 			maker; // 제조사
	Properties	spec; // 규격
	Date				createdDate; //제조일
	
	public String getMaker() {
		return maker;
	}
	
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	public Properties getSpec() {
		return spec;
	}

	public void setSpec(Properties spec) {
		this.spec = spec;
	}

	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@Override
	public String toString() {
		StringBuffer specInfo = new StringBuffer();
		if (spec != null) {
			for (Entry<Object,Object> entry : spec.entrySet()) {
				specInfo.append(entry.getKey() + ":" + entry.getValue() + ",");
			}
		}
	  return "[Tire:" + maker + "," + 
				specInfo.toString() + 
	  		((createdDate != null)?("," + createdDate.toString()):"") + "]";
	}
}
