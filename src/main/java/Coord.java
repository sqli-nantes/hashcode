import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode
class Coord {
    int r;
    int c;

    Coord up() {
        return new Coord(r-1, c);
    }

    Coord down() {
        return new Coord(r+1, c);
    }

    Coord left() {
        return new Coord(r, c-1);
    }

    Coord right() {
        return new Coord(r, c+1);
    }


    @Override
    public String toString() {
        return "{" + r +", " + c + '}';
    }
}