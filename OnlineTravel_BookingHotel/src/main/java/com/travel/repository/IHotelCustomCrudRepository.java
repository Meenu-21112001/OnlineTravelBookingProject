package com.travel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.travel.entity.HotelBooking;

@Repository
public interface IHotelCustomCrudRepository extends CrudRepository<HotelBooking, Integer>
{
	public   HotelBooking  getHotelByHotelName(String hotelName)throws Exception;
}
