import java.awt.Rectangle;
//this is the import that is needed for the rectangles found when getting an error on the rectangles

public class BigRectangleFilter implements Filter {
    @Override
    public boolean accept(Object x) {
        if (x instanceof Rectangle) {
            Rectangle rect = (Rectangle) x;
            double perimeter = 2 * (rect.getWidth() + rect.getHeight());
            //since there is 2 width and thwo hieghts we need to multiply by 2
            return perimeter > 10;
        }
        return false;
        //this protects from the errors when there is not an instance of the class rectangle
    }
}