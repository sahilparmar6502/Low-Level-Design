
public class Main{
    public static void main(String args[]){

        ReportGenerator reportGenerator = new ReportGeneratorAdapter();
        ReportService reportService = new ReportService(reportGenerator);

        reportService.exportReport("Annual Report","This is the content of Annual Report");
    }
}