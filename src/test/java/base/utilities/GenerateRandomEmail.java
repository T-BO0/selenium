package base.utilities;

import java.util.Random;

public class GenerateRandomEmail {

    public static String generateRandomEmail() {
        String[] domains = { "gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com" };
        String[] characters = { "abcdefghijklmnopqrstuvwxyz1234567890" };
        Random rand = new Random();

        StringBuilder sb = new StringBuilder();

        int length = rand.nextInt(10) + 5;
        for (int i = 0; i < length; i++) {
            sb.append(characters[0].charAt(rand.nextInt(characters[0].length())));
        }

        sb.append("@");

        sb.append(domains[rand.nextInt(domains.length)]);

        return sb.toString();
    }
}
