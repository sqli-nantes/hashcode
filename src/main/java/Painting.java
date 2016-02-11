

public class Painting {
    int rows;
    int columns;

    char[] rc;


    void setDimensions(int[] dimensions) {
        rows = dimensions[0];
        columns = dimensions[1];

        rc = new char[rows * columns];
    }

    boolean get(int r, int c) {
        if(r >= rows)
            return false;
        if(c >= columns)
            return false;
        int index = r*columns + c;
        return rc[index] == '#';
    }

    void setLine(char[] content, int line) {
        System.arraycopy(content, 0, rc, line*columns, content.length );
    }



}
