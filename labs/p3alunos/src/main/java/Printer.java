package main.java;

import main.resources.ArrayQueue;
import main.resources.Queue;

public class Printer {
    
    public static final String EOL = System.lineSeparator();

    private final int printerId;
    private final StringBuilder buf;
    private int timeToFinishHigh;
    private int timeToFinishNormal;
    private int currentTime;
    private final Queue<Job> highQueue;
    private final Queue<Job> normalQueue;

    /**
     * 
     * @param printerId
     * @param sb
     */
    public Printer(int printerId, StringBuilder sb) {
        this.printerId = printerId;
        this.buf = sb;

        this.highQueue = new ArrayQueue<>();
        this.normalQueue = new ArrayQueue<>();
    }

    /**
     * 
     * @return
     */
    public int getPrinterId() {
        return printerId;
    }

    /**
     * 
     * @return
     */
    public int currentTime() {
        return currentTime;
    }

    /**
     * 
     * @return
     */
    public int timeToFinishHigh() {
        return timeToFinishHigh;
    }

    /**
     * 
     * @return
     */
    public int timeToFinishNormal() {
        return timeToFinishNormal;
    }
    
    public void setCurrentTime(int time) {
    	this.currentTime = time;
    }

    /**
     * 
     * @param job
     */
    public void addJob(Job job) {
        if (job.getPriority() == Priority.HIGH) {
        	timeToFinishHigh += job.getModelPrintTime() * job.getNumberCopies();
        	highQueue.enqueue(job);
        } else {
        	normalQueue.enqueue(job);
        	timeToFinishNormal += job.getModelPrintTime() * job.getNumberCopies();
        }
        
    }

    /**
     * 
     * @return job being currently handled.
     */
    public Job currentJob() {
    	return highQueue.isEmpty() ? normalQueue.front() : highQueue.front();
    }

    /**
     * 
     * @param duration
     */
    public void printCurrentJob(int duration) {
    	Job job = currentJob();
        assert(duration <= job.getModelPrintTime());
        
        timeToFinishHigh -= duration;
        timeToFinishNormal -= duration;

        currentTime += duration;
    }

    /**
     * @ensures currentJob() != null
     */
    public void finishCurrentJob() {
    	Job job = currentJob();
    	if (job != null) {
    		job.setStatus(Status.FINISHED);
    		currentTime += job.getModelPrintTime();
    		buf.append(String.format("[TIME: %d] Job %s has finished printing. Total wait time: %d.%s", currentTime, job.getModelName(), currentTime - job.getArrivalTime(), EOL));

    		if (job.getPriority() == Priority.HIGH) {
    			highQueue.dequeue();
            	timeToFinishHigh -= job.getModelPrintTime() * job.getNumberCopies();
    		
    		} else {
            	timeToFinishNormal -= job.getModelPrintTime() * job.getNumberCopies();
    			normalQueue.dequeue();
    		}
    		job.setPrintingDuration(0);
    	}
    }

    /**
     * 
     * @return
     */
    public boolean isEmpty() {
        return normalQueue.isEmpty() && highQueue.isEmpty();
    }

    /**
     * 
     * @param duration
     */
    public void printForDuration(int duration) {
    	int initialDuration = duration;
    	Job job = currentJob();
    
    	while (job != null) {
    		job = currentJob();
    		
    		int i;
    		for (i = 0; i < job.getNumberCopies() && duration - job.getModelPrintTime() > 0; i++) {
    			duration -= job.getModelPrintTime();
    		}
    		
    		// copies left.
    		if (duration - (job.getNumberCopies() - i)*job.getModelPrintTime() < 0) {
    			job.setPrintingDuration((job.getNumberCopies() - i)*job.getModelPrintTime() - duration);
    			break;
    		
    		} else {
    			finishCurrentJob();
    		}
    		
    		
    	}
    	
    	// if there's still a job to be handled.
    	if (job != null) {
    		if (job.getPriority() == Priority.HIGH) {
    			timeToFinishHigh -= duration;
    		} else {
        		timeToFinishNormal -= duration;
    		}
    		
    		job.setPrintingDuration(job.getModelPrintTime() - duration);
    	}
    	currentTime += initialDuration;
    	
    }

    /**
     * @requires currentJob() != null
     * @param time
     */
    public void printUntilTime(int time) {
    	while (currentTime < time) {
    		printForDuration(time);
    	}
        
    }
}
