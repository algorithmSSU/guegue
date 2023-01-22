import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5639 {
    static BinaryTree tree = new BinaryTree();

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strNum = "";
        while ((strNum = br.readLine()) != null) {
            tree.addNode(Integer.parseInt(strNum));
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        tree.printPostorder(tree.root);
    }


    static class Node {
        int data;
        Node leftChildNode;
        Node rightChildNode;

        public Node(int data) {
            this.data = data;
            leftChildNode = null;
            rightChildNode = null;

        }
    }

    static class BinaryTree {
        Node root = null;

        void addNode(int data) {
            if (root == null) {
                root = new Node(data);
            } else {
                // find targetNode
                Node parentNode = this.root;
                Node thisNode = this.root;
                while (thisNode != null) {
                    if (data < thisNode.data) {
                        parentNode = thisNode;
                        thisNode = thisNode.leftChildNode;
                    } else {
                        parentNode = thisNode;
                        thisNode = thisNode.rightChildNode;
                    }
                }
                if (data < parentNode.data)
                    parentNode.leftChildNode = new Node(data);
                else
                    parentNode.rightChildNode = new Node(data);
            }
        }

        void addNodeRecursive(Node node, int targetData){
            if(root == null){
                root = new Node(targetData);
            }else{
                if(targetData < node.data){     // leftNode
                    if(node.leftChildNode != null) addNodeRecursive(node.leftChildNode, targetData);
                    else node.leftChildNode = new Node(targetData);
                }else{                          // rightNode
                    if(node.rightChildNode != null) addNodeRecursive(node.rightChildNode, targetData);
                    else node.rightChildNode = new Node(targetData);
                }
            }
        }

        void printPostorder(Node node) {
            if (node == null)
                return;

            if (node.leftChildNode != null) printPostorder(node.leftChildNode);
            if (node.rightChildNode != null) printPostorder(node.rightChildNode);
            System.out.println(node.data);
        }
    }
}


/*
아 왜 NULL POINTER..?
 */