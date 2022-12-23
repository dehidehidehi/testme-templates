package example;
class SampleClass {

    private final String big;
    private final double theDouble;
    private final Short theShort;

    public SampleClass(final String big, final double thedouble, final Short theshort) {
        this.big = big;
        theDouble = thedouble;
        theShort = theshort;
    }

    public String getBig() {
        return big;
    }

    public double getTheDouble() {
        return theDouble;
    }

    public Short getTheShort() {
        return theShort;
    }
}
