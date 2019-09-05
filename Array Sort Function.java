// Reference: https://www.cnblogs.com/guoyaohua/p/8600214.html

package sortfunctions;

import java.util.Random;
import java.util.Arrays;

public class sortFunctions {
	int[] test=new int[1000];
	
	public sortFunctions() {
		Random random = new Random();
		for(int i=0; i<1000; i++) {
			test[i] = random.nextInt(10000)-5000;
		}
	}
	
	// Reverse Array
	public void reverseArray(int[] nums) {
		int[] tmp = new int[nums.length];
		for(int i=0; i<nums.length; i++) {
			tmp[i] = nums[nums.length-1-i];
		}
		for(int i=0; i<nums.length; i++) {
			nums[i] = tmp[i];
		}
	}
	
	// Bubble Sort, Time: O(n2), Space: O(1), Big->Small
	public void bubbleSort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			for(int j=0; j<nums.length-1-i; j++) {
				if(nums[j]<nums[j+1]) {
					int tmp=nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = tmp;
				}
			}
		}
	}
	
	// Select Sort, Time: O(n2), Space: O(1)
	public void selectSort(int[] nums) {
		for(int i=0; i<nums.length; i++) {
			int index=i;
			for(int j=i; j<nums.length; j++) {
				if(nums[j]<nums[index]) {
					index = j;
				}
			}
			int tmp=nums[i];
			nums[i] = nums[index];
			nums[index] = tmp;
		}
	}
	
	// Insert Sort, Time: O(n2), Space: O(1)
	public void insertSort(int[] nums) {
		for(int i=1; i<nums.length; i++) {
			int flag=nums[i];
			for(int j=i-1; j>=0; j--) {
				if(nums[j]>=flag) {
					nums[j+1]=nums[j];
				}else {
					nums[j+1] = flag;
					break;
				}
			}
			if(nums[0]>flag) {
				nums[0] = flag;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sortFunctions sort = new sortFunctions();
		
		int[] testOne=sort.test.clone();
		int[] testTwo=sort.test.clone();
		
		Arrays.sort(testOne);
		
//		sort.bubbleSort(testTwo);
//		sort.reverseArray(testTwo);
		
//		sort.selectSort(testTwo);
		
		sort.insertSort(testTwo);
		for(int x:testOne) System.out.print(" "+x);
		System.out.println();
		for(int x:testTwo) System.out.print(" "+x);
		System.out.println();
		
//		testTwo[0] = -1;
		
		for(int i=0; i<1000; i++) {
			if(testOne[i]!=testTwo[i]) {
				System.out.println("False!");
				return;
			}
		}
		System.out.println("True!");
	}
}
