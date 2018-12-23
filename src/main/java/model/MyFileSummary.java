package model;

import java.io.Serializable;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * Created by shiraz on 23/12/2018.
 */
public class MyFileSummary implements Serializable {

    private long largest;
    private long smallest;
    private double average;
    private long count;
    private List<MyFile> files;

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
}
