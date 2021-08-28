package com.example.parkingsystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {
	
	@Autowired
	private ParkingRepository repo;

	@Override
	public List<Parking> getAll() {
		return (List<Parking>) repo.findAll();
	}

	@Override
	public Object get(long id) {
		return repo.findById(id);
	}

	@Override
	public Parking store(Parking parking) {
		return repo.save(parking);
	}

	@Override
	public Parking update(Parking parking, long id) {
		parking.setId(id);
		return repo.save(parking);
	}

	@Override
	public boolean delete(long id) {
		repo.deleteById(id);
		return true;
	}
		
}
