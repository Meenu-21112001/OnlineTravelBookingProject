package com.travel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.travel.entity.HotelBooking;

@Repository
public interface HotelBookingRepository  extends JpaRepository<HotelBooking, Integer>,IHotelBookingCostumRepository
{

	List<HotelBooking> getHotelByCost(int cost);
	HotelBooking getHotelByHotelName(String hotelName);

}
