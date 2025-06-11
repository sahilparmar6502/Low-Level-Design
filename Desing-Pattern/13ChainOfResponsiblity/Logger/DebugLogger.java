
class DebugLogger extends Logger{

    public void log(int logLevel,String msg){
        
        if(logLevel == DEBUG){
            System.out.println("Debug Log:"+msg);
        }
        else{
            if(nextLogger != null){
                nextLogger.log(logLevel,msg);
            }
        }
    }
};