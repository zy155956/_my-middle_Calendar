package service.JAXBimpl;

import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.concurrent.Callable;

/**
 * Created by Nike on 10.07.2017.
 */
public class ReadFile implements Callable<Object> {

    private File file;
    private Unmarshaller unmarshaller;

    public ReadFile(File file, Unmarshaller unmarshaller) {
        this.file = file;
        this.unmarshaller = unmarshaller;
    }

    @Override
    public Object call() throws Exception {
        if (file == null || unmarshaller == null) return null;
        return unmarshaller.unmarshal(file);
    }
}
