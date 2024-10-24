package lab1app.tasks;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersFinder {
    public List<Integer> findPrimeNumbers(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[n * 10];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p < isPrime.length; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i < isPrime.length; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        for (int i = 2; primes.size() < n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}