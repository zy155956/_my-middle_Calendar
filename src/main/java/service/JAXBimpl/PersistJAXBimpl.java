package service.JAXBimpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Nike on 09.07.2017.
 */
public class PersistJAXBimpl {
    //private static final Logger logger = Logger.getLogger(WriteFile.class);

    private static ExecutorService pool = Executors.newFixedThreadPool(3);
    private JAXBContext context;
    private boolean flag = false;

    public void marshul(Object obj, Class[] classes, File file)throws JAXBException {
        context = JAXBContext.newInstance(classes);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        pool.execute(new WriteFile(marshaller, file, obj));
        flag = true;
    }


    public Object unmarshul(File file)throws JAXBException, ExecutionException, InterruptedException {
        if (context == null || !flag) return null;
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return pool.submit(new ReadFile(file, unmarshaller)).get();
    }

    public void removeFile(File file){
        if (file != null) pool.execute(new RemoveFile(file));
    }

    public static void shutDown(){
        pool.shutdown();
    }
}
