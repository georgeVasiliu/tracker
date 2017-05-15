package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Created by george on 5/15/17.
 */
public class ExecutorsReference {

    private static ExecutorService normalExecutor;
    private static ScheduledExecutorService scheduledExecutor;

    public static ExecutorService getNormalExecutor(){
        if (normalExecutor == null){
            normalExecutor = Executors.newCachedThreadPool();
        }
        return normalExecutor;
    }

    public static ScheduledExecutorService getScheduledExecutor(){
        if (scheduledExecutor == null){
            scheduledExecutor = Executors.newScheduledThreadPool(10);
        }
        return scheduledExecutor;
    }


}
