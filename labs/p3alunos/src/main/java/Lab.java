package main.java;

import java.io.FileNotFoundException;
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

    
    /** 
     * Helper para inicializar as impressoras dum laboratorio.
     * @ensures printers != null
     * */
    private void initializePrinters() {
        try(Scanner sc = new Scanner(new File(inputFile))) {
            int n = sc.nextInt();
            this.printers = new Printer[n];

            for (int i = 0; i < n; i++) {
                printers[i] = new Printer(i, buf);
                buf.append(String.format("[TIME: 0] Printer %d online, ready to take jobs.%s", i, EOL));
            }
        } 
        catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
    }

    /**
     * 
     * @param inputFile
     * @throws FileNotFoundException
     */
    public void takeOrders(String inputFile) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(inputFile))) {
        	while (sc.hasNextLine()) {
        		String[] splt = sc.nextLine().split(" ");
        		Job job = new Job(splt[2], Integer.parseInt(splt[3]), Integer.parseInt(splt[4]), Integer.parseInt(splt[0]), Priority.fromString(splt[5])); // ts pmo
            	updateCurrentTime(job.getArrivalTime());

        		processJob(job);
        	}
        	buf.append("All print jobs have been assigned to a printer!" + EOL);
        }
        
        while (!isPrintingFinished()) {        	
        	Printer n = printers[firstPrinterToFinishJob()];
        	
        	n.finishCurrentJob();
        }
        
    
        
    	buf.append("All printing jobs have been processed!");
    }

    /**
     * 
     * @param job
     */
    public void processJob(Job job) {   
    	int n = job.getPriority() == Priority.HIGH ? firstPrinterToFinishHigh() : firstPrinterToFinish();
    	printers[n].addJob(job);
    	
    	System.out.println(String.format("[TIME: %d] Job %s (%s) scheduled to printer %d, printing will take %d.%s", job.getArrivalTime(), job.getModelName(), job.getPriority().toString(), n, job.getModelPrintTime(), EOL));
        buf.append(String.format("[TIME: %d] Job %s (%s) scheduled to printer %d, printing will take %d.%s", job.getArrivalTime(), job.getModelName(), job.getPriority().toString(), n, job.getPrintingDuration(), EOL));
    }

    /**
     * 
     * @return
     */
    public int firstPrinterToFinish() {
    	int lg = 0;
        for (int i = 1; i < printers.length; i++) {
        	int totalI = printers[i].timeToFinishNormal() + printers[i].timeToFinishHigh();
        	int totalLg = printers[lg].timeToFinishNormal() + printers[lg].timeToFinishHigh();
        	if (totalI < totalLg) {
        		lg = i;
        	}
        }
        return lg;
    }

    /**
     * 
     * @return
     */
    public int firstPrinterToFinishHigh() {
    	int n = 0;
        for (int i = 1; i < printers.length; i++) {        	
        	if (printers[i].timeToFinishHigh() < printers[n].timeToFinishHigh()) {
        		n = i;
        	} else if (printers[i].timeToFinishHigh() == printers[n].timeToFinishHigh()) {
        		n = firstPrinterToFinish();
        	}
        }
        
        return n;
    }

    
    public int firstPrinterToFinishJob() {
    	int n = 0;
  
    	if (isPrintingFinished()) {
    		return 0;
    	}
    	
    	for (int i = 0; i < printers.length; i++) {
    		while (printers[n].currentJob() == null) {
    			n++;
    		}
    		
    		if (printers[i].currentJob() == null) {
    			continue;
    		}
  
    		
			Job jobi = printers[i].currentJob();
			Job jobn = printers[n].currentJob();
			
			if (jobi.getPrintingDuration() < jobn.getPrintingDuration()) {
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
     * Updates current time for all printers.
     * */
    private void updateCurrentTime(int time) {
    	for (int i = 0; i < printers.length; i++) {
    		int n = firstPrinterToFinishJob();
    		
    		if (printers[n].currentJob() != null)
    			printers[n].printUntilTime(time);
    	}
    }
}
