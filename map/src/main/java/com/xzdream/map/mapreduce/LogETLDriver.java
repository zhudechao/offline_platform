package com.xzdream.map.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

public class LogETLDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        job.setJarByClass(LogETLDriver.class);
        job.setMapperClass(LogETLMapper.class);

        job.setMapOutputKeyClass(NullWritable.class);
        job.setMapOutputValueClass(Text.class);

        String input = args[0];//input/
        String output = args[1];//output/d=2020-1-20

        FileInputFormat.setInputPaths(job,new Path(input));
        FileOutputFormat.setOutputPath(job,new Path(output));

        job.waitForCompletion(true);
    }
}
