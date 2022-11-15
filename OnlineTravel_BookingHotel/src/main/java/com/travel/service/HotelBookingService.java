package com.travel.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.travel.entity.HotelBooking;



@Service
public interface HotelBookingService 
{

	public HotelBooking insertHotelBookingUser(HotelBooking hotelbooking)throws Exception;//to add details(PUT)
	public List<HotelBooking> getAllHotelBooking()throws Exception;//View Details(GET)

	public List<HotelBooking> getHotelByCost(int cost)throws Exception;
	public String delete(int hotelId);
	//public HotelBooking getUserById(int hotelId) throws Exception;	
	
    public  HotelBooking getHotelByHotelName(String hotelName)throws Exception;//Sort By Name(GET)
    
	public List<HotelBooking>CostByLowToHigh() throws Exception;
	public List<HotelBooking>CostByHighToLow() throws Exception;
	public HotelBooking addHotel() throws Exception;
	
}
