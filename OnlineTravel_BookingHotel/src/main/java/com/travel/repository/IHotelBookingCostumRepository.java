package com.travel.repository;

import org.springframework.stereotype.Repository;

import com.travel.entity.HotelBooking;

@Repository
public interface IHotelBookingCostumRepository 
{
	public   HotelBooking  getHotelByHotelName(String hotelName)throws Exception;
	//public HotelBooking getHotelByCost(int costPerDay)throws Exception;
}



	

