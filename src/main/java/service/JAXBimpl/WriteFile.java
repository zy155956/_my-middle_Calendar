package service.JAXBimpl;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/**
 * Created by Nike on 10.07.2017.
 */
public class WriteFile implements Runnable {
    //private static final Logger logger = Logger.getLogger(WriteFile.class);

    Marshaller marshaller;
    File file;
    Object obj;

    public WriteFile(Marshaller marshaller, File file, Object obj) {
        this.marshaller = marshaller;
        this.file = file;
        this.obj = obj;
    }

    @Override
    public void run() {
        try {
            marshaller.marshal(obj, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
