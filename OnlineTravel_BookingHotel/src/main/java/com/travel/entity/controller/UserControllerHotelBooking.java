package com.travel.entity.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.HotelBooking;
import com.travel.service.HotelBookingService;

@RestController
@RequestMapping("/user/bookhotel")
public class UserControllerHotelBooking {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	HotelBookingService hotelbookingservice;

	public UserControllerHotelBooking() {
		System.out.println("\n---------------Inside User Constructor-------------------- \n" + this);
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome User";
	}

	@GetMapping("/hotel")
	public List<HotelBooking> getAllHotel() {
		try {
			List<HotelBooking> allExtractedHotel = hotelbookingservice.getAllHotelBooking();

			return allExtractedHotel;

		} 
		catch (Exception e)
		{
			System.out.println(e);

		}
		return null;
	}

	@GetMapping("/hotelByName/{hotelName}") /// user/bookhotel/hotelByName/{given_Hotel_NAme}
	public HotelBooking abc1(@PathVariable String hotelName) throws Exception 
	{
		log.debug(hotelName);
		return hotelbookingservice.getHotelByHotelName(hotelName);
	}
	@GetMapping("/hotelByCost/{cost}") /// user/bookhotel/hotelByCost/{given_Hotel_Cost}
	public List<HotelBooking> abc2(@PathVariable int cost) throws Exception {
		log.error("Give Valid Integer ");
		return hotelbookingservice.getHotelByCost(cost);
	}
	@GetMapping("/sortByLowCost/cost")       /// user/bookhotel/sortByLowCost/{cost}
	public List<HotelBooking> abc3() throws Exception
	{
		return hotelbookingservice.CostByLowToHigh();
		
	}
	@GetMapping("/sortByHighCost/cost")       /// user/bookhotel/sortByHighCost/{cost}
	public List<HotelBooking> abc4() throws Exception
	{
		return hotelbookingservice.CostByHighToLow();		
	}
}
