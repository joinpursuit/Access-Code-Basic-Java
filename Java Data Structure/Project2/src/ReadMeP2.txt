Haiqiang Zou
CS313
Project2


1. We need to change the System.out.printf to System.out.printf(fmt, "Mean service time:", (int)MEAN_SERVICE_TIME); code in the program in order to make the program to work.

2. Explain why cars on a toll road make for a good use of queues in an application program.
	it is better to use queue in a toll road application because you need to allow the cars that arrived first to leave first

3. Explain how enqueue and dequeue operations are used in the simulation
	enqueue is used when to add the cars into the queue when they arrived at the roll road.
	dequeue is used to remove the cars from the queue when they have left the toll road.

4. Explain the output for one run of the simulation, using the java code along with the explanations given in the textbook.
	The output displays the number of servers, Clients, mean service time, and mean arrival time, the mean service time for each servers, the cars that is currently in the queue and which server is serving which cars at the time given.


5. Research and explain 2 additonal client-server applications.
	a) Domino's online ordering system uses client-server application. Everytime when they have an order placed online they put the order into a queue and whenever a worker is preparing the online order they remove it from the queue.
	b) Cunyfirst class registering system, when we register for our classes, they also used a queue system base because whoever register the classes first gets into that particular class first.

6. Explain the statistical class ExpRandom 
	the ExpRandom class helps us generate random numbers by using the equation x = -(1/y) ln(1-p). Since we use this equation the random number that is generated will always have a close range to the numbers that we are using.

	