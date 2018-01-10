package com.assignment.hw3_Part2;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StockAverageMapper extends Mapper<Object, Text, Text, AverageTuple> {
	private final static SimpleDateFormat frmt = new SimpleDateFormat("yyyy");
	private AverageTuple outValue = new AverageTuple();
	private Text outKey = new Text();
	public void map(Object key, Text value, Context context) throws IOException, InterruptedException
	{
		try {
			String[] fields = value.toString().split(",");
			String stockName = fields[1];
			String str = fields[2];
			Date date = frmt.parse(str);
			Double price = Double.valueOf(fields[8]) ;
			String year = frmt.format(date);
			
			outKey.set(stockName + "  " + year);
			outValue.setAverage(price);
			outValue.setCount(1);
			context.write(outKey,  outValue);
			
		} catch (NumberFormatException e) {
			
		} catch (ParseException e) {
			
		}
	}
}






















