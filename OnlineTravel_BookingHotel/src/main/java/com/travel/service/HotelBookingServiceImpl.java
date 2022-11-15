package com.travel.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travel.entity.HotelBooking;
import com.travel.repository.HotelBookingRepository;


@Service
public class HotelBookingServiceImpl implements HotelBookingService 
{

	@Autowired
	HotelBookingRepository hotelbookingRepository;
	
	@Transactional
	@Override
	public HotelBooking insertHotelBookingUser(HotelBooking hotelbooking) throws Exception
	{
		
	   HotelBooking savedUser =  hotelbookingRepository.save(hotelbooking);  
	  
		if(savedUser != null)
		{
			return savedUser;
		}
		else
			return null;
		
	}

	@Override
	public List<HotelBooking> getAllHotelBooking() throws Exception 
	{
			List<HotelBooking> allUsers =  hotelbookingRepository.findAll();
			return allUsers;
	}

	@Override
	public HotelBooking getHotelByHotelName(String hotelName) throws Exception 
	{
		HotelBooking hotelbooking=hotelbookingRepository.getHotelByHotelName(hotelName);
		System.out.println("Inside getHotelByName Method");
		
		if(hotelbooking==null)
		{
			throw new EntityNotFoundException(hotelName+"its NoT Available ");
		}
		else
		{
			return hotelbooking;
		}
		
	}

	@Override
	public String delete(int hotelId)
	{
		// TODO Auto-generated method stub
		hotelbookingRepository.deleteById(hotelId);
		return "Successfully Deleted ";
	}

	@Override
	public List<HotelBooking> getHotelByCost(int cost) throws Exception 
	{
		List<HotelBooking> byCost=hotelbookingRepository.getHotelByCost(cost);
		if(byCost==null)
		{
		  	throw new EntityNotFoundException(cost+"Please Provide Valid NumBer Not A Characters");
		}
		else
		{
		return byCost;
		}
	}

	/*@Override
	public HotelBooking getUserById(int hotelId)throws Exception
	{
		return hotelbookingRepository.getUserById(hotelId);
		
	
	}*/

	@Override
	public List<HotelBooking> CostByLowToHigh() throws Exception 
	{
		// TODO Auto-generated method stub
		List<HotelBooking> listByCost=hotelbookingRepository.findAll();
		Collections.sort(listByCost,new com.travel.sorting.CostByLowToHigh() );
		return listByCost;
	}

	@Override
	public HotelBooking addHotel() throws Exception 
	{
		// TODO Auto-generated method stub
		hotelbookingRepository.findAll();
		return null;
	}

	@Override
	public List<HotelBooking> CostByHighToLow() throws Exception 
	{
		List<HotelBooking> listByCost=hotelbookingRepository.findAll();
		Collections.sort(listByCost,new com.travel.sorting.CostByHighToLow() );
		return listByCost;
	}
	
	
 
	

}
