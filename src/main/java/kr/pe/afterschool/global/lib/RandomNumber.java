package kr.pe.afterschool.global.lib;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Random;

@Component
public class RandomNumber {

    public int[] getArrayNumber(int size, int range) {
        Random random = new Random();

        int[] integerList = new int[size];
        for (int i = 0; i < size; i++) {
            integerList[i] = random.nextInt(range);
            for (int j = 0; j < i; j++) {
                if (integerList[i] == integerList[j]) {
                    i--;
                }
            }
        }
        return Arrays.stream(integerList).sorted().toArray();
    }
}
