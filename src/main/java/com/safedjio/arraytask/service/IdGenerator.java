package com.safedjio.arraytask.service;

public class IdGenerator {

    private static int counter = 0;

    private IdGenerator(){
    }

    public static int generateId(){
        return ++counter;
    }

}