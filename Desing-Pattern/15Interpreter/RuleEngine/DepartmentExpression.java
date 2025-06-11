
class DepartmentExpression implements Expression{

    private String required;

    DepartmentExpression(String required){
        this.required = required;
    }

    public boolean interprete(Context context){
        return context.getDepartment().equalsIgnoreCase(required);
    }
};