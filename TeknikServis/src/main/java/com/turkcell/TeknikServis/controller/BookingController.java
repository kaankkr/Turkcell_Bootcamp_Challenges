package com.turkcell.TeknikServis.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.TeknikServis.model.Booking;
import com.turkcell.TeknikServis.service.BookingService;
import com.turkcell.TeknikServis.service.ServiceService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "booking")
@AllArgsConstructor
public class BookingController
{
	// final olup requeiredargsconstructor kullanılabilir
	private BookingService bookingService;
	private ServiceService serviceManager;
	
	@PostMapping(path = "save")
	public Booking save(@RequestBody Booking booking)
	{
		// {"service":{"id": 1}, "user" : {"id": 2}, "note" : "deneme3" }
		booking.setSERVICE(serviceManager.findById(booking.getSERVICE().getID()));
		return bookingService.createBooking(booking);

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable(name = "id") Long id)
	{
		bookingService.deleteByID(id);
		return ResponseEntity.ok("Başarı ile silindi");
	}
	
	@PutMapping("update/{id}")
	public Booking update(@PathVariable(name = "id") Long id)
	{
		return bookingService.updateIsDone(id);
	}
	
	@GetMapping(path = "getById/{id}")
	public Booking getById(@PathVariable(name = "id") Long id)
	{
		return bookingService.getByID(id);
	}
	
	@GetMapping("/getAll")
	public List<Booking> getAll(){
		return bookingService.getAll();
	}
	
	@GetMapping("/getAllByDateAsc")
	public List<Booking> getAllByDateAsc(){
		return bookingService.getAllByDateAsc();
	}
	
	@GetMapping("/getAllByDateDesc")
	public List<Booking> OrderByBOOKINGDATEDesc(){
		return bookingService.OrderByBOOKINGDATEDesc();
	}
	
	@GetMapping("/findByBookingLikeName")
	public List<Booking> findByBookingLikeName(String name) {
		return bookingService.findByBookingLikeName(name);
	}
}