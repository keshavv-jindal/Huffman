

public class Main {
    public static void main(String[] args) {
        String[] options = {"Compress", "Decompress"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Huffman Compression Tool",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) return;

        File selectedFile = fileChooser.getSelectedFile();

        try {
            if (choice == 0) {
                new HuffmanEncoder().compress(selectedFile);
            } else {
                new HuffmanDecoder().decompress(selectedFile);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package except;
import java.util.*;
public static except2 {
    public static void main(string   1)
}
