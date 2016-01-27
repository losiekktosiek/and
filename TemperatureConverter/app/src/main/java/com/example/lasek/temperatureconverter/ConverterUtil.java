package com.example.lasek.temperatureconverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Lasek on 1/23/2016.
 */
public class ConverterUtil {
    // converts to bitcoin
    // 0 - zloty
    // 1 - bitcoin
    // 2 - euro

    public static float convertToBitcoin(float zloty, float kurs) {

            return (zloty*kurs);

    }

    // converts to zloty
    public static float convertToZloty(float bitcoin,float kurs) {
            return (bitcoin/kurs);

    }
}
