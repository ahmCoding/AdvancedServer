package org.example.app.executor;

import org.example.app.command.ConcurrCommand;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Klasse zur Implementierung des Executors von Server
 */
public class ServerExecutor extends ThreadPoolExecutor {
    // speichert die Startzeiten der einzelnen Tasks, damit am end die Statistik erfasst werden kann
    private ConcurrentHashMap<Runnable, Date> startTimes;
    // für jeden User wird die Statistik gespeichert
    private ConcurrentHashMap<String, ExecutorStats> executorStats;
    private static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private static final int KEEP_ALIVE_TIME = 10;
    // ein Controller für mehrere Executors sogar ausreichend.
    private static final RejectedTaskController rTaskController = new RejectedTaskController();

    public ServerExecutor() {
        super(NUMBER_OF_CORES, NUMBER_OF_CORES, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(), rTaskController);
        this.startTimes = new ConcurrentHashMap<>();
        this.executorStats = new ConcurrentHashMap<>();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        super.beforeExecute(t, r);
        // startzeit merken
        startTimes.put(r, new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        super.afterExecute(r, t);
        if (t != null && r instanceof ServerTask<?> task) {
            ConcurrCommand command = task.getCommand();
            // wenn das Command abgebrochen wurde, wird die Startzeit gelöscht
            if (task.isCancelled()) {
                String cancelledMsg = "Task was cancelled : " + r.toString() + " User : " + command.getUsername();
                // TODO log the message
                startTimes.remove(r);
                return;
            }
            // Wenn command fertig ist, wird die Statistik aktualisiert
            long executionTime = new Date().getTime() - startTimes.remove(r).getTime();
            ExecutorStats userStats = executorStats.computeIfAbsent(command.getUsername(), u -> new ExecutorStats());
            userStats.addExecutionTime(executionTime);
            userStats.incrementNumOfTasks();
            // TODO
        } else {

            String message = "Exception thrown : " + t.getMessage() + " Task : " + r.toString() + " User : " + ((ConcurrCommand) r).getUsername();
            // TODO log die Exception
        }
    }
}


