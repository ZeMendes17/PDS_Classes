import java.util.List;
package src.Impressoras;

public interface AdvancedPrinterInterface {
    public int print(Document doc);
    public List<Integer> print(List<Document> docs);
    public void showQueuedJobs();
    public boolean cancelJob(int jobId) ;
    public void cancelAll();
}
