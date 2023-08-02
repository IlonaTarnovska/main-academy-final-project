package org.selenide.utils;

import java.util.List;

public class Utils {

    public static Float convertPrice(String price) {
        String filtered = price.replaceAll("\\$", "")
                .replaceAll("€", "")
                .replaceAll("£", "");
        return Float.parseFloat(filtered);
    }

    public static Float convertDiscount(String discount) {
        String filtered = discount.replaceAll("-", "")
                .replaceAll("%", "");
        return Float.parseFloat(filtered);
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

}
