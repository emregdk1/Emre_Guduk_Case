package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshot {

    public static void takeScreenshot(WebDriver driver, String fileName) {
        try {
            // Screenshot alınır
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Hedef klasörü oluştur (yoksa)
            Path screenshotsDir = Paths.get("screenshots");
            if (!Files.exists(screenshotsDir)) {
                Files.createDirectories(screenshotsDir);
            }

            // Dosya yolu belirle ve kaydet
            Path dest = screenshotsDir.resolve(fileName + ".png");
            Files.copy(src.toPath(), dest);

            System.out.println("📸 Screenshot saved to: " + dest.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to save screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Screenshot error: " + e.getMessage());
        }
    }
}
