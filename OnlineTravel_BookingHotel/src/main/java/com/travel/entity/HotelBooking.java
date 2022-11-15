package com.travel.entity;



import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.mapping.PrimaryKey;

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
	private int hotelId;
	
	@NotNull(message = "Hotelname cannot be Null")
	@Size(min = 2,message = "Hotelname is not valid, should have more than 2 characters")
	private String hotelName;
	
	private int NoOfDays;
	private int cost;
	private int totalCost;
	private String startDate;
	private String endDate;
	private boolean bookingStatus;
	
	public String getHotelName() {
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
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
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
	public HotelBooking(String hotelName, int noOfDays, int cost, int totalCost, String startDate, String endDate) {
		super();
		this.hotelName = hotelName;
		NoOfDays = noOfDays;
		this.cost = cost;
		this.totalCost = totalCost;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public HotelBooking() 
	{
		super();
	}
	@Override
	public String toString() {
		return "HotelBooking [hotelId=" + hotelId + ", hotelName=" + hotelName + ", NoOfDays=" + NoOfDays + ", cost="
				+ cost + ", totalCost=" + totalCost + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(NoOfDays, cost, endDate, hotelId, hotelName, startDate, totalCost);
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
		return NoOfDays == other.NoOfDays && cost == other.cost && Objects.equals(endDate, other.endDate)
				&& hotelId == other.hotelId && Objects.equals(hotelName, other.hotelName)
				&& Objects.equals(startDate, other.startDate) && totalCost == other.totalCost;
	}
	public boolean isBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	
	
	
	

	
}
