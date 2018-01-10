package com.assignment.hw3_Part2;

import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.Reducer.Context;

public class StockAverageReducer extends Reducer<Text, AverageTuple, Text, AverageTuple>{
	private AverageTuple result = new AverageTuple();
	public void reduce(Text key, Iterable<AverageTuple> values, Context context) throws IOException, InterruptedException{
		int count = 0;
		double price = 0;
		
		for(AverageTuple val : values){
			price += val.getCount() * val.getAverage();
			count += val.getCount();
		}
		result.setCount(count);
		result.setAverage(price/count);
		
		context.write(key, result);
	}
}
