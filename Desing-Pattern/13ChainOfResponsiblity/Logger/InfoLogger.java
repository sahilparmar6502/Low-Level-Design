
class InfoLogger extends Logger{

    public void log(int logLevel,String msg){

        if(logLevel == INFO){
            System.out.println("Info Log:"+msg);
        }
        else{
            if(nextLogger != null){
                nextLogger.log(logLevel,msg);
            }
        }
    }
};