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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strings strings = (Strings) o;

        if (string1 != null ? !string1.equals(strings.string1) : strings.string1 != null) return false;
        if (!string2.equals(strings.string2)) return false;
        return string3 != null ? string3.equals(strings.string3) : strings.string3 == null;
    }

    @Override
    public int hashCode() {
        int result = string1 != null ? string1.hashCode() : 0;
        result = 31 * result + string2.hashCode();
        result = 31 * result + (string3 != null ? string3.hashCode() : 0);
        return result;
    }
}
