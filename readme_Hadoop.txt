The source code,configuration files,outputfiles and all the snapshots for Hadoop Tera Sort experiments is placed in 2_Hadoop folder.

Code Explanation :

The code for Hadoop Tera Sort is implemented in Java.

The program is partitioned into 2 parts. The mapper task and the reducer task .

The input to the mapper tast will be record offsetid and the record from the input file.
In the mapper task the input record is splitted in to 2 parts namely key and value.
The Key emitted by the mapper is first 10 byte of the record and value will be the remaining part.After the mapper part is completed
all the key will be sorted using Hadoop's Total Order Partion class.

Once the keys are sorted using Hadoop's Total Order Partion class, reducer function will be invoked. The out put key-value 
emitted by reducer will be same as the input to reducer.

In the experiment I have used 32 reducers for obtaining the optimal results. I have used the formulae provided 
on https://hadoop.apache.org to obtain optimal number of reducer.
(The right number of reduces seems to be 0.95 or 1.75 multiplied by (<no. of nodes> * <no. of maximum containers per node>). 

Steps to compile and execute Hadoop Map Reduce Program

1) The source code for Hadoop Map Reduce Program is available in 2_Hadoop folder in  TeraByteSorting.java file

2) Once the hadoop cluster is started follow the below mentioned steps

3) Create Directory in hdfs using following command
	hadoop fs –mkdir /user
	hadoop fs –mkdir /user/ec2-user

2) Create Directory for input file using following command
	hadoop fs -mkdir input

3) Place input.txt file(the file that needs to be sorted) in input folder  
	hadoop fs -put input.txt input

4) Create Directory for partition files using following command
	hadoop fs -mkdir partition

5) Compile TeraByteSorting.java program
	hadoop hadoop com.sun.tools.javac.Main  TeraByteSorting.java

6) Creating jar from .class file
	jar cf  TeraByteSorting.jar  *.class (all the required class files)

7) Executing jar
	hadoop jar TeraByteSorting.jar TeraByteSorting input output partition


8) To get the output from hdfs system
 
	hadoop fs -get output/*

9) Now you can perform valsort on the generated output files