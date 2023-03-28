package src.Impressoras;

import java.util.ArrayList;
import java.util.List;

public class AdapterBasicPrinter {
    private List<String[]> printQueue;
    private int paperLevel;
    private int inkLevel;

    public AdapterBasicPrinter() {
        this.printQueue = new ArrayList<>();
        this.paperLevel = 0;
        this.inkLevel = 0;
    }

    public int print(String[] content) {
        if (paperLevel == 0 || inkLevel == 0) {
            return -1;
        }
        printQueue.add(content);
        return printQueue.size() - 1;
    }

    public List<Integer> print(List<String[]> contents) {
        List<Integer> jobIds = new ArrayList<>();
        for (String[] content : contents) {
            int jobId = print(content);
            if (jobId == -1) {
                return null;
            }
            jobIds.add(jobId);
        }
        return jobIds;
    }

    public void showQueuedJobs() {
        for (int i = 0; i < printQueue.size(); i++) {
            System.out.println("* Job " + i + ": " + formatContent(printQueue.get(i)));
        }
    }

    public boolean cancelJob(int jobId) {
        if (jobId < 0 || jobId >= printQueue.size()) {
            return false;
        }
        printQueue.remove(jobId);
        return true;
    }

    public void cancelAll() {
        printQueue.clear();
    }

    public void refill() {
        paperLevel = 100;
        inkLevel = 100;
    }

    private String formatContent(String[] content) {
        StringBuilder sb = new StringBuilder();
        for (String line : content) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}