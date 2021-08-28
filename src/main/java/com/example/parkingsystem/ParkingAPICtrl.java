package com.example.parkingsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingAPICtrl {
	@Autowired
	private ParkingServiceImpl service;
	
	@CrossOrigin
	@RequestMapping("/api/v1/parkings")
	public ResponseEntity<Object> getAll(){
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/parkings/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable("id") long id){
		return new ResponseEntity<>(service.get(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/parkings", method=RequestMethod.POST)
	public ResponseEntity<Object> store(@RequestBody Parking parking){
		return new ResponseEntity<>(service.store(parking), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/parkings/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> update(@RequestBody Parking parking, @PathVariable("id") long id){
		return new ResponseEntity<>(service.update(parking, id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/api/v1/parkings/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") long id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
}
