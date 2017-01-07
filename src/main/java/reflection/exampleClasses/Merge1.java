package reflection.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class Merge1 {
    private DateAndLocalDate dateAndLocalDate;
    private Empty empty;
    private Merge2 merge2;

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
}
