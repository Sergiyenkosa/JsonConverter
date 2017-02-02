package reflection.services.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Merge3 {
    private Strings strings;
    private Nulls nulls;

    public Strings getStrings() {
        return strings;
    }

    public void setStrings(Strings strings) {
        this.strings = strings;
    }

    public Nulls getNulls() {
        return nulls;
    }

    public void setNulls(Nulls nulls) {
        this.nulls = nulls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merge3 merge3 = (Merge3) o;

        if (strings != null ? !strings.equals(merge3.strings) : merge3.strings != null) return false;
        return nulls != null ? nulls.equals(merge3.nulls) : merge3.nulls == null;
    }

    @Override
    public int hashCode() {
        int result = strings != null ? strings.hashCode() : 0;
        result = 31 * result + (nulls != null ? nulls.hashCode() : 0);
        return result;
    }
}
