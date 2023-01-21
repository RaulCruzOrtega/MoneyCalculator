package Persistence.File;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class IteratorReader implements Iterable<String>{
    private BufferedReader reader;

    public IteratorReader(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            String currentLine = ReadLine();
            String result;
            
            @Override
            public boolean hasNext() {
                return currentLine != null;
            }

            @Override
            public String next() {
               result = currentLine;
               currentLine = ReadLine();
               return result;
            }

            private String ReadLine() {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    return null;
                }
            }
        };
    }
}
