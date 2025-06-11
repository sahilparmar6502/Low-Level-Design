

abstract class Logger{

    public int INFO = 0;
    public int DEBUG = 1;
    public int ERROR = 2;

    protected Logger nextLogger;

    public void setNextLogger(Logger logger){
        this.nextLogger = logger;
    }

    public abstract void log(int logLevel,String msg);
};