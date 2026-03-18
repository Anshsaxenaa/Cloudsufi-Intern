package com.api;

public class Main {

    public static void main(String[] args) {

        Apiclient api = new Apiclient();

        try {

            api.getObjects();
            api.createObject();
            api.updateObject("ff8081819cd4022c019d004533664515");
            api.patchObject("ff8081819cd4022c019d004533664515");
            api.deleteObject("ff8081819cd4022c019d004533664515");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
