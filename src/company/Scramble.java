package company;

/**
 * Created by jg101 on 10/24/16.
 */
import java.util.Random;

public class Scramble {
    private Random rand = new Random();

    public String keygen() {
        char a[] = new char[32];
        for (int i = 0; i < 32; i++) {
            a[i] = (char) (rand.nextInt((90 - 48) + 1) + 48);
        }
        return new String(a);
    }


    public String encrypt(String seed, String key) {
        int count = 0;
        char a[] = new char[seed.length()];

        for (int i = 0; i < seed.length(); i++) {
            a[i] = seed.charAt(i);
        }

        for (int i = 0; i < seed.length(); i++) {
            if (count > 31) {
                count = 0;
            }
            a[i] = (char) (a[i] * key.charAt(count));
            count++;
        }
        return new String(a);

    }

}

