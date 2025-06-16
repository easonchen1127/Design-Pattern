package com.solid.isp.practice;

import java.util.Date;

public interface IBookingSystem {
    public void bookHotel(String hotel, String customer, Date date, int numDays);
    public void bookFlight(String flight ,String customer, Date departureDate, Date arrivedDate);
    public void bookCar(String brand, String customer, Date date, int numDays);
    public void takeOutInsurance(String customer, Date dateStart, Date dateEnd);
    public String getSupport(String customer, String message, Date issuedDate);
}
