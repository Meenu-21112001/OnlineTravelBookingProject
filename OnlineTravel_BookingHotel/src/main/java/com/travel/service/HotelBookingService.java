package com.travel.service;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.travel.entity.HotelBooking;



@Service
public interface HotelBookingService 
{

	public HotelBooking insertHotelBookingUser(HotelBooking hotelbooking)throws Exception;//to add details(PUT)
	public List<HotelBooking> getAllHotelBooking()throws Exception;//View Details(GET)
	public List<HotelBooking> getHotelByHotelName(String hotelName)throws Exception;//Sort By Name(GET)
	//public List<HotelBooking> getHotelByCost(int costPerDay)throws Exception;
	public void delete(int searchUserId);	

}
