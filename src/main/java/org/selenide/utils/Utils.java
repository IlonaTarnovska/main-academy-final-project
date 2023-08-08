package org.selenide.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Utils {

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

    public static  <T> boolean areSortEquals(List<T> list1, List<T> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }
        boolean isSortEquals = true;
        for (int i = 0; i < list1.size(); i++) {
            if(!list1.get(i).equals(list2.get(i))) {
                isSortEquals = false;
                break;
            }
        }
        return isSortEquals;
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
