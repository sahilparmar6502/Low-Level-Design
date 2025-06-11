
public class ReportGeneratorAdapter implements ReportGenerator{

    private AwesomePdfLib awesomePdfLib;

    public ReportGeneratorAdapter(){
        awesomePdfLib = new AwesomePdfLib();
    }

    public void generate(String title,String content){
        awesomePdfLib.createPdf(title,content);
    }
}