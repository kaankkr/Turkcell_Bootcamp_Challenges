package com.turkcell.TeknikServis.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Service;

import com.turkcell.TeknikServis.model.Booking;
import com.turkcell.TeknikServis.repo.BookingRepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookingService
{
	private BookingRepo bookingRepo;

	private EntityManager entityManager;

	public void refresh(Booking booking)
	{
		entityManager.refresh(booking);
	}

	public Booking createBooking(Booking booking)
	{
		LocalDate someDate = createBookingDate(booking.getSERVICE().getDURATION());
		booking.setBOOKINGDATE(someDate);
		booking = bookingRepo.saveAndFlush(booking);
		entityManager.clear();
		booking = bookingRepo.findById(booking.getID()).get();
		
		return booking;
	}

	public Booking getByID(Long id)
	{
		return bookingRepo.findById(id).orElse(null);
	}

	public void deleteByID(Long id)
	{
		bookingRepo.deleteById(id);
	}

	public List<Booking> getAllByDateAsc()
	{
		return bookingRepo.OrderByBOOKINGDATEAsc();
	}

	public List<Booking> OrderByBOOKINGDATEDesc()
	{
		return bookingRepo.OrderByBOOKINGDATEDesc();

	}

	public List<Booking> findByBookingLikeName(String name)
	{
		return bookingRepo.findByBookingLikeName(name);

	}

	public List<Booking> getAll()
	{
		return bookingRepo.findAll();
	}

	private LocalDate createBookingDate(int serviceDuration)
	{
		LocalDate bookingDate = LocalDate.now();
		int dailyWorkHours = 0;
		do
		{
			dailyWorkHours = serviceDuration;
			bookingDate = bookingDate.plusDays(1L);
			List<Booking> bookings = bookingRepo.searchByBOOKINGDATE(bookingDate);
			for (Booking booking : bookings)
			{
				dailyWorkHours += booking.getSERVICE().getDURATION();
			}
		}
		while (dailyWorkHours > 10);
		
		return bookingDate;
	}

	public Booking updateIsDone(Long id)
	{
		Booking booking = bookingRepo.findById(id).get();
		booking.setISDONE(true);
		
		return bookingRepo.save(booking);
	}
}
