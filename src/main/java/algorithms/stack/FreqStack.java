package algorithms.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 895. Maximum Frequency Stack
 */
public class FreqStack {

    private class Node {
        int counter;
        int value;

        public Node(int counter, int value) {
            this.counter = counter;
            this.value = value;
        }
    }

    private int maxFrequency;
    private Map<Integer, LinkedList<Node>> frequencyMap;
    private Map<Integer, LinkedList<Node>> valueMap;

    //node has counter
    //<frequency, linked list of nodes with counter = frequency>
    //<value, linked list of nodes>

    public FreqStack() {
        this.frequencyMap = new HashMap<>();
        this.valueMap = new HashMap<>();
    }

    public void push(int val) {
        //calculate next counter
        LinkedList<Node> nodes = valueMap.getOrDefault(val, new LinkedList<>());
        int nextCounter = 1;
        if (!nodes.isEmpty()) {
            nextCounter = nodes.getLast().counter + 1;
        }

        //create node
        Node newNode = new Node(nextCounter, val);

        //add to valueMap
        nodes.add(newNode);
        valueMap.put(val, nodes);

        //add to frequencyMap
        LinkedList<Node> frequentNodes = frequencyMap.getOrDefault(nextCounter, new LinkedList<>());
        frequentNodes.add(newNode);
        frequencyMap.put(nextCounter, frequentNodes);

        maxFrequency = Math.max(maxFrequency, nextCounter);
    }

    public int pop() {
        LinkedList<Node> mostFrequentNodes = frequencyMap.get(maxFrequency);
        int result = mostFrequentNodes.pollLast().value;

        //remove if there is no elements with the same frequency
        if (mostFrequentNodes.isEmpty()) {
            maxFrequency--;
        }

        //remove from valueMap
        valueMap.get(result).removeLast();

        return result;
    }
}
