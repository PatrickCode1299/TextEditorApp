package application;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.MenuBar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class MainController {
@FXML
public MenuBar menubar;
@FXML
public TextArea textarea;
String text;
String plainText;
public void setTextAreaText(KeyEvent event) {
	text = textarea.getText();

    ArrayList<String> hold_typed_text=new ArrayList<>();
    hold_typed_text.add(text);
    plainText = String.join("", hold_typed_text);
    
}
public void saveTextAreaText(KeyEvent event) {
	 String directoryPath = "C:/Users/" + System.getProperty("user.name") + "/Documents/PatWriteApp";
	    ensureDirectoryExists(directoryPath);

    writeToFile(directoryPath,plainText);
}
private void ensureDirectoryExists(String directoryPath) {

    File directory = new File(directoryPath);


    if (!directory.exists()) {
        boolean created = directory.mkdirs();  // creates all necessary directories
        if (created) {
            System.out.println("Directory created: " + directoryPath);
        } else {
            System.out.println("Failed to create directory: " + directoryPath);
        }
    } else {
        System.out.println("Directory already exists: " + directoryPath);
    }
}


private void writeToFile(String directoryPath, String text) {
	int lowerBound = 1;
	int upperBound = 100000;
	//int randomNum = (int) (Math.random() * (upperBound - lowerBound + 1)) + lowerBound;
	String randomDirectoryName="/temporary.txt";
    String filePath = directoryPath + randomDirectoryName;

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {

        writer.write(text);
        System.out.println("Text written to file: " + filePath);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
