package com.travel.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.travel.entity.HotelBooking;
import com.travel.repository.HotelBookingRepository;


@SpringBootTest
class HotelBookingServiceImplTest
{
	@Mock
    HotelBookingRepository hotelBookingRepository;



   @InjectMocks
    HotelBookingServiceImpl hotelBookingService;
	
	

	
	@Test
	@DisplayName("Add All HotelBooking")
	void testInsertHotelBookingUser() throws Exception 
	{
		HotelBooking sampleInput=new HotelBooking("Riyaz Hotel",2,300,600,"11/12/22","12/12/22");
		HotelBooking expectedOutput=new HotelBooking("Riyaz Hotel",2,300,600,"11/12/22","12/12/22");
		BDDMockito.given(hotelBookingService.insertHotelBookingUser(sampleInput)).willReturn(expectedOutput);

	       // when
	        HotelBooking actualOutput = hotelBookingService.insertHotelBookingUser(sampleInput);
	        
	     // verify
	        assertEquals(expectedOutput, actualOutput);


	}

	@Test
	@DisplayName("Get all the users")
	void testGetAllHotelBooking() throws Exception 
	{
		
		HotelBooking booking1=new HotelBooking("Riyaz Hotel",2,300,600,"11/12/22","12/12/22");
		HotelBooking booking2=new HotelBooking("Riya Hotel",2,300,600,"11/12/22","12/12/22");
		List<HotelBooking> sampleOutput = new ArrayList<>();
		sampleOutput.add(booking1);
		sampleOutput.add(booking2);
		BDDMockito.given(hotelBookingService.getAllHotelBooking()).willReturn(sampleOutput);
		List<HotelBooking> actualOutput = hotelBookingService.getAllHotelBooking();
		assertNotNull(actualOutput);
		assertIterableEquals(sampleOutput, actualOutput);
	}

	@Test
	@Disabled
	void testGetHotelByHotelName() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetHotelByCost() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetUserById() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testCostByLowToHigh() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testAddHotel() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testCostByHighToLow() {
		fail("Not yet implemented");
	}

}
