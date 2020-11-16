package com.xzdream.map.mapreduce;

import com.xzdream.map.utils.LogUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class LogETLMapper extends Mapper<LongWritable, Text, NullWritable,Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        int length = value.toString().split("\t").length;

        if(length == 3){
            LogUtils logUtils = new LogUtils();
            String result = logUtils.parse(value.toString());

            if(StringUtils.isNotBlank(result)){
                context.write(NullWritable.get(),new Text(result));
            }
        }else {

        }
    }
}
