package reflection.exampleClasses;

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
}
