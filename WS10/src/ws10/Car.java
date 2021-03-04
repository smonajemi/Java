package ws10;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable {
	private String m_model;
	private String m_color;
	private double m_mileage;
	private String m_plate;

	public Car(String model,String color,double mileage) {
		m_model = model;
		m_color = color;
		m_mileage = mileage;
		m_plate = "undefined";
	}
	
	public void setModel(String model) {
		m_model = model;
	} 
		public String getModel() {
			return m_model;
		}
	
	public void setColor(String color) {
		m_color = color;
	}
		public String getColor() {
				return m_color;
			}
	
	public void setMileage(double mileage) {
		m_mileage = mileage;
	}
		public double getMileage() {
			return m_mileage;
		}
	
	public void setPlate(String plate) {
		m_plate = plate;
	}
		public String getPlate() {
				return m_plate;
			}
		
	public String toString() {
		return "\nModel: " + getModel() + '\n' + "Color: " + getColor() + '\n' + "Mileage: " + String.format("%.3f", getMileage()) + " km"+ '\n' + "Plate: " + getPlate();
	}	

}