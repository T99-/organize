package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40AM - March 14th, 2017.

public class Main {

    public static void main(String[] args){

        Window window = new Window("organize");

        Thread windowTime = new Thread(window);

        window.showWindow();

        windowTime.start();

    }

}
