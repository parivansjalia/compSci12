public class Disk {
    private Point center;
    private double radius;

    public Disk(Disk other) {
        this.center = other.center;
        this.radius = other.radius;
    }
}