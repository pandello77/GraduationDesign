package com.ccnu.input;

public class AddThread implements Runnable {
	int lineNumber;
	Buffer buffer;

	public AddThread(Buffer buffer, int lineNumber) {
		this.lineNumber = lineNumber;
		this.buffer = buffer;
	}

	public void run() {
		int tempLineNum=lineNumber;
		for (int i = 0; i < Buffer._bufferSize; i++) {
			try {
				int data=buffer.add(tempLineNum);
				System.out.println("addW" + tempLineNum + "ÐÐ" +Buffer._bufferSize+ "Öµ" + data);
//				tempLineNum = tempLineNum + 1;
				tempLineNum = (tempLineNum + 1)%Buffer._bufferSize;
				 Thread.sleep((long) (Math.random()%19)); 
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
