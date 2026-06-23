package utilityFiles;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.*;

public class CookieManager {

    private static final String COOKIE_FILE = "cookies.data";

    public static void saveCookies(WebDriver driver) throws Exception {

        Set<Cookie> cookies = driver.manage().getCookies();

        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(COOKIE_FILE));

        oos.writeObject(new ArrayList<>(cookies));
        oos.close();
    }

    @SuppressWarnings("unchecked")
    public static void loadCookies(WebDriver driver) throws Exception {

        File file = new File(COOKIE_FILE);

        if (!file.exists()) {
            return;
        }

        ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(file));

        List<Cookie> cookies =
                (List<Cookie>) ois.readObject();

        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }

        ois.close();
    }
}