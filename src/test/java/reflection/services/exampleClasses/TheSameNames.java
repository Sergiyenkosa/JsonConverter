package reflection.services.exampleClasses;

import reflection.annotations.JsonValue;

/**
 * Created by Lubov on 07.01.2017.
 */
public class TheSameNames {
    private String s;

    @JsonValue(name = "s")
    private int i;
}
