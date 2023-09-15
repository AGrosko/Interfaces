import org.w3c.dom.css.Rect;

import java.awt.*;
import java.util.ArrayList;

public class BigRectLister {
    public static void main(String[] args) {

        BigRectangleFilter filter = new BigRectangleFilter();

        ArrayList<Rectangle> rectList = new ArrayList<Rectangle>();
        rectList.add(new Rectangle(2,3));
        rectList.add(new Rectangle(5,1));
        rectList.add(new Rectangle(4,3));
        rectList.add(new Rectangle(4,4));
        rectList.add(new Rectangle(20,3));
        rectList.add(new Rectangle(2,1));

        int i = 0;
        while(i < rectList.size()){
            if(filter.accept(rectList.get(i))){
                System.out.println((rectList.get(i).width + rectList.get(i).height)*2);
            }

            i++;
        }
    }
}
