public class Rectangle {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        if (width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        } else {
            throw new IllegalArgumentException("bad");
        }
    }

    public Rectangle(int size) {
        if (width > 0 && height > 0) {
            width = size;
            height = size;
        } else {
            throw new IllegalArgumentException("bad");
        }
    }

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public boolean isSquare() {
        if (width == height) {
            return true;
        } else {
            return false;
        }
    }

    public void quadratize() {
        int total = width * 2 + height * 4;
        if (total % 4 == 0) {
            width = total / 4;
            height = total / 4;
        } else {
            height = total / 2 + 1;
            width = width / 2;
        }
    }

    public void quadratize2() {
        int totalArea = width * height;
        int otherArea;
        if (isSquare()) {
        } else {

        }

    }
}
