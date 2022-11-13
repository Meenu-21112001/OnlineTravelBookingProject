package com.travel.service;

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
	public List<HotelBooking> getHotelByHotelName(String hotelName) throws Exception 
	{
		List<HotelBooking> hotelbooking=hotelbookingRepository.findAll();
		
		if(hotelbooking==null)
		{
			throw new EntityNotFoundException(hotelName+"its NoT Available ");
		}
		else
		{
			return hotelbooking;
		}
		
	}

	/*@Override
	public List<HotelBooking> getHotelByCost(int costPerDay) throws Exception
	{
		List<HotelBooking> byCost=hotelbookingRepository.findAll();
		if(byCost==null)
		{
		  	throw new EntityNotFoundException(costPerDay+"Please Provide Valid NumBer Not A Characters");
		}
		else
		{
		return byCost;
		}
	}*/

	@Override
	public void delete(int searchUserId)
	{
		// TODO Auto-generated method stub
		hotelbookingRepository.deleteById(searchUserId);
		
	}
    
	/*@Override
	public HotelBooking getHotelByHotelName(String hotelName) throws Exception
	{
				
		HotelBooking hotelUserByName = hotelbookingRepository.getHotelByHotelName(hotelName);

				if ( hotelUserByName== null) 
				{
					throw new EntityNotFoundException(hotelName + " not available in the database");
				} 
				else
				{
					return hotelUserByName;
				}
		
		
	}*/
	

}
