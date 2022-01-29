import java.io.*;

/**
 * Created by Piotr Szydlowski on 23.01.2022
 */
public class OrderBackup {

    private Writer writer;

    public Writer getWriter() {
        return writer;
    }

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    void backupOrder(Order order) throws IOException {
        writer.append(order.toString());
    }

    void closeFile() throws IOException {
        writer.close();
    }
}
