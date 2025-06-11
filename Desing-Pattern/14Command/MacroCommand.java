import java.util.*;

class MacroCommand implements Command{

    private List<Command> commands;

    MacroCommand(){
        this.commands = new ArrayList<>();
    }

    public void add(Command command){
        this.commands.add(command);
    }

    public void execute(){
        for(Command command : commands){
            command.execute();
        }
    }
};