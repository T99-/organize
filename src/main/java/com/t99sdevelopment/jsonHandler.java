package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 8:54AM - March 9th, 2017.

/**
 * All of this code was purely for experimental purposes, and will eventually be changed to reflect the interaction that
 * it will need to eventually do to set and get values from the JSON that stores user information. None of this is final
 * and as of now it serves no purpose within the program - the class is never referenced elsewhere.
 */

import org.json.JSONObject;
import java.io.StringWriter;

public class jsonHandler {

    public void jsonTest() {

        JSONObject testObject = new JSONObject();

        testObject.put("name", "testjsonstuff");
        testObject.put("testvalue", new Integer(5));

        System.out.println(testObject);

        StringWriter JSONStringWriter = new StringWriter();
        testObject.write(JSONStringWriter);

        String JSONText = JSONStringWriter.toString();
        System.out.println(JSONText);

        System.out.println(DateChanger.getDate());

    }

}
