package solution;

import java.io.*;

/**
 * Created by carlos on 15/03/16.
 */
public class ReadFile {

    private BufferedReader buffer = null;

    public ReadFile(String path) throws FileNotFoundException {
        File file = new File(path);
        buffer = new BufferedReader(new FileReader(file));
    }

    public String getline() throws IOException {
        String line = buffer.readLine();
        return line.trim();
    }
}
