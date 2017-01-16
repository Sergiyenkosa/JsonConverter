package reflection.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Nulls {
    private Strings s;

    private Integer i;

    private Double d;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Nulls nulls = (Nulls) o;

        if (s != null ? !s.equals(nulls.s) : nulls.s != null) return false;
        if (i != null ? !i.equals(nulls.i) : nulls.i != null) return false;
        return d != null ? d.equals(nulls.d) : nulls.d == null;
    }

    @Override
    public int hashCode() {
        int result = s != null ? s.hashCode() : 0;
        result = 31 * result + (i != null ? i.hashCode() : 0);
        result = 31 * result + (d != null ? d.hashCode() : 0);
        return result;
    }
}
