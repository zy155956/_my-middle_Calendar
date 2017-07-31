package service.JAXBimpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Nike on 10.07.2017.
 */
public class RemoveFile implements Runnable {
    private File file;

    public RemoveFile(File file) {
        this.file = file;
    }

    @Override
    public void run() {
        if (file != null){
            try {
                Files.delete(Paths.get(file.toURI()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
