package main.java;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Lab {

    public static final String EOL = System.lineSeparator();
    private Printer[] printers;
    private final StringBuilder buf;
    private final String inputFile;
    
    /**
     * 
     * @param inputFile
     * @param sb
     */
    public Lab(String inputFile, StringBuilder sb) {
        this.buf = sb;
        this.inputFile = inputFile;
        initializePrinters();
    }

    private void initializePrinters() {
		try(Scanner sc = new Scanner(new File(inputFile))) {
			int n = sc.nextInt();
			printers = new Printer[n];
			
			for (int i = 0; i < n; i++) {
				printers[i] = new Printer(i, buf);
				buf.append(String.format("[TIME: 0] Printer %d online, ready to take jobs.%s", i, EOL));
			}
			
		} catch (FileNotFoundException e) {
			
		}
		
	}

	/**
     * 
     * @param inputFile
     * @throws FileNotFoundException
     */
    public void takeOrders(String inputFile) throws FileNotFoundException {
    	try(Scanner sc = new Scanner(new File(inputFile))) {
        	int prevTime = 0; // keeping track of previous arrival time
        	while (sc.hasNextLine()) {
        		String[] splt = sc.nextLine().split(" ");
        		Job job = new Job(splt[2], Integer.parseInt(splt[3]), Integer.parseInt(splt[4]), Integer.parseInt(splt[0]), priorityFromString(splt[5]));	
        		
        		if (job.getArrivalTime() != prevTime) {
    				syncPrinters(job.getArrivalTime());
    				prevTime = job.getArrivalTime();
        		}
        		processJob(job);
        	}
        }
        buf.append("All print jobs have been assigned to a printer!" + EOL);
        
        // flushes out remaining jobs.
        while (!isPrintingFinished()) {
        	int n = firstPrinterToFinishJob();
        	int duration = printers[n].currentJob().getPrintingDuration();
        	printers[n].printCurrentJob(duration);
        	
        	// needs to update all the other printers as well....
        }
        
        buf.append("All printing jobs have been processed!");
    }
    

	private boolean isValueIn(int n, int[] vals) {
		for (int i : vals) {
			if (n == i) {
				return true;
			}
		}
		return false;
	}
	
	
	private void syncPrinters(int duration) {
		// sync all printers in the right order.
		final int[] alreadySynced = new int[printers.length];
		Arrays.fill(alreadySynced, -1);
				
		// first printer is a bit of a special case.
		final int first = firstPrinterToFinishJob(); // needed.
		printers[first].printUntilTime(duration);
		alreadySynced[0] = first;
		
		for (int i = 1; i < alreadySynced.length; i++) {
			final int n = findnThPrinterToFinishJob(alreadySynced);
			printers[n].printUntilTime(duration);
			alreadySynced[i] = n;
		}
	}
	
	/** 
	 * @param excluded: values excluded from comparison.
	 * */
	private int findnThPrinterToFinishJob(int[] excluded) {
		int lg = 0;
		
		while (isValueIn(lg, excluded)) {
			lg++;
		}
		
		for (int i = 0; i < printers.length; i++) {
			if (printers[i].isEmpty() || isValueIn(i, excluded)) {
				continue;
			
			} else if (printers[i].currentJob().getPrintingDuration() < printers[lg].currentJob().getPrintingDuration()) {
				lg = i;
			}
		}
		
		return lg;
	}

	private static Priority priorityFromString(String s) {
    	return s.equalsIgnoreCase("HIGH") ? Priority.HIGH : Priority.NORMAL;
    }

    /**
     * 
     * @param job
     */
    public void processJob(Job job) {  
    	int n = job.getPriority() == Priority.HIGH ? firstPrinterToFinishHigh() : firstPrinterToFinish();
		printers[n].addJob(job);
		buf.append(String.format("[TIME: %d] Job %s (%s) scheduled to printer %d, printing will take %d.%s", job.getArrivalTime(), job.getModelName(), job.getPriority(), printers[n].getPrinterId(), job.getPrintingDuration(), EOL));
    }

    /**
     * 
     * @return
     */
    public int firstPrinterToFinish() {
    	int n = 0;
    	
    	for (int i = 1; i < printers.length; i++) {
    		int timeI = printers[i].timeToFinishHigh() + printers[i].timeToFinishNormal();
    		int timeN = printers[n].timeToFinishHigh() + printers[n].timeToFinishNormal();
    		
    		if (timeI < timeN) {
    			n = i;
    		}
    	}
    	return n;	
    }

    /**
     * 
     * @return
     */
    public int firstPrinterToFinishHigh() {
    	int n = 0;
    	boolean draw = false;

    	for (int i = 1; i < printers.length; i++) {    		
    		if (printers[i].timeToFinishHigh() < printers[n].timeToFinishHigh()) {
    			draw = false;
    			n = i;
    		
    		} else if (printers[i].timeToFinishHigh() == printers[n].timeToFinishHigh()) {
    			draw = true;
    		}
    	}
    	return draw ? firstPrinterToFinish() : n;
    }

    
    public int firstPrinterToFinishJob() {
    	int n = firstNonEmptyPrinter();
    	
    	for (int i = n+1; i < printers.length; i++) {
    		Job job = printers[i].currentJob();
    		Job nJob = printers[n].currentJob();
    		if (job != null && job.getPrintingDuration() < nJob.getPrintingDuration()) {
    			n = i;
    		}
    	}
    	
    	return n;
    }

    /**
     * 
     * @return
     */
    public boolean isPrintingFinished() {
        for (Printer p : printers) {
        	if (!p.isEmpty()) {
        		return false;
        	}
        }
        return true;
    }
    
    
    /** 
     * Returns the first non-empty printer.
     * */
    private int firstNonEmptyPrinter() {
    	for (Printer p : printers) {
    		if (!p.isEmpty()) {
    			return p.getPrinterId();
    		}
    	}
    	return -1;
    }
}
