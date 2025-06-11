
class ExperienceExpression implements Expression{

    private int required;

    ExperienceExpression(int required){
        this.required = required;
    }

    public boolean interprete(Context context){
        return context.getExperience() >= this.required;
    }
};