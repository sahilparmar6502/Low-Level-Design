
class ErrorLogger extends Logger{

    public void log(int logLevel,String msg){

        if(logLevel == ERROR){
            System.out.println("Error Log:"+msg);
        }
        else{
            if(nextLogger != null){
                nextLogger.log(logLevel,msg);
            }
        }
    }
};