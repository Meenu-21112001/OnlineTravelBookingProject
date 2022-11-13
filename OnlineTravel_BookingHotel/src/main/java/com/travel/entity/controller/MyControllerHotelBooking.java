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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.HotelBooking;
import com.travel.service.HotelBookingService;



@RestController
@RequestMapping("/admin/bookhotel")     
public class MyControllerHotelBooking 
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	//Obj of Logger Class is assinged to LogerFactory class of method getlogger having parameter as getClass Method
	// important data points for security and surveillance purpose 
	
	@Autowired
	HotelBookingService hotelbookingservice;
     
	public MyControllerHotelBooking()
	{
		System.out.println("\n---------------Inside Constructor-------------------- \n" + this);
	}
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome to HotelBooking";
	}
	
	@PostMapping("/addhotel")                 //  /admin/bookhotel/addhotel(POST)
		public ResponseEntity<String> addUser(@RequestBody HotelBooking hotelBooking) {
			try 
			{
				log.info("Inside try of AddHotel ");
				HotelBooking savedhotel = hotelbookingservice.insertHotelBookingUser(hotelBooking);
				String responseMsg = savedhotel.getHotelName();
				return new ResponseEntity<String>(responseMsg, HttpStatus.OK);
			} 
			catch (Exception e) 
			{
				String errorMsg = "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
				return new ResponseEntity<String>(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		@GetMapping("/hotel")
		public List<HotelBooking> getAllHotel() 
		{
			try 
			{
				List<HotelBooking> allExtractedHotel = hotelbookingservice.getAllHotelBooking();

				return allExtractedHotel;

			} 
			catch (Exception e)
			{
				System.out.println(e);

			}

			return null;
		}
		
		@GetMapping("/hotelByName/{searchHotelName}")                                              ///admin/bookhotel/hotelByName/{given_Hotel_NAme}
		public List<HotelBooking> abc1(@PathVariable String searchHotelName)throws Exception
		{  
			log.debug(searchHotelName);
			return hotelbookingservice.getHotelByHotelName(searchHotelName);
		}
		
		/*@GetMapping("/hotelByCost/{serachHotelByCost}")                                             ///admin/bookhotel/hotelByCost/{given_Hotel_Cost}
		public List<HotelBooking> abc2(@PathVariable int searchCostPerDay)throws Exception
		{
			log.error("Give Valid Integer ");
			return hotelbookingservice.getHotelByCost(searchCostPerDay);
		}*/
		
		//@RequestMapping(value = "/remove",method = RequestMethod.POST)
		@DeleteMapping("/userid/{searchUserId}")
		public void deleteUser(@PathVariable int searchUserId)
		{
			try 
			{
				hotelbookingservice.delete(searchUserId);
				System.out.println("Successfully Deleted the Credentials ");
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
		}
	
    /*@RequestMapping(value = "/fruit/remove", method = RequestMethod.POST)
    public String removeAd(Fruit fruit) {
        fruitManager.removeFruit(fruit);
        return "/list";
    }*/

}