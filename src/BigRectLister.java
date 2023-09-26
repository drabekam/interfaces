import java.util.ArrayList;
import java.util.List;
import java.awt.Rectangle;

public class BigRectLister {
    public static void main(String[] args) {

        List<Rectangle> rectangles = new ArrayList<>();

        rectangles.add(new Rectangle(3, 3));
        rectangles.add(new Rectangle(2, 4));
        rectangles.add(new Rectangle(1, 2));
        rectangles.add(new Rectangle(5, 1));
        rectangles.add(new Rectangle(2, 2));
        rectangles.add(new Rectangle(6, 2));
        rectangles.add(new Rectangle(3, 5));
        rectangles.add(new Rectangle(4, 4));
        rectangles.add(new Rectangle(1, 1));
        rectangles.add(new Rectangle(7, 7));


        BigRectangleFilter filter = new BigRectangleFilter();


        System.out.println("Rectangles with perimeters greater than 10:");
        for (Rectangle rectangle : rectangles) {
            if (filter.accept(rectangle)) {
                System.out.println("Width: " + rectangle.getWidth() + ", Height: " + rectangle.getHeight() +
                        ", Perimeter: " + (2 * (rectangle.getWidth() + rectangle.getHeight())));
            }
        }
    }
}