

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ShapeExtractor {

    Painting painting;
    List<Shape> shapes;


    ShapeExtractor(Painting p) {
        this.painting = p;
        this.shapes = new ArrayList<>();
    }



     void extractShapes() {

        Coord nextPixel = findNextAvailablePixel();
        while(nextPixel != null) {

             Stack<Coord> pixels = new Stack<>();
             Stack<Coord> readPixels = new Stack<>();

             pixels.push(nextPixel);

             Shape s = new Shape();
             processShape(s, pixels, readPixels);

             shapes.add(s);
             nextPixel = findNextAvailablePixel();
         }

    }



    void processShape(Shape s, Stack<Coord> pixels, Stack<Coord> readPixels) {

        if(pixels.empty()) {
            return;
        }
        Coord p = pixels.pop();
        // s'il a déja été lu, on le dégage
        if(readPixels.contains(p))
            return;
//        // ajoute le pixel au Shape
        s.add(p);
        readPixels.push(p);

        addNeighborIfVisible(p.up(), pixels, readPixels);
        addNeighborIfVisible(p.down(), pixels, readPixels);
        addNeighborIfVisible(p.left(), pixels, readPixels);
        addNeighborIfVisible(p.right(), pixels, readPixels);

        processShape(s, pixels, readPixels);

    }

    void addNeighborIfVisible(Coord p, Stack<Coord> pixels, Stack<Coord> readPixels) {
        if(p.isVisibleOn(painting)) {
            if(!readPixels.contains(p)) {
                pixels.push(p);
            }
        }
    }

    Coord findNextAvailablePixel() {
        for(int r = 0; r< painting.rows; r++) {
            for( int c=0; c < painting.columns; c++) {
                if(painting.get(r, c)) {
                    Coord p = new Coord(r, c);
                    boolean found = false;
                    for(Shape s : shapes) {
                        found = s.hasPixel(p);
                        if(found)
                            break;
                    }
                    if(!found)
                        return new Coord(r, c);
                }
            }
        }
        return null;
    }





}
