package com.travel.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotelUsers")
public class HotelBooking  
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int hotelNumber;
	
	private String hotelName;
	
	private int NoOfDays;
	private int costPerDay;
	private int totalCost;
	private String startDate;
	private String endDate;
	

	public String getHotelName() 
	{
		return hotelName;
	}


	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}


	public int getNoOfDays() {
		return NoOfDays;
	}


	public void setNoOfDays(int noOfDays) {
		NoOfDays = noOfDays;
	}


	public int getCostPerDay() {
		return costPerDay;
	}


	public void setCostPerDay(int costPerDay) {
		this.costPerDay = costPerDay;
	}


	public int getTotalCost() {
		return totalCost;
	}


	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public HotelBooking() 
	{
		super();
	}


	public HotelBooking(String hotelName, int noOfDays, int costPerDay, int totalCost, String startDate,
			String endDate) {
		super();
		this.hotelName = hotelName;
		NoOfDays = noOfDays;
		this.costPerDay = costPerDay;
		this.totalCost = totalCost;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	@Override
	public String toString() {
		return "HotelBooking [hotelNumber=" + hotelNumber + ", hotelName=" + hotelName + ", NoOfDays=" + NoOfDays
				+ ", costPerDay=" + costPerDay + ", totalCost=" + totalCost + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(NoOfDays, costPerDay, endDate, hotelName, hotelNumber, startDate, totalCost);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelBooking other = (HotelBooking) obj;
		return NoOfDays == other.NoOfDays && costPerDay == other.costPerDay && Objects.equals(endDate, other.endDate)
				&& Objects.equals(hotelName, other.hotelName) && hotelNumber == other.hotelNumber
				&& Objects.equals(startDate, other.startDate) && totalCost == other.totalCost;
	}


	
	

}
