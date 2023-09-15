import java.awt.*;

class BigRectangleFilter implements Filter<Rectangle> {

    @Override
    public boolean accept(Rectangle rectangle) {
        double perimeter;
        perimeter = (rectangle.width + rectangle.height) *2;
        return perimeter > 10;
    }
}
