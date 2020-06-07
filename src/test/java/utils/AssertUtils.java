package utils;

import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;

import java.util.List;

import static utils.AppiumUtils.waitUtils;

public class AssertUtils {
    public static void assertListEquals(List actualList, List expectedList, String listName) {
        assertListContains(actualList, expectedList, listName);
        Assert.assertEquals(actualList.size(), expectedList.size(),
                "Value count in list" + listName + "  didn't match. \nExpected list values:  " + expectedList + ", \nActual List values:  " + actualList);
    }
    public static void assertListEqualsWithOrder(List actualList, List expectedList, String listName) {
        assertListEquals(actualList, expectedList, listName);
        Assert.assertEquals(actualList, expectedList,
                "List order didn't match, \nExpected: " + expectedList + "\nActual: " + actualList);
    }
    public static void assertListContains(List actualList, List expectedList, String listName) {
        for (Object expectedValue : expectedList) {
            Assert.assertTrue(actualList.contains(expectedValue),
                    "Value (" + expectedValue + ") is not present in List '" + listName + "'. \nActual list values: "
                            + actualList + "\nExpected list values: " + expectedList);
        }
    }
    public static void assertListNotContains(List actualList, List expectedList, String listName) {
        for (Object expectedValue : expectedList) {
            Assert.assertTrue(!actualList.contains(expectedValue), "Value (" + expectedValue + ") is present in List '"
                    + listName + "'. \nActual list values: " + actualList + "\nExpected list values: " + expectedList);
        }
    }

    /*** This will check whether element is displayed on UI or not** @param element*@return*/
    public static boolean isElementDisplayed(AndroidElement element) {
        waitUtils.staticWait(3000);
        boolean isPresent = false;
        try {
            element.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }

        return isPresent && element.isDisplayed();
    }
    public static boolean isElementDisplayed(IOSElement element) {
        waitUtils.staticWait(3000);
        boolean isPresent = false;
        try {
            element.isDisplayed();
            isPresent = true;
        } catch (Exception e) {
            isPresent = false;
        }

        return isPresent && element.isDisplayed();
    }
}
