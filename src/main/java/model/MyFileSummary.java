package model;

import java.io.Serializable;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Created by shiraz on 23/12/2018.
 */
public class MyFileSummary implements Serializable {

    private long largest;
    private long smallest;
    private double average;
    private long count;
    private List<MyFile> files;

    public MyFileSummary() {
        // used by RestTemplate for unmarshalling
    }

    public MyFileSummary(List<MyFile> files) {
        this.files = files;
        LongSummaryStatistics statistics = files.stream().mapToLong(MyFile::getSize).summaryStatistics();
        largest = statistics.getMax();
        smallest = statistics.getMin();
        average = statistics.getAverage();
        count = statistics.getCount();
    }

    public long getLargest() {
        return largest;
    }

    public long getSmallest() {
        return smallest;
    }

    public double getAverage() {
        return average;
    }

    public List<MyFile> getFiles() {
        return files;
    }

    public long getCount() {
        return count;
    }

    // setters used for unmarshalling from JSON byte-stream
    public void setLargest(long largest) {
        this.largest = largest;
    }

    public void setSmallest(long smallest) {
        this.smallest = smallest;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setFiles(List<MyFile> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "MyFileSummary{" +
                "largest=" + largest +
                ", smallest=" + smallest +
                ", average=" + average +
                ", count=" + count +
                ", files=\n" + files.stream().map(s -> s.toString()).collect(Collectors.joining("\n")) +
                '}';
    }
}
