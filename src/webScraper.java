import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class webScraper {
    public static void main(String[] unused) {
        System.out.println("Run");
    }

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static String wordCount(String website) {
        String hamlet = urlToString(website);
        String[] words = hamlet.split("[ ,./+;:\\[\\]\\']+");
        int wordCounter = 0;
        for(int i = 0; i < words.length; i++) {
            wordCounter++;
        }
        System.out.println(wordCounter);
        return hamlet;
    }
}