package tech.danhe.obj;

import java.util.Objects;

public class Data {

    private String i2;
    private String c11_3_75_higher;
    private String c11_3_50_3_74;
    private String c11_3_25_3_49;
    private String c11_3_00_3_24;
    private String c11_2_50_2_99;
    private String c12;

    public String getI2() {
        return i2;
    }

    public void setI2(String i2) {
        this.i2 = i2;
    }

    public String getC11_3_75_higher() {
        return c11_3_75_higher;
    }

    public void setC11_3_75_higher(String c11_3_75_higher) {
        this.c11_3_75_higher = c11_3_75_higher;
    }

    public String getC11_3_50_3_74() {
        return c11_3_50_3_74;
    }

    public void setC11_3_50_3_74(String c11_3_50_3_74) {
        this.c11_3_50_3_74 = c11_3_50_3_74;
    }

    public String getC11_3_25_3_49() {
        return c11_3_25_3_49;
    }

    public void setC11_3_25_3_49(String c11_3_25_3_49) {
        this.c11_3_25_3_49 = c11_3_25_3_49;
    }

    public String getC11_3_00_3_24() {
        return c11_3_00_3_24;
    }

    public void setC11_3_00_3_24(String c11_3_00_3_24) {
        this.c11_3_00_3_24 = c11_3_00_3_24;
    }

    public String getC11_2_50_2_99() {
        return c11_2_50_2_99;
    }

    public void setC11_2_50_2_99(String c11_2_50_2_99) {
        this.c11_2_50_2_99 = c11_2_50_2_99;
    }

    public String getC12() {
        return c12;
    }

    public void setC12(String c12) {
        this.c12 = c12;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return Objects.equals(i2, data.i2) &&
                Objects.equals(c11_3_75_higher, data.c11_3_75_higher) &&
                Objects.equals(c11_3_50_3_74, data.c11_3_50_3_74) &&
                Objects.equals(c11_3_25_3_49, data.c11_3_25_3_49) &&
                Objects.equals(c11_3_00_3_24, data.c11_3_00_3_24) &&
                Objects.equals(c11_2_50_2_99, data.c11_2_50_2_99) &&
                Objects.equals(c12, data.c12);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i2, c11_3_75_higher, c11_3_50_3_74, c11_3_25_3_49, c11_3_00_3_24, c11_2_50_2_99, c12);
    }

    @Override
    public String toString() {
        return "\n Data{" +
                "i2='" + i2 + '\'' +
                ", c11_3_75_higher='" + c11_3_75_higher + '\'' +
                ", c11_3_50_3_74='" + c11_3_50_3_74 + '\'' +
                ", c11_3_25_3_49='" + c11_3_25_3_49 + '\'' +
                ", c11_3_00_3_24='" + c11_3_00_3_24 + '\'' +
                ", c11_2_50_2_99='" + c11_2_50_2_99 + '\'' +
                ", c12='" + c12 + '\'' +
                '}';
    }
}
