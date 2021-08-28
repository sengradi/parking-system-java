package com.example.parkingsystem;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parkings")
public class Parking {
	
	@Id
	private long id;
	private String plate_number;
	private String vehicle_type;
	private String check_in;
	private String check_out = "";
	private double parking_fee = 0;
	private String status;
	
	public Parking() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	



	public Parking(long id, String plate_number, String vehicle_type, String check_in, String check_out,
			double parking_fee, String status) {
		super();
		this.id = id;
		this.plate_number = plate_number;
		this.vehicle_type = vehicle_type;
		this.check_in = check_in;
		this.check_out = check_out;
		this.parking_fee = parking_fee;
		this.status = status;
	}







	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public String getVehicle_type() {
		return vehicle_type;
	}

	public void setVehicle_type(String vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	

	public String getCheck_in() {
		return check_in;
	}







	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}







	public String getCheck_out() {
		return check_out;
	}







	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}







	public double getParking_fee() {
		return parking_fee;
	}

	public void setParking_fee(double parking_fee) {
		this.parking_fee = parking_fee;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
