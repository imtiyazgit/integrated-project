package algos.geometric.overlappingrectangles;


public class FindOverlappingRectanglesArea {

    public static class Rectangle {
        int x, y, width, height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Rectangle{" +
                    "x=" + x +
                    ", y=" + y +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }

    private static Rectangle intersect(Rectangle r1, Rectangle r2) {

        int overlappingX, overlappingY, overlappingWidth, overlappingHeight;

        Rectangle leftRect, rightRect, lowerRect, upperRect;

        // First determine which one is left rectangle and which one is right rectangle
        if(r1.x < r2.x) {
            leftRect = r1;
            rightRect = r2;
        } else {
            leftRect = r2;
            rightRect = r1;
        }

        // Next determine which one is lower rectangle and which one is upper rectangle
        if(r1.y < r2.y) {
            lowerRect = r1;
            upperRect = r2;
        } else {
            lowerRect = r2;
            upperRect = r1;
        }

        // Now determine overlappingWidth  ----------
        //                                             ---------
        //                                    ----
        //                                       --------
        // 3 cases to determine overlappingWidth.. rightRect unable to reach, rightRect is inside and rightRect is extended
        if (leftRect.x+leftRect.width <= rightRect.x) {
            // If r1.x with width unable to reach r2.x, then no overlap
            return null;
        } else if (leftRect.x + leftRect.width > rightRect.x + rightRect.width) {
            // full overlap
            overlappingWidth = rightRect.width;
        } else {
            // partial overlap
            overlappingWidth = leftRect.x + leftRect.width - rightRect.x;
        }


        // Now determine overlappingHeight
        if(lowerRect.x+lowerRect.height <= upperRect.x) {
            // lower rect is unable to reach upper rect
            return null;
        } else if(lowerRect.x+lowerRect.height > upperRect.x+upperRect.height) {
            // upper rect is inside lowerRect
            overlappingHeight = upperRect.height;
        } else {
            // upper rect is extending out from inside lower rect
            overlappingHeight = lowerRect.x + lowerRect.height - upperRect.x;
        }

        // overlappingX is easy to calculate. Its always right rectangles x. It doesnt matter even if you swap the rectangles. Its always right rectangle's x.. top.x or bottom.x is a x coordinate only
        overlappingX = rightRect.x;

        // overlappingY is same. Its always upperRect's y
        overlappingY = upperRect.y;

        return new Rectangle(overlappingX, overlappingY, overlappingWidth, overlappingHeight);

    }


    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(0,0, 10, 10);
        Rectangle r2 = new Rectangle(7,7,10, 10);

        Rectangle result = intersect(r1, r2);
        System.out.println(result); // 7,7,3,3 should be the answer


        r1 = new Rectangle(0,0, 10, 10);
        r2 = new Rectangle(20,7,10, 10);
        System.out.println(intersect(r1, r2)); // no overlap

        r1 = new Rectangle(6,6, 1, 1);
        r2 = new Rectangle(0,0,10, 10);
        System.out.println(intersect(r1, r2)); // r1 is fully inside

        r1 = new Rectangle(0,0,10, 10);
        r2 = new Rectangle(10,10, 2, 2);
        System.out.println(intersect(r1, r2)); // at edge.. no overlap,, try changing x9 y9. you will see 9,9,1,1

    }
}
