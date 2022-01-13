package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.io.File;
import java.time.Duration;
import java.util.Objects;

public class Base {
    protected static WebDriver driver;
    public long waiting_time = 40;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waiting_time)); //Настройка ожидания

    public static String getFileExtension(File directory) {
        File[] fileList = directory.listFiles();
        String fileName = fileList[0].getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
            return fileName.substring(fileName.lastIndexOf(".") + 1);
            // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";
    }

    public static long getFileSize(File directory) {
        File[] fileList = directory.listFiles();
        return fileList[0].length();
    }

    public static String getFileName(File directory) {
        File[] fileList = directory.listFiles();
        return fileList[0].getName();
    }

    public void waitForExtensionEqualsTo(File directory, String type) {
        wait.until(checkForExtensionIs(directory, type));
    }

    private static ExpectedCondition<Boolean> checkForExtensionIs(File directory, String type) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                if (getFileExtension(directory).equals(type)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        };
    }
    public void waitForFolderMoreThan(File directory) {
        wait.until(checkForFolderNotEmpty(directory));
    }

    private static ExpectedCondition<Boolean> checkForFolderNotEmpty(File directory) {
        return new ExpectedCondition<Boolean>() {
            @Nullable
            @Override
            public Boolean apply(@Nullable WebDriver webDriver) {
                if (folderSize(directory) > 0) {
                    return true;
                }
                else {
                    return false;
                }
            }
        };
    }
    private static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}