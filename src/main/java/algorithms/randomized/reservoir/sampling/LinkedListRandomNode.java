package algorithms.randomized.reservoir.sampling;

import algorithms.ListNode;

import java.util.Random;

/**
 * 382. Linked List Random Node
 * 
 */
public class LinkedListRandomNode {

    private ListNode head;
    private int[] array;
    private Random random;


    /**
     * Time: O(1)
     * Space: O(1)
     */
    public void initReservoirSampling(ListNode head) {
        this.head = head;
    }

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public LinkedListRandomNode(ListNode head) {
        ListNode iterator = head;
        int size = 0;
        while (iterator != null) {
            iterator = iterator.next;
            size++;
        }
        array = new int[size];
        iterator = head;
        int i = 0;
        while (iterator != null) {
            array[i] = iterator.val;
            iterator = iterator.next;
            i++;
        }
        random = new Random();
    }

    /**
     * On each step we pick the element with the probability = 1 / i (k / i for reservoir, whe k is reservoir size)
     * It can be shown that for n element the probability to pick one of them is 1 / n for such algorithm (Algorithm R)
     * Time: O(n)
     * Space: O(1)
     */
    public int getRandomReservoirSampling() {
        int pickedElement = head.val;
        int i = 2;
        ListNode iterator = head.next;
        while (iterator != null) {
            if (Math.random() < (double) 1 / i) {
                pickedElement = iterator.val;
            }
            i++;
            iterator = iterator.next;
        }
        return pickedElement;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public int getRandom() {
        int index = random.nextInt(array.length);
        return array[index];
    }
}
