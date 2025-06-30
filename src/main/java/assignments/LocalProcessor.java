package assignments;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10_000_000_000_000L;
    private String processorVersion;
    private Integer valueofCheap;
    private Scanner informationScanner;
    private StringBuilder builder;
    private List<String> stringArrayList = new LinkedList<>();

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueofCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listiterator(List<String> stringList) {
        stringList.stream()
                .filter(Objects::nonNull)
                .map(String::hashCode)
                .forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullnameProcessorgenerator(List<String> stringList) {
        builder = new StringBuilder(processorName);
        for (String s : stringList) {
            builder.append(s).append(" ");
        }
        processorName = builder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readfullprocessorname(File file) {
        try (Scanner scanner = new Scanner(file)) {
            informationScanner = scanner;
            builder = new StringBuilder(processorVersion);
            while (scanner.hasNext()) {
                builder.append(scanner.nextLine());
            }
            processorVersion = builder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            informationScanner.close();
        }
    }
}
