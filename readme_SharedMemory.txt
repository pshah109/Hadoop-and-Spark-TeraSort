The source code , output files and all the snapshots for SharedMemory Tera Sort experiments is placed in 1_Shared_Memory folder.

code Explaination : 

The code for SharedMemory Tera Sort has been implemented in java.

The input file is splitted into large number of small chunks and are sorted parallely using multithreading.
The size of the small chunks depend on available free memory of JVM. We can provided Minimum and Maximum memory for JVM using -Xms and -Xmx 
Commands respectively through the command line .

As soon as the chunk is created that chunks goes in to the sorting phase and this process in running parallely using multithreaded
code i.e creating chunks ands sorting chunks can both work in parallel making maximum use of available cores.

Once all the chunks are sorted , we will take 1st record from each sorted file and put it in to treemap .
After that we will remove the record having least key value and write the record in to the final output file and read a new
record from the file which contained the least key record in tree map. We will keep on reading new records untill all the
intermediate files are empty . Once all the intermediate files are empty we will obtain a fully sorted output file.  


Steps to compile and execute SharedMemory Program

1) The source code for shared Memory Terasort is available in 1_Shared_Memory folder in SharedMemTera.java file.

2) Compile the file using command javac SharedMemTera.java

3)Execute the script SharedMemExp1GB.sh available in 1_Shared_Memory folder using command sh SharedMemExp1GB.sh 
for running 1GB Experiments for 1 to 8 threads

4)Execute the program using following command for 1TB Data Set       

java Xms256m -Xmx28672m SharedMemTera [Number of Threads] [Name of Input File]
 
example :

java -Xms256m -Xmx28672m SharedMemTera 1 input.txt

The first parameter in above line indicate no of threads and second parameter indicates the name of input file

We can vary the first parameter from 1 to 8  to run the experiment for 1 to 8 threads.


