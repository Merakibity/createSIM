package com.amazon.createSIM;

import java.awt.AWTException;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        createSIM cs = new createSIM();
        createSIM.createAndStartService();
        cs.createDriver();
        int l = cs.ketData();
        for (int i = 1; i <= l; i++) {
            cs.getData(i);
            try {
                cs.putData(i);
            } catch (InterruptedException | AWTException e) {
                e.printStackTrace();
            }
        }
        cs.quitDriver();
    }
}
