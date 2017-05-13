package sample.web.ui;

public class Test {
	public int[] queueResult(int queueNums, int msgNums, int expandTime, int sendSpeed,
            int consumeSpeed, int targetTime) {
        boolean resize = (targetTime > expandTime);
        if (resize) {
            int[] result = new int[2 * queueNums];
            int[] msgRec = new int[result.length];
            int[] msgRecTime = new int[result.length];
            int msgSent = sendSpeed * targetTime > msgNums ? msgNums : sendSpeed * targetTime;
            int msgSent1 = sendSpeed * expandTime > msgNums ? msgNums : sendSpeed * expandTime;
            for (int i = 1; i <= queueNums; i++) {
                msgRec[i - 1] = i <= msgSent1 % queueNums ? (msgSent1 / queueNums + 1)
                        : msgSent1 / queueNums;
                msgRecTime[i - 1] = i / sendSpeed;
                msgRec[queueNums - 1 + i] = i < (msgSent - msgSent1) % queueNums
                        ? ((msgSent - msgSent1) / queueNums + 1) : (msgSent - msgSent1) / queueNums;
                msgRecTime[queueNums - 1 + i] = expandTime + i / sendSpeed;

                if ((targetTime - msgRecTime[i-1]) * consumeSpeed >= msgRec[i-1]) {
                    result[i-1] = msgRec[i-1];
                    result[queueNums - 1 + i] = (targetTime - msgRecTime[i-1]) * consumeSpeed
                            - msgRec[i-1];
                } else {
                    result[i-1] = (targetTime - msgRecTime[i-1]) * consumeSpeed;
                    result[queueNums - 1 + i] = 0;
                }

            }

            return result;
        } else {
            int[] result = new int[queueNums];
            int[] msgRec = new int[result.length];
            int[] msgRecTime = new int[result.length];
            int msgSent = sendSpeed * targetTime > msgNums ? msgNums : sendSpeed * targetTime;
            for (int i = 1; i <= queueNums; i++) {
                msgRec[i - 1] = i <= msgSent % queueNums ? (msgSent / queueNums + 1)
                        : msgSent / queueNums; 
                msgRecTime[i - 1] = i / sendSpeed;
                result[i-1] = (targetTime - msgRecTime[i-1]) * consumeSpeed;
            }

            return result;
        }
    }
	public static void main(String a[]) {
		Test t = new Test();
		int[] res = t.queueResult(5, 10, 10, 2, 2, 20);
		for(int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}
}
