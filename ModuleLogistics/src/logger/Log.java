package logger;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by george on 5/23/17.
 */
public class Log {
    public static final int LOG_TYPE_INFO = 1;
    public static final int LOG_TYPE_DEBUG = 2;
    public static final int LOG_TYPE_WARN = 3;
    public static final int LOG_TYPE_ERROR = 4;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy--MM--dd hh:mm:ss");

    private static PrintStream infoStream = System.out;
    private static PrintStream debugStream = System.out;
    private static PrintStream errorStream = System.out;
    private static PrintStream warnStream = System.out;

    public static void printLog(int type, String message){
        PrintStream localStream = null;
        String prefix = "";
        int threadId = (int)Thread.currentThread().getId();
        String threadName = Thread.currentThread().getName();
        String className = Thread.currentThread().getStackTrace()[2].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        int lineNum = Thread.currentThread().getStackTrace()[2].getLineNumber();

        switch (type){
            case LOG_TYPE_INFO:
                localStream = infoStream;
                prefix= "[INFO]";
                break;
            case LOG_TYPE_WARN:
                localStream=warnStream;
                prefix="[WARN";
                break;
            case LOG_TYPE_DEBUG:
                localStream = debugStream;
                prefix ="[DEBUG]";
                break;
            case LOG_TYPE_ERROR:
                localStream = errorStream;
                prefix= "[ERROR]";
                break;
            default:
                localStream = errorStream;
                prefix = "[" + Integer.toString(type) + "]";
        }

        localStream.println(prefix + "[" + dateFormat.format(new Date()) +"]"
                            + "[" + threadName + ":" + threadId + "]"
                            + "(" + className + ")" + ":" + methodName + ":" + lineNum + " " + message);
    }

    public static void setDateFormat(String dateFormatted){
         dateFormat.applyPattern(dateFormatted);
    }
    public static String getDateFormat(){
        return dateFormat.toPattern();
    }

}
