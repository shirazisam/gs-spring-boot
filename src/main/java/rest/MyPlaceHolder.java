package rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by shiraz on 19/12/2018.
 */
@JsonRootName("placeholder")
public class MyPlaceHolder implements Serializable {

    @JsonIgnore
    private final String id;

    private final String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public MyPlaceHolder(@JsonProperty(value = "name", required = true) String name) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
