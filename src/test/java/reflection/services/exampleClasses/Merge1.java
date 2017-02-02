package reflection.services.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Merge1 {
    private DateAndLocalDate dateAndLocalDate;
    private Empty empty;
    private Merge2 merge2;
    private DifferentArrays differentArrays;

    public DateAndLocalDate getDateAndLocalDate() {
        return dateAndLocalDate;
    }

    public void setDateAndLocalDate(DateAndLocalDate dateAndLocalDate) {
        this.dateAndLocalDate = dateAndLocalDate;
    }

    public Empty getEmpty() {
        return empty;
    }

    public void setEmpty(Empty empty) {
        this.empty = empty;
    }

    public Merge2 getMerge2() {
        return merge2;
    }

    public void setMerge2(Merge2 merge2) {
        this.merge2 = merge2;
    }

    public DifferentArrays getDifferentArrays() {
        return differentArrays;
    }

    public void setDifferentArrays(DifferentArrays differentArrays) {
        this.differentArrays = differentArrays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Merge1 merge1 = (Merge1) o;

        if (dateAndLocalDate != null ? !dateAndLocalDate.equals(merge1.dateAndLocalDate) : merge1.dateAndLocalDate != null)
            return false;
        if (empty != null ? !empty.equals(merge1.empty) : merge1.empty != null) return false;
        if (merge2 != null ? !merge2.equals(merge1.merge2) : merge1.merge2 != null) return false;
        return differentArrays != null ? differentArrays.equals(merge1.differentArrays) : merge1.differentArrays == null;
    }

    @Override
    public int hashCode() {
        int result = dateAndLocalDate != null ? dateAndLocalDate.hashCode() : 0;
        result = 31 * result + (empty != null ? empty.hashCode() : 0);
        result = 31 * result + (merge2 != null ? merge2.hashCode() : 0);
        result = 31 * result + (differentArrays != null ? differentArrays.hashCode() : 0);
        return result;
    }
}
