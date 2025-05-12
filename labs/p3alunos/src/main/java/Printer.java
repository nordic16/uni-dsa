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
    	this.highQueue = new ArrayQueue<Job>();
    	this.normalQueue = new ArrayQueue<Job>();
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

    /**
     * 
     * @param job
     */
    public void addJob(Job job) {
    	job.setStatus(Status.WAITING);
    	if (job.getPriority() == Priority.HIGH) {
    		highQueue.enqueue(job);
    		timeToFinishHigh += job.getPrintingDuration();
    	} else {
    		normalQueue.enqueue(job);
    		timeToFinishNormal += job.getPrintingDuration();
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
     * @param duration
     */
    public void printCurrentJob(int duration) {
    	int i;
    	int initialDuration = duration;
    	Job job = currentJob();
    	assert(duration <= job.getPrintingDuration());
    	
		currentTime += initialDuration;
		
		// note: finishCurrentJob() does NOT manipulate any time variables in any way.
		if (job.getPriority() == Priority.HIGH) {
    		timeToFinishHigh -= initialDuration;
		} else {
			timeToFinishNormal -= initialDuration;
		}
    	
    	// calculates how many copies can be printed out before @duration.
    	for (i = 0; duration - job.getModelPrintTime() >= 0 && i < job.getNumberCopies(); i++) {	
    		duration -= job.getModelPrintTime();
    	}
    	
    	job.setPrintingDuration(job.getPrintingDuration() - job.getModelPrintTime()*i);
    	if (i < job.getNumberCopies()) { // job not finished yet...
    		// append copy left halfway printed.
    		int remaining = job.getModelPrintTime() - duration;
    		job.setPrintingDuration(job.getPrintingDuration() - remaining);

    	} else {
    		finishCurrentJob();
    	}
    }

    /**
     * @ensures currentJob() != null
     */
    public void finishCurrentJob() {
    	Job job = currentJob();
    	job.setStatus(Status.FINISHED);
    	
    	// can't use getPrintingDuration because that was changed previously.
    	
    	if (job.getPriority() == Priority.HIGH) {
    		highQueue.dequeue();
    	} else {
    		normalQueue.dequeue();
    	}
    	buf.append(String.format("[TIME: %d] Job %s has finished printing. Total wait time: %d.%s", currentTime, job.getModelName(), currentTime - job.getArrivalTime(), EOL));
    }

    /**
     * 
     * @return
     */
    public boolean isEmpty() {
    	return highQueue.isEmpty() && normalQueue.isEmpty();
    }

    /**
     * 
     * @param duration
     */
    public void printForDuration(int duration) {
    	int projectedTime = currentTime + duration;
    	Job job = currentJob();
    	if (job != null) {
    		while (currentTime < projectedTime && currentJob() != null) {
    			int delta = 0;
    			// prevents assertion error...
    			if (job.getPrintingDuration() + currentTime <= projectedTime) {
    				delta = job.getPrintingDuration();
    			} else {
    				delta = projectedTime - currentTime;
    			}
    			
				int remainder = duration - job.getPrintingDuration();
				printCurrentJob(delta);
    			
    			job = currentJob();
    			
    			// important: if next job is null, extra time must be added, since otherwise it'd be ignored.
    			if (job == null && remainder > 0) {
    				currentTime += remainder;
    			}
    	    }
    	} else {
        	currentTime += duration;
    	}    	
    }

    /**
     * @requires currentJob() != null
     * @param time
     */
    public void printUntilTime(int time) {
    	assert(time >= currentTime);
    	printForDuration(time - currentTime);
    }
}
