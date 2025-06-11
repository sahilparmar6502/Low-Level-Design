
public class ReportService{
    private ReportGenerator reportGenerator;

    public ReportService(ReportGenerator reportGenerator){
        this.reportGenerator = reportGenerator;
    }

    public void exportReport(String title,String content){
        reportGenerator.generate(title,content);
    }
}