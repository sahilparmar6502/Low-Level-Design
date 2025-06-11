
public class Main{
    public static void main(String args[]){

        TeamLead teamLead = new TeamLead();
        Manager manager = new Manager();
        Director director = new Director();
        HR hr = new HR();

        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);
        director.setNextApprover(hr);

        teamLead.approveLeave(2);
        teamLead.approveLeave(5);
        teamLead.approveLeave(12);
        teamLead.approveLeave(22);
    }
};