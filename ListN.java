
public class ListN {
    Node head;


    public static class Node{
        int value;
        Node next;

    }

    public void revert(){
        if(head != null && head.next != null){
            Node tmp = head;
            revert(head.next, head);
            tmp.next = null;
        }
    }
    private void revert(Node currentNode, Node previouseNode){
        if(currentNode.next == null){
            head = currentNode;
        }
        else{
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previouseNode;
        previouseNode.next = null;

    }
    public static void main(String[] args) {

        ListN list = new ListN();
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();

        node1.value = 1;
        node2.value = 2;
        node3.value = 3;

        list.head = node1;
        node1.next = node2;
        node2.next = node3;

        list.revert();

        Node currentNode = list.head;

        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }
}
