package br.ufba.activityrecognition.core.weka;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="dataActivity")
@XmlAccessorType(XmlAccessType.FIELD)
public class DataActivityModel implements Serializable{
	
	private static final long serialVersionUID = -4275680271853705080L;
	
	@XmlElement
	private Double accelerometerX;
	@XmlElement
	private Double accelerometerY;
	@XmlElement
	private Double accelerometerZ;
	@XmlElement
	private Double gyroscopeX;
	@XmlElement
	private Double gyroscopeY;
	@XmlElement
	private Double gyroscopeZ;
	@XmlElement
	private Double magnetometerX;
	@XmlElement
	private Double magnetometerY;
	@XmlElement
	private Double magnetometerZ;
	@XmlElement
	private String activity;
	@XmlElement
	private String sourceCollection;
	
	
	public DataActivityModel() {
		this.activity = "?";
	}
	
	public Double getAccelerometerX() {
		return accelerometerX;
	}
	public void setAccelerometerX(Double accelerometerX) {
		this.accelerometerX = accelerometerX;
	}
	public Double getAccelerometerY() {
		return accelerometerY;
	}
	public void setAccelerometerY(Double accelerometerY) {
		this.accelerometerY = accelerometerY;
	}
	public Double getAccelerometerZ() {
		return accelerometerZ;
	}
	public void setAccelerometerZ(Double accelerometerZ) {
		this.accelerometerZ = accelerometerZ;
	}
	public Double getGyroscopeX() {
		return gyroscopeX;
	}
	public void setGyroscopeX(Double gyroscopeX) {
		this.gyroscopeX = gyroscopeX;
	}
	public Double getGyroscopeY() {
		return gyroscopeY;
	}
	public void setGyroscopeY(Double gyroscopeY) {
		this.gyroscopeY = gyroscopeY;
	}
	public Double getGyroscopeZ() {
		return gyroscopeZ;
	}
	public void setGyroscopeZ(Double gyroscopeZ) {
		this.gyroscopeZ = gyroscopeZ;
	}
	public Double getMagnetometerX() {
		return magnetometerX;
	}
	public void setMagnetometerX(Double magnetometerX) {
		this.magnetometerX = magnetometerX;
	}
	public Double getMagnetometerY() {
		return magnetometerY;
	}
	public void setMagnetometerY(Double magnetometerY) {
		this.magnetometerY = magnetometerY;
	}
	public Double getMagnetometerZ() {
		return magnetometerZ;
	}
	public void setMagnetometerZ(Double magnetometerZ) {
		this.magnetometerZ = magnetometerZ;
	}
	public String getActivity() {
		if(activity == null){
			activity = "?";
		}
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getSourceCollection() {
		return sourceCollection;
	}
	public void setSourceCollection(String sourceCollection) {
		this.sourceCollection = sourceCollection;
	}

}
