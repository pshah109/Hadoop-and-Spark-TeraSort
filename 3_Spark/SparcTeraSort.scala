val experiment = sc.textFile("hdfs://ec2-52-90-250-38.compute-1.amazonaws.com/input.txt")
//Reading the input file from the provided hdfs path 
val sorting = lines.sortBy[String]( (line:String) => { val split = line.split("  "); split(0) + "  " + split(1) },true,1)
// Once the file is read from the hdfs system each record is splitted in to two halves.
// Once the record is splitted the records are sorted using 10 byte key.
sorting.saveAsTextFile("hdfs://ec2-52-90-250-38.compute-1.amazonaws.com:9000/user/root/output")
//Saving the sorted file at the location provided