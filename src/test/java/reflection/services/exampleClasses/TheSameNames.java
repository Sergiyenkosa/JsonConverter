package reflection.services.exampleClasses;

import reflection.annotations.JsonValue;

/**
 * Created by Lubov on 07.01.2017.
 */
public class TheSameNames {
    private String s;

    @JsonValue(name = "s")
    private int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TheSameNames that = (TheSameNames) o;

        if (i != that.i) return false;
        return s != null ? s.equals(that.s) : that.s == null;
    }

    @Override
    public int hashCode() {
        int result = s != null ? s.hashCode() : 0;
        result = 31 * result + i;
        return result;
    }
}
