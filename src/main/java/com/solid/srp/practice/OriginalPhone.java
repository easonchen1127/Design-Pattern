package com.solid.srp.practice;

public class OriginalPhone {
    private final String phoneType;
    public OriginalPhone(String phoneType)
    {
        if(phoneType == null)
            throw new IllegalArgumentException("Null Phone Type");
        this.phoneType = phoneType;
    }

    public void call()
    {
        System.out.println("Calling from " + phoneType);
    }

    public void message()
    {
        System.out.println("Sending message from " + phoneType);
    }

    public void browse()
    {
        System.out.println("Browsing from " + phoneType);
    }
}
