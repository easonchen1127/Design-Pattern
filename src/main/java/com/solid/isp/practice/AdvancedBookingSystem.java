package com.solid.isp.practice;

import java.util.Date;

public class AdvancedBookingSystem extends SimpleBookingSystem{
    private IBookingCarHelper carHelper;
    private ITakeOutInsuranceHelper insuranceHelper;

    public AdvancedBookingSystem(IBookingHotelHelper hotelHelper,
                                 IBookingFlightHelper flightHelper,
                                 ISupportHelper supportHelper,
                                 IBookingCarHelper carHelper,
                                 ITakeOutInsuranceHelper insuranceHelper) {
        super(hotelHelper, flightHelper, supportHelper);
        if(carHelper == null)
            throw new IllegalArgumentException("carHelper is null");
        this.carHelper = carHelper;

        if(insuranceHelper == null)
            throw new IllegalArgumentException("insuranceHelper is null");
        this.insuranceHelper = insuranceHelper;
    }


    public void bookCar(String brand, String customer, Date date,  int numDays)
    {
        carHelper.bookCar(brand, customer, date, numDays);
    }
    public void takeOutInsurance(String customer, Date dateStart, Date dateEnd)
    {
        insuranceHelper.takeOutInsurance(customer, dateStart, dateEnd);
    }
}
