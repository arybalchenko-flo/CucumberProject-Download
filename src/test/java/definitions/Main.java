package definitions;

import Base.Base;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import util.WebDriverFactory;

import java.io.File;

import static variables.Variables.fileSize;

public class Main extends Base {
    MainPage main = new MainPage();
    private String fileName; //переменная для имени файла
    private String neededExtension; //переменная для расширения
    private final File path = new File(WebDriverFactory.downloadDirMac); //переменная для пути загрузки

    @And("File with filename {string} downloaded")
    public void fileWithFilenameDownloaded(String fileName) {
        this.fileName = fileName; //Назначение имени файла
    }

    @Given("I click on the download file with {string} extension")
    public void iClickOnTheDownloadFileWithExtension(String neededExtension) {
        this.neededExtension = neededExtension; //Передача необходимого расширения файла из шага
        main.clickDownload();
        waitForFolderMoreThan(path);
    }

    @And("Wait for download")
    public void waitForDownload(){
        waitForExtensionEqualsTo(path, this.neededExtension);
    }
//Проверка на расширение, можно убрать так как выше она уже происходит
    @And("File has correct extension")
    public void fileHasCorrectExtension() {
        String extension = getFileExtension(path);
        if (extension.equals(this.neededExtension)) { //проверка на наличие файла, размер файла и расширение файла
            System.out.println("File exist and has correct extension " + extension);
        }
        else {
            System.out.println("File extension check failed");
        }
    }

    @And("File has correct size")
    public void fileHasCorrectSize() {
        long size = getFileSize(path);
        if (size > fileSize) { //проверка на наличие файла, размер файла и расширение файла
            System.out.println("File exist and has size " + size);
        }
        else {
            System.out.println("File size check failed");
        }
    }

    @And("File has correct name")
    public void fileHasCorrectName() {
        if (getFileName(path).equals(this.fileName)) {
            System.out.println("File has correct name");
        }
        else {
            System.out.println("File name check failed");
        }
    }

    @Then("File downloaded successfully without problems")
    public void fileDownloadedSuccessfullyWithoutProblems() {
        System.out.println("File downloaded");
    }
}
