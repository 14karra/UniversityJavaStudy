package Lab4;

class LabeledPoint extends Point {
    private final String label;

    public LabeledPoint(double x, double y, String label) {
        super(x, y);
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LabeledPoint that = (LabeledPoint) o;

        return label.equals(that.label);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        return 31 * result + label.hashCode();
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "x=" + this.getX() +
                ", y=" + this.getY() +
                ", label='" + label + '\'' +
                '}';
    }

    public String getLabel() {
        return label;
    }
}
