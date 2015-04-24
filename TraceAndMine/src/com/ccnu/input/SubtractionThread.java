package com.ccnu.input;

public class SubtractionThread implements Runnable {
	int lineNumber;
	Buffer buffer;

	public SubtractionThread(Buffer buffer, int lineNumber) {
		this.lineNumber = lineNumber;
		this.buffer = buffer;
	}

	public void run() {
		int tempLineNum=lineNumber;
		for (int i = 0; i < Buffer._bufferSize; i++) {
			try {
				int data=buffer.sub(tempLineNum);
				System.out.println("subW" + tempLineNum + "ÐÐ" + "Öµ" + data);
//				 tempLineNum = tempLineNum + 1;
				tempLineNum = (tempLineNum + 1)%Buffer._bufferSize;
				 Thread.sleep((long) (Math.random()%19));  
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
