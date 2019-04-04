package com.vcs.project.service.utils;

public class ItemListUtils {

    private static int id = 0;

    public static int generateId() {
        return id++;
    }

}
