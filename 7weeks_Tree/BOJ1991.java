import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Node {
    char data;
    Node leftChild;
    Node rightChild;

    public Node(char data) {
        this.data = data;
    }
}
class Tree {
    /*
    Node class 구현
     */


    /*
    Tree 구현
     */
    Node root;

    public void createNode(char data, char leftData, char rightData) {
        if (root == null) {
            this.root = new Node(data);
            root.leftChild = (leftData != '.') ? new Node(leftData) : null;
            root.rightChild = (rightData != '.') ? new Node(rightData) : null;
        } else {
            findNodeAndCreate(this.root, data, leftData, rightData);
        }
    }

    public void findNodeAndCreate(Node node, char targetData, char leftData, char rightData) {
        if (node == null) {
            return;
        } else if (node.data == targetData) {
            node.leftChild = (leftData != '.') ? new Node(leftData) : null;
            node.rightChild = (rightData != '.') ? new Node(rightData) : null;
        } else {
            findNodeAndCreate(node.leftChild, targetData, leftData, rightData);
            findNodeAndCreate(node.rightChild, targetData, leftData, rightData);
        }
    }

    public void preOrder(Node node) {
        if(node != null) {
            System.out.print(node.data);
            if(node.leftChild != null) {inOrder(node.leftChild);}
            if(node.rightChild != null) {inOrder(node.rightChild);}
        }
    }

    public void inOrder(Node node) {
        if(node != null) {
            if(node.leftChild != null) {inOrder(node.leftChild);}
            System.out.print(node.data);
            if(node.rightChild != null) {inOrder(node.rightChild);}
        }
    }

    public void postOrder(Node node) {
        if(node != null) {
            if(node.leftChild != null) {inOrder(node.leftChild);}
            if(node.rightChild != null) {inOrder(node.rightChild);}
            System.out.print(node.data);
        }
    }

}

public class BOJ1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Tree t = new Tree();
        for(int i = 0 ; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            t.createNode(root, left, right);
        }

        t.preOrder(t.root);
        System.out.println();
        t.inOrder(t.root);
        System.out.println();
        t.postOrder(t.root);
    }
}


/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */
