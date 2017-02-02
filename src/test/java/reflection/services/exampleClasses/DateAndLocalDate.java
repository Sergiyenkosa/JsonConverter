package reflection.services.exampleClasses;

import reflection.annotations.CustomDateFormat;
import reflection.annotations.JsonValue;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by Lubov on 07.01.2017.
 */
public class DateAndLocalDate {
    @JsonValue(name = "localDataWithFormat")
    @CustomDateFormat(format = "dd­MM­yyyy")
    private LocalDate ld1;
    private LocalDate ld2;
    private Date date;

    public LocalDate getLd1() {
        return ld1;
    }

    public void setLd1(LocalDate ld1) {
        this.ld1 = ld1;
    }

    public LocalDate getLd2() {
        return ld2;
    }

    public void setLd2(LocalDate ld2) {
        this.ld2 = ld2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DateAndLocalDate that = (DateAndLocalDate) o;

        if (ld1 != null ? !ld1.equals(that.ld1) : that.ld1 != null) return false;
        if (ld2 != null ? !ld2.equals(that.ld2) : that.ld2 != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = ld1 != null ? ld1.hashCode() : 0;
        result = 31 * result + (ld2 != null ? ld2.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
