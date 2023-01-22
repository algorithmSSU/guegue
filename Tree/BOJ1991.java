import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1991 {
    static int n;
    static Tree tree;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tree = new Tree();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree.addNode(parent, left, right);
        }


    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        tree.printPreorder(tree.root);
        System.out.println();
        tree.printInorder(tree.root);
        System.out.println();
        tree.printPostorder(tree.root);
        System.out.println();
    }

    static class Node {
        char data;
        Node leftChild;
        Node rightChild;

        public Node(char data){
            this.data = data;
        }
    }

    static class Tree {
        Node root = null;

        void addNode(char data, char leftChildData, char rightChildData){
            if(root == null){
                root = new Node(data);
                root.leftChild = (leftChildData != '.') ? new Node(leftChildData) : null;
                root.rightChild= (rightChildData != '.') ? new Node(rightChildData) : null;
            }else{
                findAndAddNode(this.root, data, leftChildData, rightChildData);
            }
        }

        void findAndAddNode(Node node, char targetData, char leftChildData, char rightChildData){
            if(node.data == targetData){
                node.leftChild = (leftChildData != '.') ? new Node(leftChildData) : null;
                node.rightChild= (rightChildData != '.') ? new Node(rightChildData) : null;
                return;
            }

            if(node.leftChild != null){
                findAndAddNode(node.leftChild, targetData, leftChildData, rightChildData);
            }

            if(node.rightChild != null){
                findAndAddNode(node.rightChild, targetData, leftChildData, rightChildData);
            }
        }

        void printPreorder(Node node){
            if(node == null)
                return;

            System.out.print(node.data);
            printPreorder(node.leftChild);
            printPreorder(node.rightChild);
        }

        void printInorder(Node node){
            if(node == null)
                return;

            printInorder(node.leftChild);
            System.out.print(node.data);
            printInorder(node.rightChild);
        }

        void printPostorder(Node node){
            if(node == null)
                return;

            printPostorder(node.leftChild);
            printPostorder(node.rightChild);
            System.out.print(node.data);
        }
    }
}

