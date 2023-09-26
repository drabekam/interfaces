import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;




public class ShortLister {
    public static void main(String[] args) {

        JFileChooser fileChooser = new JFileChooser();


        FileNameExtensionFilter textFilter = new FileNameExtensionFilter("Text Files", "txt");
        fileChooser.setFileFilter(textFilter);


        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();


            List<String> shortWords = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                while ((line = reader.readLine()) != null) {

                    String[] words = line.split("\\s+"); // found this while researching this looks for whitespace


                    for (String word : words) {
                        if (new ShortWordFilter().accept(word)) {
                            shortWords.add(word);
                        }
                    }
                }

                if (!shortWords.isEmpty()) {
                    System.out.println("Short words in the file:");
                    for (String shortWord : shortWords) {
                        System.out.println(shortWord);
                    }
                } else {
                    System.out.println("No short words found in the file.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("No file selected.");
        }
    }
}
