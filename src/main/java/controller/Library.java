package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Library {
    public static <T> List<T> getMixedCollection(final Collection<T> items) {
        List<T> result = new ArrayList<>(items);
        final int totalCount = result.size();

        int changes = 0;
        Random random = new Random();
        while (changes < totalCount) {
            int first = random.nextInt(totalCount);
            int second = random.nextInt(totalCount);

            T temp = result.get(first);
            result.set(first, result.get(second));
            result.set(second, temp);

            changes++;
        }

        return result;
    }

    public static <T> T getRandom(final Collection<T> items) {
        List<T> list = getMixedCollection(items);

        return list.get(0);
    }
}