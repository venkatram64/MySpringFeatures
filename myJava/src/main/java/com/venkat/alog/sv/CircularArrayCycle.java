package com.venkat.alog.sv;


/*- We'll take two variable slow & fast
        - Here each value represent the jump it'll make. Positive means forward direction & negative means backward direction
        - Slow will move by 1 position & fast will move by 2 position. If slow & fast meet at any index, then it means cycle is possible.
        - We'll iterate for each point & if at any case, it's not possible, then we check for next index.
        - If we don't find cycle, then we return false*/
public class CircularArrayCycle {

    public static boolean checkifCircularArrayHasCycle(int [] arr){
        for(int i = 0; i < arr.length; i++){
            int slow, fast;
            slow = fast = i;
            boolean ifforward = arr[i] > 0;
            while (true){
                slow = getNextPosition(arr, fast, ifforward);
                if(slow == -1){
                    break;
                }
                fast = getNextPosition(arr, fast, ifforward);
                if(fast == -1){
                    break;
                }
                fast = getNextPosition(arr, fast, ifforward);
                if(fast == -1){
                    break;
                }
                fast = getNextPosition(arr, fast, ifforward);
                if (fast == -1){
                    break;
                }
                fast = getNextPosition(arr, fast, ifforward);
                if(fast == -1){
                    break;
                }
                if(slow == fast){
                    return true;
                }
            }
        }
        return false;
    }

    private static int getNextPosition(int[] arr, int index, boolean ifforward){
        boolean direction = arr[index] >= 0;

        if(direction != ifforward){
            return -1;
        }
        int nextIndex = (index + arr[index]) % arr.length;
        if(nextIndex < 0){
            nextIndex = nextIndex + arr.length;
        }
        if(nextIndex == index){
            return -1;
        }
        return nextIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 2};
        System.out.println(checkifCircularArrayHasCycle(arr));
    }
}
