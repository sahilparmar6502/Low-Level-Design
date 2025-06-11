
class TeamLead extends LeaveApprover{

    @Override
    public void approveLeave(int days){

        if(days <= 3){
            System.out.println("Request is approved by TeamLead for "+days+" days");
        }
        else{
            this.nextApprover.approveLeave(days);
        }
    }
};

class Manager extends LeaveApprover{

    @Override   
    public void approveLeave(int days){
        if(days <= 7){
            System.out.println("Request is approved by Manager for "+days+" days");
        }
        else{
            this.nextApprover.approveLeave(days);
        }
    }
};

class Director extends LeaveApprover{

    @Override
    public void approveLeave(int days){
        if(days <= 14){
            System.out.println("Request is approved by Director for "+days+" days");
        }
        else{
            System.out.println("Request cannot be approved for "+days+" days");
        }
    }
};

class HR extends LeaveApprover{

    @Override
    public void approveLeave(int days){
        if(days <= 30){
            System.out.println("Request is approved by HR for "+days+" days");
        }
        else{
            System.out.println("Request cannot be approved for "+days+" days");
        }
    }
};