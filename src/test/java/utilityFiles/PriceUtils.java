package utilityFiles;

import java.util.List;

import org.openqa.selenium.WebElement;

public class PriceUtils {

    public static boolean isSortedLowToHigh(List<WebElement> priceElements) {

        if (priceElements.size() < 6) {
            throw new IllegalArgumentException("At least 6 products are required.");
        }

        for (int i = 2; i < 5; i++) { // 3rd to 6th product

            double currentPrice = extractPrice(priceElements.get(i));
            double nextPrice = extractPrice(priceElements.get(i + 1));

            if (currentPrice > nextPrice) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSortedHighToLow(List<WebElement> priceElements) {

        if (priceElements.size() < 6) {
            throw new IllegalArgumentException("At least 6 products are required.");
        }

        for (int i = 2; i < 5; i++) { // 3rd to 6th product

            double currentPrice = extractPrice(priceElements.get(i));
            double nextPrice = extractPrice(priceElements.get(i + 1));

            if (currentPrice < nextPrice) {
                return false;
            }
        }

        return true;
    }

    private static double extractPrice(WebElement priceElement) {

        String cleanedPrice = priceElement.getText()
                .replaceAll("[^0-9.]", "");

        return Double.parseDouble(cleanedPrice);
    }
}