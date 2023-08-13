package org.selenide.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

public class Utils {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String round(Float value) {
        return df.format(value);
    }

    public static Float convertPrice(String price) {
        if (price.isEmpty())
            return 0f;

        String filtered = price.replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "");
        return Float.parseFloat(filtered);
    }

    public static Float convertDiscount(String discount) {
        if (discount.isEmpty())
            return 0f;

        String filtered = discount.replaceAll("-", "")
                .replaceAll("%", "");
        return Float.parseFloat(filtered);
    }

    public static Integer convertToInt(String integer) {
        if (integer.isEmpty())
            return 0;
        return Integer.parseInt(integer);
    }

    public static String removeDoneChar(String text) {
        return text.replace("\uE876", "");
    }

    public static WebElement findChild(WebElement root, String path) {
        WebElement element = null;
        try {
            element = root.findElement(By.xpath(path));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return element;
    }

    public static String findChildText(WebElement root, String path) {
        String text = "";
        WebElement child = findChild(root, path);
        if (child != null) {
            text = child.getText();
        }
        return text;
    }

}
