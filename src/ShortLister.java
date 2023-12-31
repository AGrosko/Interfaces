import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import static java.lang.System.out;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import javax.swing.JFileChooser;


public class ShortLister {

    public static void main(String[] args) {

        JFileChooser chooser = new JFileChooser();

        File selectedFile;

        String rec = "";
        String[] seperated;
        int i = 0;

        ShortWordFilter filter = new ShortWordFilter();

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);
            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                // Finally we can read the file LOL!
                int line = 0;


                while(reader.ready())
                {
                    rec = reader.readLine();
                    line++;
                    seperated = rec.split(" ");

                    i = 0;
                    while (i < seperated.length){
                        if (filter.accept(seperated[i])){
                            System.out.println(seperated[i]);
                        }
                        i++;
                    }


                }
                reader.close(); // must close the file to seal it and flush buffer
                System.out.println("\n\nData file read!");
            }


        }

        catch (IOException e) {

            e.printStackTrace();
        }


    }
}
