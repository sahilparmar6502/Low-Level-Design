
public class Main{

    public static void main(String args[]){

        DepartmentExpression departmentExpression = new DepartmentExpression("HR");
        ExperienceExpression experienceExpression = new ExperienceExpression(5);

        Context applicant1 = new Context("Text",8);
        Context applicant2 = new Context("HR",5);

        AndExpression andExpression = new AndExpression(departmentExpression,experienceExpression);

        System.out.println("Applicant1 eligible?"+andExpression.interprete(applicant1));
        System.out.println("Applicant2 eligible?"+andExpression.interprete(applicant2));
    }
};