package com.ccnu.input;



public class Buffer {
	public int[] dataSet;
	public boolean[] lock;
	static final int _bufferSize=4;
	public Buffer(){
		dataSet=new int[_bufferSize];
		lock=new boolean[_bufferSize];
		for(int i=0;i<_bufferSize;i++){
		lock[i]=false;
		}
	
	}
	public Buffer(Buffer b){
		this.dataSet=b.dataSet;
		this.lock=b.lock;
	}

	
	public int read(int lineNumber) {
		return r(lineNumber);
	}

	public int write(int lineNumber, int data) throws InterruptedException {
		 while (lock[lineNumber]==true) {
			   try { 
                 wait(); 
			   } catch (InterruptedException e) { 
                 e.printStackTrace(); 
			   } 
		   }
		 System.out.println("L"+lineNumber+"data"+data);
		 int d=w(lineNumber, data);
		 lock[lineNumber]=false;
		 return d;
	}
	
	public synchronized int w(int lineNumber, int data){
		 lock[lineNumber]=true; 
		 dataSet[lineNumber] = data;
		 return dataSet[lineNumber];
	}
	public  int r(int lineNumber){
		  int data = dataSet[lineNumber]; 
		  return data;
	}
	public int add(int lineNumber) throws InterruptedException{
		return write(lineNumber,r(lineNumber)+1);
	}
	
	public  int sub(int lineNumber) throws InterruptedException{
		return write(lineNumber,r(lineNumber)-1);	
	}
	public int init(int lineNumber,int data) throws InterruptedException{
		return write(lineNumber,data);
	}
}
