package com.example.parkingsystem;

import java.util.List;

public interface ParkingService {
	List<Parking> getAll();
	Object get(long id);
	Parking store(Parking parking);
	Parking update(Parking parking, long id);
	boolean delete(long id);
}
