package com.travel.entity.controller;

import java.util.List;
//import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.HotelBooking;
import com.travel.service.HotelBookingService;

@RestController
@RequestMapping("/admin/bookhotel")
public class AdminControllerHotelBooking {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	// for security and surveillance purpose

	@Autowired
	HotelBookingService hotelbookingservice;

	public AdminControllerHotelBooking() {
		System.out.println("\n---------------Inside Constructor-------------------- \n" + this);
	}

	@GetMapping("/welcome")
	public String welcome() 
	{
		return "welcome to HotelBooking";
	}

	@PostMapping("/addhotel") // localhost:8011/admin/bookhotel/addhotel(POST)
	public ResponseEntity<String> addUser(@RequestBody HotelBooking hotelBooking) {
		try {
			log.info("Inside try of AddHotel ");
			HotelBooking savedhotel = hotelbookingservice.insertHotelBookingUser(hotelBooking);
			String responseMsg = savedhotel.getHotelName();
			return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
		} catch (Exception e) {
			String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
			return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/viewHotel") // localhost:8011/admin/bookhotel/viewHotel
	public List<HotelBooking> getAllHotel() {
		try {
			List<HotelBooking> allExtractedHotel = hotelbookingservice.getAllHotelBooking();

			return allExtractedHotel;

		} catch (Exception e)
		{
			System.out.println(e);

		}
		return null;
	}

	@GetMapping("/hotelByName/{searchHotelName}") /// localhost:8011/admin/bookhotel/hotelByName/{given_Hotel_NAme}
	public HotelBooking abc1(@PathVariable String searchHotelName) throws Exception 
	{
		return hotelbookingservice.getHotelByHotelName(searchHotelName);
	}

	@GetMapping("/hotelByCost/{cost}") /// admin/bookhotel/hotelByCost/{given_Hotel_Cost}
	public List<HotelBooking> abc2(@PathVariable int cost) throws Exception 
	{
		log.error("Give Valid Integer ");
		return hotelbookingservice.getHotelByCost(cost);
	}
	/*@GetMapping("/hotelById/{hotelId}") /// admin/bookhotel/hotelByCost/{given_Hotel_Cost}
	public HotelBooking getUserById(@PathVariable int hotelId) throws Exception 
	{
		
		return hotelbookingservice.getUserById(hotelId);
	}*/
	
	
	/*@PutMapping("/update/{flightBookingId}")
	public FlightBooking updateFlightBooking(@PathVariable int flightBookingId, @RequestBody FlightBooking flightBookingDetails) throws Exception {
		flightBookingService.getFlightsByFlightBookingId(flightBookingId);
		flightBookingDetails.setFlightBookingId(flightBookingId);
		FlightBooking updateFlightBooking = flightBookingService.insertFlightBooking(flightBookingDetails);
		return updateFlightBooking;
	}
	
	@PutMapping("/update/{byHotelId}")
	public HotelBooking updateHotelBooking(@PathVariable int hotelId, @RequestBody HotelBooking hotelBookingDetails) throws Exception 
	{
		hotelbookingservice.getUserById(hotelId);
		hotelbookingservice.se
		HotelBooking updateFlightBooking = flightBookingService.insertFlightBooking(flightBookingDetails);
		return updateFlightBooking;
	}
*/
	@DeleteMapping("/delete/{hotelId}") /// localhost:8011/admin/bookhotel/hotelId/ ---------------->Delete
	public String deleteUser(@PathVariable int hotelId) 
	{
		try 
		{
			hotelbookingservice.delete(hotelId);
			System.out.println("Successfully Deleted the Credentials ");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "Completed Delete Operation";
	}

}
