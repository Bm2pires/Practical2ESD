
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bredan
 */
public class Histogram {
        ArrayList<Integer> integers;
    HashMap<Integer, Integer> intFrequency;

    public Histogram(ArrayList<Integer> integers) {
        this.integers = integers;

        this.intFrequency = new HashMap<>();

        for (Integer x : this.integers) {
            Integer quotient = x / 10;
            Integer j = intFrequency.getOrDefault(quotient, 0);
            this.intFrequency.put(quotient, j + 1);
        }
    }

    public void printHistogram() {
        for (int i = 1; i < 100; i += 10) {
            int quotient = i / 10;
            int freq = this.intFrequency.getOrDefault(quotient, 0);
            char[] chars = new char[freq];
            Arrays.fill(chars, '*');
            String result = new String(chars);
            System.out.printf("%2d - %3d | %s %n", i, i + 9, result);
        }
    }
}
