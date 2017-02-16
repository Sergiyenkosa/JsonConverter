package reflection.services.exampleClasses;

import reflection.annotations.JsonValue;

/**
 * Created by s.sergienko on 16.02.2017.
 */
public class IllegalName {
    @JsonValue(name = "@")
    private int i;
}
