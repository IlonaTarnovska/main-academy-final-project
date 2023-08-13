package org.selenide.utils;

import java.text.Collator;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionUtils {

    public static <I, O> List<O> convert(List<I> input, Function<I, O> transform) {
        return input.stream().map(transform).collect(Collectors.toList());
    }

    public static List<String> sortAscString(List<String> input) {
        List<String> sorted = new ArrayList<>(input);
        Collator collator = Collator.getInstance(Locale.US);
        Collections.sort(sorted, collator::compare);
        return sorted;
    }

    public static List<String> sortDescString(List<String> input) {
        List<String> sorted = new ArrayList<>(input);
        Collator collator = Collator.getInstance(Locale.US);
        Collections.sort(sorted, (s1, s2) -> collator.compare(s2, s1));
        return sorted;
    }

    public static List<Float> sortAscFloat(List<Float> input) {
        List<Float> sorted = new ArrayList<>(input);
        Collections.sort(sorted, Float::compare);
        return sorted;
    }

    public static List<Float> sortDescFloat(List<Float> input) {
        List<Float> sorted = new ArrayList<>(input);
        Collections.sort(sorted, (f1, f2) -> Float.compare(f2, f1));
        return sorted;
    }

}
