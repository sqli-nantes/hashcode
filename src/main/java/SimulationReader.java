import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SimulationReader {


    Simulation readFile(String filename) throws IOException, URISyntaxException {
        URL url = getClass().getClassLoader().getResource(filename);
        Path p = Paths.get(url.toURI());

        Simulation sim = new Simulation();

        Files.lines(p).limit(1).forEach(x-> {
            System.out.println("read " + x);
            sim.setVals(splitLineAsIntArray(x));
        });

        Files.lines(p).skip(1).limit(1).forEach(x -> {
            System.out.println("read " + x);
            // do nothing
        });

        Files.lines(p).skip(2).limit(1).forEach(x -> {
            System.out.println("read " + x);
            sim.setProducts(splitLineAsIntArray(x));
        });


        AtomicInteger warehouseCount = new AtomicInteger();
        Files.lines(p).skip(3).limit(1).forEach(x -> {
            System.out.println("read " + x);
          warehouseCount.set(Integer.parseInt(x));
        });

        int readstart = 4;
        for(int i= 0; i<warehouseCount.get();i++) {
            Warehouse w = new Warehouse(sim.products.size());
            w.id = i;
            Files.lines(p).skip(readstart).limit(1).forEach(x -> {
                System.out.println("read " + x);
                w.setCoord(splitLineAsIntArray(x));
            });

            Files.lines(p).skip(readstart+1).limit(1).forEach(x -> {
                System.out.println("read " + x);
                w.setProduct(splitLineAsIntArray(x));
            });
            sim.warehouses.put(i, w);
            readstart += 2;
        }

        //readstart++;
        AtomicInteger ordersCount = new AtomicInteger();
        Files.lines(p).skip(readstart).limit(1).forEach(x -> {
            System.out.println("read " + x);
            ordersCount.set(Integer.parseInt(x));
        });

        readstart++;
        for(int i= 0; i<ordersCount.get();i++) {
            Order o = new Order(sim);
            o.id = i;
            Files.lines(p).skip(readstart).limit(1).forEach(x -> {
                System.out.println("read " + x);
               o.setCoord(splitLineAsIntArray(x));
            });

            Files.lines(p).skip(readstart+2).limit(1).forEach(x -> {
                System.out.println("read " + x);
                o.setProducts(splitLineAsIntArray(x));
            });
            sim.orders.put(i, o);
            readstart += 3;
        }

        return sim;
    }

    static int[] splitLineAsIntArray(String line) {
        return Stream.of(line.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    static char[] splitLineAsBooleanArray(String line) {
        return line.toCharArray();
    }


}
