package com.assignment.hw3_Part2;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;
import org.apache.hadoop.io.WritableUtils;

public class AverageTuple implements Writable{

	private String year;
    private double count;
    private double average;
    
    public AverageTuple(){}

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
    public void write(DataOutput d) throws IOException {
         WritableUtils.writeString(d, year);
         WritableUtils.writeString(d, String.valueOf(count));
         WritableUtils.writeString(d, String.valueOf(average));
    }

    public void readFields(DataInput di) throws IOException {
        year = WritableUtils.readString(di);
        count = Double.valueOf(WritableUtils.readString(di));
        average = Double.valueOf(WritableUtils.readString(di));
    }

  
    
    @Override
    public String toString(){
        return new StringBuffer().append("\t").append(average).toString();
    }

}
