
class Context{
    private String department;
    private int experience;

    Context(String department,int experience){
        this.department = department;
        this.experience = experience;
    }

    public String getDepartment(){
        return this.department;
    }

    public int getExperience(){
        return this.experience;
    }
};