package reflection.exampleClasses;

/**
 * Created by Lubov on 07.01.2017.
 */
public class PrimitiveWrappers {
    private Boolean wrapperBoolean;
    private Character wrapperChar;
    private Byte wrapperByte;
    private Short wrapperShort;
    private Integer wrapperInt;
    private Long wrapperLong;
    private Float wrapperFloat;
    private Double wrapperDouble;

    public Boolean getWrapperBoolean() {
        return wrapperBoolean;
    }

    public void setWrapperBoolean(Boolean wrapperBoolean) {
        this.wrapperBoolean = wrapperBoolean;
    }

    public Character getWrapperChar() {
        return wrapperChar;
    }

    public void setWrapperChar(Character wrapperChar) {
        this.wrapperChar = wrapperChar;
    }

    public Byte getWrapperByte() {
        return wrapperByte;
    }

    public void setWrapperByte(Byte wrapperByte) {
        this.wrapperByte = wrapperByte;
    }

    public Short getWrapperShort() {
        return wrapperShort;
    }

    public void setWrapperShort(Short wrapperShort) {
        this.wrapperShort = wrapperShort;
    }

    public Integer getWrapperInt() {
        return wrapperInt;
    }

    public void setWrapperInt(Integer wrapperInt) {
        this.wrapperInt = wrapperInt;
    }

    public Long getWrapperLong() {
        return wrapperLong;
    }

    public void setWrapperLong(Long wrapperLong) {
        this.wrapperLong = wrapperLong;
    }

    public Float getWrapperFloat() {
        return wrapperFloat;
    }

    public void setWrapperFloat(Float wrapperFloat) {
        this.wrapperFloat = wrapperFloat;
    }

    public Double getWrapperDouble() {
        return wrapperDouble;
    }

    public void setWrapperDouble(Double wrapperDouble) {
        this.wrapperDouble = wrapperDouble;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PrimitiveWrappers that = (PrimitiveWrappers) o;

        if (wrapperBoolean != null ? !wrapperBoolean.equals(that.wrapperBoolean) : that.wrapperBoolean != null)
            return false;
        if (wrapperChar != null ? !wrapperChar.equals(that.wrapperChar) : that.wrapperChar != null) return false;
        if (wrapperByte != null ? !wrapperByte.equals(that.wrapperByte) : that.wrapperByte != null) return false;
        if (wrapperShort != null ? !wrapperShort.equals(that.wrapperShort) : that.wrapperShort != null) return false;
        if (wrapperInt != null ? !wrapperInt.equals(that.wrapperInt) : that.wrapperInt != null) return false;
        if (wrapperLong != null ? !wrapperLong.equals(that.wrapperLong) : that.wrapperLong != null) return false;
        if (wrapperFloat != null ? !wrapperFloat.equals(that.wrapperFloat) : that.wrapperFloat != null) return false;
        return wrapperDouble != null ? wrapperDouble.equals(that.wrapperDouble) : that.wrapperDouble == null;
    }

    @Override
    public int hashCode() {
        int result = wrapperBoolean != null ? wrapperBoolean.hashCode() : 0;
        result = 31 * result + (wrapperChar != null ? wrapperChar.hashCode() : 0);
        result = 31 * result + (wrapperByte != null ? wrapperByte.hashCode() : 0);
        result = 31 * result + (wrapperShort != null ? wrapperShort.hashCode() : 0);
        result = 31 * result + (wrapperInt != null ? wrapperInt.hashCode() : 0);
        result = 31 * result + (wrapperLong != null ? wrapperLong.hashCode() : 0);
        result = 31 * result + (wrapperFloat != null ? wrapperFloat.hashCode() : 0);
        result = 31 * result + (wrapperDouble != null ? wrapperDouble.hashCode() : 0);
        return result;
    }
}
