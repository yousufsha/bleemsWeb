package utilityFiles;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;

public class PriceUtils {

    public static boolean isSortedLowToHigh(List<WebElement> priceElements) {

        List<Double> actualPrices = new ArrayList<>();

        // Extract prices
        for (WebElement price : priceElements) {

            String cleanedPrice = price.getText()
                    .replaceAll("[^0-9.]", "");

            if (!cleanedPrice.isEmpty()) {
                actualPrices.add(Double.parseDouble(cleanedPrice));
            }
        }

        // Create sorted copy
        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        return actualPrices.equals(expectedPrices);
    }
}
