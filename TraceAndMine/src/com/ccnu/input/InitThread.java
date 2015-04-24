package com.ccnu.input;

public class InitThread implements Runnable {
	Buffer buffer;

	public InitThread(Buffer buffer) {
		this.buffer = buffer;
	}

	public void run() {
		for(int i=0;i<Buffer._bufferSize;i++){
			 try {
				 buffer.init(i, i);
//					System.out.println("init"+i+"ֵ"+i);
				Thread.sleep((long) (0.5*Math.random()%19));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}  
		}	
	}

}
