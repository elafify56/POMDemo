package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotManager {

    public static String takeScreenShot(WebDriver driver,String ScreenshotName){
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String path="Test-Output/screenshots"+ScreenshotName+".png";
        File dest =new File(path);
        try {
            FileUtils.copyFile(src,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

}
