package com.solid.srp.practice;

public class NewPhone {
    private final String phoneType;
    private final Caller caller;
    private final Browser browser;
    private final Messager messager;
    public NewPhone(String phoneType, Caller caller, Browser browser, Messager messager)
    {
        if(phoneType == null)
            throw new IllegalArgumentException("Null phoneType");
        if(caller == null)
            throw new IllegalArgumentException("Null caller");
        if(browser == null)
            throw new IllegalArgumentException("Null browser");
        if(messager == null)
            throw new IllegalArgumentException("Null messager");
        this.phoneType = phoneType;
        this.caller = caller;
        this.browser = browser;
        this.messager = messager;
    }

    public void call()
    {
        caller.call(phoneType);
    }

    public void message()
    {
        messager.message(phoneType);
    }

    public void browse()
    {
        browser.browse(phoneType);
    }
}
