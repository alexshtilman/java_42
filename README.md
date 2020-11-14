1. Write application that allows synchronizing the printer threads
   1. The number of threads should be defined at constant N_PRINTERS (For example, 4)
   1. Each thread should print N_NUMBERS (for example, 100 ) by N_PORTIONS (for example, 10). in the following form (Assumption: N_NUMBERS % N_PORTIONS is 0)
   1. Implementation should be based on sleep/interrupt synchronization
Implementation note: Create chain of the printer-threads so that in each thread, there is a reference to the next thread and the last one contains the reference to the first. The controller interrupts the first thread and finishes. Thus, the chain starts working. Portion printing is performing at the interruption catch. After printing, a thread interrupts the next one and goes to sleep. Once a thread finishes printing all numbers (N_NUMBERS) the thread will go to the state “dead”.


