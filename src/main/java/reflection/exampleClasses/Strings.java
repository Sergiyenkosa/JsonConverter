package reflection.exampleClasses;

import reflection.annotations.JsonValue;

import java.util.Date;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Strings {
    private String string1;
    @JsonValue(name = "finalString")
    private final String string2;
    @JsonValue(name = "jsonValueString")
    private String string3;

    public Strings() {
        this.string2 = String.valueOf(new Date().getTime());
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
    }
}
