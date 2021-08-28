package com.example.parkingsystem;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class ParkingCtrl {
	
	@Autowired
	private ParkingServiceImpl service;
	
	@CrossOrigin
	@RequestMapping("/")
	public ModelAndView index(){
		String userDirectory = new File("").getAbsolutePath();
	    System.out.println(userDirectory);
		ModelAndView modelAndView = new ModelAndView();
		List<Parking> pList = service.getAll();
		Parking p = new Parking();
		modelAndView.setViewName("index");
		modelAndView.addObject("parking", p);	
		modelAndView.addObject("parkings", pList);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping("/parkings")
	public ModelAndView getAll(){	
		String userDirectory = new File("").getAbsolutePath();
	    System.out.println(userDirectory);
		ModelAndView modelAndView = new ModelAndView();
		List<Parking> pList = service.getAll();
		Parking p = new Parking();
		modelAndView.setViewName("index");
		modelAndView.addObject("parking", p);	
		modelAndView.addObject("parkings", pList);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping("/parkings/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		Object parking = new Parking();
		modelAndView.setViewName("form");
		modelAndView.addObject("parking", parking);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping("/parkings/{id}/edit")
	public ModelAndView edit(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView();
		Parking parking = new Parking();
		Optional<Parking> p = (Optional<Parking>) service.get(id);
		parking = p.get();
		parking.setCheck_out(parking.getCheck_out().replace(" ", "T"));
		parking.setCheck_in(parking.getCheck_in().replace(" ", "T"));
		modelAndView.setViewName("form");
		modelAndView.addObject("parking", parking);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping("/parkings/{id}/del")
	public ModelAndView del(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("del-form");
		modelAndView.addObject("parking_id", id);
		return modelAndView;
	}
	
	/*@CrossOrigin
	@RequestMapping(value="/parkings/{id}", method=RequestMethod.GET)
	public ModelAndView get(@PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView();
		Optional<Parking> p = (Optional<Parking>) service.get(id);
		
		List<Parking> pList = service.getAll();
		modelAndView.setViewName("index");
		modelAndView.addObject("parkings", pList);
		modelAndView.addObject("selectedParking", p);
		return modelAndView;
	}*/
	
	@CrossOrigin
	@RequestMapping(value="/parkings", method=RequestMethod.POST,
	consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, 
    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ModelAndView store(@ModelAttribute("parking") Parking parking){
		ModelAndView modelAndView = new ModelAndView();
		
		Parking p = service.store(parking);
		List<Parking> pList = service.getAll();
		modelAndView.setViewName("index");
		modelAndView.addObject("parkings", pList);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping(value="/parkings/{id}", method=RequestMethod.PUT)
	public ModelAndView update(@ModelAttribute("parking") Parking parking, @PathVariable("id") long id){
		ModelAndView modelAndView = new ModelAndView();
		Parking p = service.store(parking);
		List<Parking> pList = service.getAll();
		modelAndView.setViewName("index");
		modelAndView.addObject("parkings", pList);
		return modelAndView;
	}
	
	@CrossOrigin
	@RequestMapping(value="/parkings/delete/{id}", method=RequestMethod.POST)
	public RedirectView delete(@PathVariable("id") long id) {
		service.delete(id);
		return new RedirectView("/parkings");
	}
	
}
