package br.ufba.activityrecognition.core.weka;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DataActivityModel implements Serializable{
	
	private static final long serialVersionUID = -4275680271853705080L;
	
	private Double accelerometerX;
	private Double accelerometerY;
	private Double accelerometerZ;
	private Double gyroscopeX;
	private Double gyroscopeY;
	private Double gyroscopeZ;
	private Double magnetometerX;
	private Double magnetometerY;
	private Double magnetometerZ;
	private String activity;
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
