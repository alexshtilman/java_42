package telran.util;

public class ShceduldingAppl {
	public static final int N_NUMBERS = 103;
	public static final int N_PORTIONS = 10;
	private static final int N_PRINTERS = 4;
	
	public static void main(String[] args) {
		LinkedThread[] printers =  new LinkedThread[N_PRINTERS];
		
		for(int i=0;i<N_PRINTERS;i++) {
			printers[i]=new LinkedThread(N_NUMBERS,N_PORTIONS,""+i);	
		}
		for(int i=0;i<N_PRINTERS-1;i++) {
			printers[i].setNext(printers[i+1]);
		}
		printers[N_PRINTERS-1].setNext(printers[0]);
		for(LinkedThread printer:printers) {
			printer.start();
		}
		printers[0].interrupt();
	}

}
