The source code,configuration files,outputfiles and all the snapshots for Spark Tera Sort experiments is placed in 3_Spark folder.

Code Explanation:

The source code for Spark Tera Sort is implemented in scala.

First the input  file is read from the hdfs system. Once the file is read from the hdfs system each record is
splitted in to two halves. Once the record is splitted the records are sorted using 10 byte key.
After the execution is completed the output is saved as TextFile in hdfs in the location provided in the program.

While working on 16 nodes and 1TB Dataset with Spark Tera Sorting,  I have measured the time after deducting the failed task time.

Steps to compile and execute Sparc Program for sorting.

1) The source code for Sparc Terasort is available in 3_Sparc folder in SparcTeraSort.scala file.

2) Placing input file(the file to be sorted) in hdfs 

	Navigate to root and execute following command
 
	ephemeral-hdfs/bin/hadoop fs -put input.txt input.txt

2) Open Spark-shell	

	Navigate to  /root/spark/bin and execute command . /spark-shell to run spark-shell

3) In console type :paste and copy your source code and press enter and ctrl + d 

4) The program execution will be started.
 
5) The output of the program will be stored in hdfs in the parth given in source code.