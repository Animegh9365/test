package com.testapp.test.service;
import java.util.List;

import org.springframework.stereotype.Service;
/**
 * numberSortingService
 */
@Service
public class NumberSortingService {

    public void bubbleSort(List<Integer> arr){
        int n = arr.size();

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr.get(j) > arr.get(j+1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j +1, temp);
                }
            }
        }
    }
    
}