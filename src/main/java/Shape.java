import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Shape {

    List<Coord> pixels;

    Shape() {
        pixels = new ArrayList<>();
    }

    void add(Coord pixel) {
        pixels.add(pixel);
    }

    boolean hasPixel(Coord c) {
        return pixels.contains(c);
    }

    int height() {
        return lower().r - higher().r + 1;
    }

    int width() {
        return righter().c - lefter().c + 1;
    }

    Coord higher() {
        final Comparator<Coord> comp = (p1, p2) -> Integer.compare( p1.r, p2.r);
        return pixels.stream().min(comp).get();
    }

    Coord lower() {
        final Comparator<Coord> comp = (p1, p2) -> Integer.compare( p1.r, p2.r);
        return pixels.stream().max(comp).get();
    }

    Coord lefter() {
        final Comparator<Coord> comp = (p1, p2) -> Integer.compare( p1.c, p2.c);
        return pixels.stream().min(comp).get();
    }

    Coord righter() {
        final Comparator<Coord> comp = (p1, p2) -> Integer.compare( p1.c, p2.c);
        return pixels.stream().max(comp).get();
    }

    @Override
    public String toString() {
        return "{" + pixels.size() + " - " + pixels.toString() + "}";
    }
}
