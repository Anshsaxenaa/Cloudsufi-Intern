package com.api;

public class Main {

    public static void main(String[] args) {

        Apiclient api = new Apiclient();

        try {

            api.getObjects();
            api.createObject();
            api.updateObject("7");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
