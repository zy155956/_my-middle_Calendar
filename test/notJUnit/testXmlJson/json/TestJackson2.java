package notJUnit.testXmlJson.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Nike on 01.08.2017.
 */
//Если неуказываем в етой аннотации никакие свойства, тогда она и необязательная
//@JsonAutoDetect
public class TestJackson2 {
    //@JsonProperty
    public String first = "first";
    @JsonProperty
    private String second = "second";
}
