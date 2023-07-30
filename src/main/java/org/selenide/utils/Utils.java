package org.selenide.utils;

public class Utils {

    public static Float convertPrice(String price) {
        String filtered = price.replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "");
        return Float.parseFloat(filtered);
    }

}
