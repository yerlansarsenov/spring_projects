package org.example;

public class RockMusic implements Music{
    public void init() {
        System.out.println("onInit");
    }

    public void destroy() {
        System.out.println("onDestroy");
    }

    @Override
    public String getSong() {
        return "Thunderstruck";
    }


}
