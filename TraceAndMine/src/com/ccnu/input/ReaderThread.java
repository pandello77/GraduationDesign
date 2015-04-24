package com.ccnu.input;

public class ReaderThread implements Runnable {
	int lineNumber;
	Buffer buffer;

	public ReaderThread(Buffer buffer, int lineNumber) {
		this.lineNumber = lineNumber;
		this.buffer = buffer;
	}

	public void run() {
		int tempLineNum=lineNumber;
		for (int i = 0; i < 2*Buffer._bufferSize+1; i++) {
			try {
				tempLineNum = (i%Buffer._bufferSize);
				int data=buffer.read(tempLineNum);
				System.out.println("read"+tempLineNum+"ֵ"+data);
				 Thread.sleep((long) (0.2*Math.random()%19));  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
