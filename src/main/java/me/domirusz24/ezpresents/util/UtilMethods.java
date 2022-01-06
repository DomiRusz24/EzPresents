package me.domirusz24.ezpresents.util;

import java.util.Map;
import java.util.Random;

public class UtilMethods extends me.domirusz24.plugincore.util.UtilMethods {
    public UtilMethods(me.domirusz24.plugincore.util.UtilMethods utilMethods) {
        super(utilMethods);
    }



    public static <E> E getWeightedRandom(Map<E, Double> weights, Random random) {
        E result = null;
        double bestValue = Double.MAX_VALUE;

        for (E element : weights.keySet()) {
            double value = -Math.log(random.nextDouble()) / weights.get(element);

            if (value < bestValue) {
                bestValue = value;
                result = element;
            }
        }

        return result;
    }
}
