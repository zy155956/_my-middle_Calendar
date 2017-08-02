package notJUnit.testXmlJson.json;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nike on 01.08.2017.
 */

@JsonAutoDetect
public class TestJackson {
    @JsonProperty
    @JsonDeserialize(as=ArrayList.class)
    private List<String> listString;
    @JsonProperty
    private ArrayList<TestJackson2> listJaxon;

    {
        listString = new ArrayList<>();
        listJaxon = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listString.add("numb="+i);
        }
    }

    public void setListJaxon(){
        for (int a = 0; a < 5; a++) {
            listJaxon.add(new TestJackson2());
        }
    }

    //Обязательно помечаем класс аннотацией
    //Можем серриализовать без аннотаций(Паблик поля, или прайвет поля с геттер/сеттер), з аннотациями(любые поля).
    @JsonProperty
    private String str1 = "str1";
    //@JsonProperty
    public int numb1 = 11;
    //@JsonProperty
    private boolean bool = true;
    @JsonProperty
    private TestJackson2 jaxon = new TestJackson2();

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }

    @Override
    public String toString() {
        return "TestJackson{" +
                "listString=" + listString +
                ", listJaxon=" + listJaxon +
                ", str1='" + str1 + '\'' +
                ", numb1=" + numb1 +
                ", bool=" + bool +
                ", jaxon=" + jaxon +
                '}';
    }
}
