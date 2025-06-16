package com.solid.isp.practice;

import java.util.Date;

public class SimpleBookingSystem {
    private IBookingHotelHelper hotelHelper = null;
    private IBookingFlightHelper flightHelper = null;
    private ISupportHelper supportHelper = null;

    public SimpleBookingSystem(IBookingHotelHelper hotelHelper,
                               IBookingFlightHelper flightHelper,
                               ISupportHelper supportHelper)
    {
        if(hotelHelper == null)
            throw new IllegalArgumentException("hotelHelper is null");
        this.hotelHelper = hotelHelper;

        if(flightHelper == null)
            throw new IllegalArgumentException("flightHelper is null");
        this.flightHelper = flightHelper;

        if(supportHelper == null)
            throw new IllegalArgumentException("supportHelper is null");
        this.supportHelper = supportHelper;
    }

    public void bookHotel(String hotel, String customer, Date date, int numDays)
    {
        hotelHelper.bookHotel(hotel, customer, date, numDays);
    }

    public void bookFlight(String flight, String customer, Date departureDate, Date arrivedDate)
    {
        flightHelper.bookFlight(flight, customer, departureDate, arrivedDate);
    }

    public String getSupport(String customer, String message, Date issuedDate)
    {
       return supportHelper.getSupport(customer, message, issuedDate);
    }

}
