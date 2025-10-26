import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

public class DataStructures {

    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class CircularLinkedList {
        private Node head;
        public CircularLinkedList() {
            this.head = null;
        }

        public void display() {
            if (head == null) {
                System.out.println("The Circular Linked List is empty.");
                return;
            }
            Node current = head;
            StringBuilder sb = new StringBuilder();
            do {
                sb.append(current.data);
                current = current.next;
                if (current != head) {
                    sb.append(" -> ");
                }
            } while (current != head);
            System.out.println(sb.toString() + " (-> Head)");
        }

        public void insertAtN(int data, int position) {
            Node newNode = new Node(data);
            if (position < 1) {
                System.out.println("Error: Position must be 1 or greater.");
                return;
            }
            if (head == null) {
                if (position == 1) {
                    head = newNode;
                    newNode.next = head;
                    System.out.println("Node '" + data + "' inserted as the first element.");
                } else {
                    System.out.println("Error: List is empty, cannot insert at position " + position + ".");
                }
                return;
            }
            if (position == 1) {
                Node current = head;
                while (current.next != head) {
                    current = current.next;
                }
                newNode.next = head;
                head = newNode;
                current.next = head;
                System.out.println("Node '" + data + "' inserted at position 1 (new head).");
                return;
            }
            Node current = head;
            for (int i = 1; i < position - 1; i++) {
                current = current.next;
                if (current == head) {
                    System.out.println("Error: Position " + position + " is out of bounds.");
                    return;
                }
            }
            newNode.next = current.next;
            current.next = newNode;
            System.out.println("Node '" + data + "' inserted at position " + position + ".");
        }

        public void deleteByData(int data) {
            if (head == null) {
                System.out.println("Error: List is empty, cannot delete.");
                return;
            }
            Node current = head;
            Node previous = null;
            do {
                if (current.data == data) {
                    if (current == head && current.next == head) {
                        head = null;
                        System.out.println("Node '" + data + "' deleted. List is now empty.");
                        return;
                    }
                    if (current == head) {
                        Node temp = head;
                        while (temp.next != head) {
                            temp = temp.next;
                        }
                        head = head.next;
                        temp.next = head;
                        System.out.println("Head node '" + data + "' deleted.");
                        return;
                    }
                    previous.next = current.next;
                    System.out.println("Node '" + data + "' deleted.");
                    return;
                }
                previous = current;
                current = current.next;
            } while (current != head);
            System.out.println("Error: Node with data '" + data + "' not found.");
        }

        public void modifyNode(int oldData, int newData) {
            if (head == null) {
                System.out.println("Error: List is empty, nothing to modify.");
                return;
            }
            Node current = head;
            do {
                if (current.data == oldData) {
                    current.data = newData;
                    System.out.println("Node data '" + oldData + "' modified to '" + newData + "'.");
                    return;
                }
                current = current.next;
            } while (current != head);
            System.out.println("Error: Node with data '" + oldData + "' not found for modification.");
        }
    }

    static class DynamicCircularQueue {
        private Queue<String> items;
        public DynamicCircularQueue() {
            this.items = new LinkedList<>();
        }
        public void enqueue(String item) {
            items.add(item);
            System.out.println("Enqueued: " + item);
        }
        public String dequeue() {
            if (items.isEmpty()) {
                System.out.println("Error: Queue is empty.");
                return null;
            }
            String item = items.poll();
            System.out.println("Dequeued: " + item);
            return item;
        }
        public void display() {
            if (items.isEmpty()) {
                System.out.println("Queue is empty.");
            } else {
                System.out.println("Queue (Front -> Rear): " + items);
            }
        }
        public int size() {
            return items.size();
        }
    }

    public static void quickSortStrings(String[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(String[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static class BSTNode {
        int data;
        BSTNode left, right;
        public BSTNode(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    static class BinarySearchTree {
        BSTNode root;
        public BinarySearchTree() {
            root = null;
        }
        public void addNode(int data) {
            root = addNodeRecursive(root, data);
            System.out.println("Node '" + data + "' added to BST.");
        }
        private BSTNode addNodeRecursive(BSTNode current, int data) {
            if (current == null) {
                return new BSTNode(data);
            }
            if (data < current.data) {
                current.left = addNodeRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = addNodeRecursive(current.right, data);
            }
            return current;
        }
        public void removeNode(int data) {
            root = removeNodeRecursive(root, data);
            System.out.println("Attempted to remove node '" + data + "'.");
        }
        private BSTNode removeNodeRecursive(BSTNode current, int data) {
            if (current == null) {
                return null;
            }
            if (data < current.data) {
                current.left = removeNodeRecursive(current.left, data);
            } else if (data > current.data) {
                current.right = removeNodeRecursive(current.right, data);
            } else {
                if (current.left == null) {
                    return current.right;
                }
                if (current.right == null) {
                    return current.left;
                }
                current.data = findMinData(current.right);
                current.right = removeNodeRecursive(current.right, current.data);
            }
            return current;
        }
        private int findMinData(BSTNode node) {
            int minVal = node.data;
            while (node.left != null) {
                minVal = node.left.data;
                node = node.left;
            }
            return minVal;
        }
        public void displayTree() {
            System.out.println("\n--- BST Traversal Display ---");
            System.out.print("In-order (Sorted):  ");
            inorder(root);
            System.out.print("\nPre-order (Copy):   ");
            preorder(root);
            System.out.print("\nPost-order (Delete):");
            postorder(root);
            System.out.println("\n-----------------------------");
        }
        public void inorder(BSTNode node) {
            if (node != null) {
                inorder(node.left);
                System.out.print(node.data + " ");
                inorder(node.right);
            }
        }
        public void preorder(BSTNode node) {
            if (node != null) {
                System.out.print(node.data + " ");
                preorder(node.left);
                preorder(node.right);
            }
        }
        public void postorder(BSTNode node) {
            if (node != null) {
                postorder(node.left);
                postorder(node.right);
                System.out.print(node.data + " ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("1. Circular Linked List Demonstration");
        System.out.println("==========================================");
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtN(10, 1);
        cll.insertAtN(20, 2);
        cll.insertAtN(5, 1);
        cll.insertAtN(30, 4);
        cll.display();
        cll.modifyNode(20, 25);
        cll.display();
        cll.deleteByData(10);
        cll.deleteByData(5);
        cll.display();

        System.out.println("\n==========================================");
        System.out.println("2. Dynamic Circular Queue Demonstration");
        System.out.println("==========================================");
        DynamicCircularQueue cq = new DynamicCircularQueue();
        cq.enqueue("Alpha");
        cq.enqueue("Beta");
        cq.enqueue("Gamma");
        cq.display();
        cq.dequeue();
        cq.dequeue();
        cq.display();
        cq.enqueue("Delta");
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();

        System.out.println("\n==========================================");
        System.out.println("3. Quick Sort for Strings Demonstration");
        System.out.println("==========================================");
        String[] stringList = {"apple", "zebra", "banana", "kiwi", "grape", "cherry"};
        System.out.println("Original List: " + Arrays.toString(stringList));
        quickSortStrings(stringList);
        System.out.println("Sorted List: " + Arrays.toString(stringList));

        System.out.println("\n==========================================");
        System.out.println("4. Binary Search Tree Demonstration");
        System.out.println("==========================================");
        BinarySearchTree bst = new BinarySearchTree();
        int[] nodesToAdd = {50, 30, 70, 20, 40, 60, 80};
        System.out.println("Adding nodes: " + Arrays.toString(nodesToAdd));
        for (int node : nodesToAdd) {
            bst.addNode(node);
        }
        bst.displayTree();
        bst.removeNode(70);
        bst.displayTree();
        bst.removeNode(30);
        bst.removeNode(99);
        bst.displayTree();
    }
}
