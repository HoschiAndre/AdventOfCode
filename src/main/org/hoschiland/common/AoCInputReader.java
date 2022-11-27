package org.hoschiland.common;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class AoCInputReader {

    public List<String> fileToStrLines(String fileName) {
        try (Stream<String> stringStream = Files.lines(path(fileName))) {
            return stringStream.toList();
        } catch (IOException e) {
            throw new AoCRuntimeException(e);
        }
    }

    public List<Integer> fileToIntLines(String fileName) {
        return fileToStrLines(fileName).stream().map(Integer::valueOf).toList();
    }

    public List<Long> fileToLongLines(String fileName) {
        return fileToStrLines(fileName).stream().map(Long::valueOf).toList();
    }

    public String file2String(String fileName) {
        try {
            return Files.readString(path(fileName));
        } catch (IOException e) {
            throw new AoCRuntimeException(e);
        }
    }

    private Path path(String fileName) {
        try {
            return Paths.get(Objects.requireNonNull(getClass().getResource(fileName)).toURI());
        } catch (URISyntaxException e) {
            throw new AoCRuntimeException(e);
        }
    }


// ------------------------------------------------------------------------
// input splitting

    public static record SplitResult(String[] fields) {

        public String s(int i) {
            return fields[i];
        }

        public int i(int i) {
            return Integer.parseInt(fields[i]);
        }

        public long l(int i) {
            return Long.parseLong(fields[i]);
        }

        public char c(int i) {
            return fields[i].charAt(0);
        }

        public List<String> toList() {
            return List.of(fields);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SplitResult that = (SplitResult) o;

            // Probably incorrect - comparing Object[] arrays with Arrays.equals
            return Arrays.equals(fields, that.fields);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(fields);
        }

        @Override
        public String toString() {
            return "SplitResult{" +
                    "fields=" + Arrays.toString(fields) +
                    '}';
        }
    }

    public static SplitResult split(String s, String pat) {
        return new SplitResult(s.split(pat));
    }

    public static SplitResult lines(String s) {
        return new SplitResult(s.split("\n"));
    }
}



