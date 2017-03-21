package com.t99sdevelopment;

// Created by Trevor Sears <trevorsears.main@gmail.com> @ 7:40AM - March 14th, 2017.

public class Main {

    private Window window = new Window("organize");

    private Thread windowTime = new Thread(window);

    public static void main(String[] args){

        Main main = new Main();

        main.startWindow();

    }

    public void startWindow(){

        window.showWindow();
        windowTime.start();

    }

    public Window getWindow(){

        return window;

    }

    public Thread getWindowTime(){

        return windowTime;

    }

}
