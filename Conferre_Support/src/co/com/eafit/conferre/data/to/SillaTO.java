package co.com.eafit.conferre.data.to;

import co.com.eafit.conferre.generics.GenericDTO;

public class SillaTO implements GenericDTO {
	String id;
	String position;
	public SillaTO(String id, String position) {
		super();
		this.id = id;
		this.position = position;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
}
