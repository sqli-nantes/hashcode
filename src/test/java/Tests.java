
import org.junit.Test;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class Tests {


    @Test
    public void test1() throws Exception {
        PaintingReader po = new PaintingReader();

        Painting p = po.readFile("small.in");



        for(int i=0; i<5; i++) {
            for(int j= 0; j<4;j++) {
                System.out.println("" + i + ", "+j + ":" + (p.get(i, j)?"#":"."));
            }
        }

        assertTrue(p.get(3, 4));
        assertThat(p.get(3, 4), is(true));
    }
}
