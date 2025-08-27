/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hon.avltreeapp;

import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;




class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

public class AVLTree {
    AVLNode root;

    private int stepCounter = 1;      // bộ đếm bước chung

    public void resetStepCounter() {
        stepCounter = 1;
    }
    
    private int nextStep() {
        return stepCounter++;
    }
    public String preOrder() {
    StringBuilder sb = new StringBuilder();
    preOrderRec(root, sb);
    return sb.toString();
    
    
    
}
    
   
public void readFromFile(File file, JTextArea logArea) {
    resetStepCounter();       
    logArea.setText("");       

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.trim().split("[,\\s]+");
            for (String part : parts) {
                try {
                    int value = Integer.parseInt(part);
                    // Bước tiếp theo
                    logArea.append("B" + nextStep() + ": Thêm nút " 
                                   + value + " từ file\n");
                    // Chèn vào cây, trong insert(...) bạn cũng dùng nextStep()
                    root = insert(root, value, logArea);
                } catch (NumberFormatException e) {
                    logArea.append("B" + nextStep() 
                        + ": Bỏ qua giá trị không hợp lệ: " + part + "\n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Đọc file thành công!");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Lỗi khi đọc file: " + e.getMessage());
    }
}


private void preOrderRec(AVLNode node, StringBuilder sb) {
    if (node != null) {
        sb.append(node.key).append(" ");
        preOrderRec(node.left, sb);
        preOrderRec(node.right, sb);
    }
}


public String inOrder() {
    StringBuilder sb = new StringBuilder();
    inOrderRec(root, sb);
    return sb.toString();
}

private void inOrderRec(AVLNode node, StringBuilder sb) {
    if (node != null) {
        inOrderRec(node.left, sb);
        sb.append(node.key).append(" ");
        inOrderRec(node.right, sb);
    }
}

public String postOrder() {
    StringBuilder sb = new StringBuilder();
    postOrderRec(root, sb);
    return sb.toString();
}

private void postOrderRec(AVLNode node, StringBuilder sb) {
    if (node != null) {
        postOrderRec(node.left, sb);
        postOrderRec(node.right, sb);
        sb.append(node.key).append(" ");
    }
}
    public void timKiemVaHienThiQuanHe(int key, javax.swing.JTextArea txtResult) {
    if (!contains(key)) {
        txtResult.setText("Không tìm thấy nút có giá trị " + key + " trong cây.");
        return;
    }

    AVLNode parent = null;
    AVLNode node = root;

    // Tìm node và parent
    while (node != null && node.key != key) {
        parent = node;
        if (key < node.key) node = node.left;
        else node = node.right;
    }

    StringBuilder sb = new StringBuilder();
    sb.append("Đã tìm thấy nút ").append(key).append("\n");

    // Hiển thị nút cha
    if (parent != null) {
        sb.append("Nút cha: ").append(parent.key).append("\n");
    } else {
        sb.append("Nút này là root, không có nút cha\n");
    }

    // Hiển thị anh em
    if (parent != null) {
        if (parent.left != null && parent.left.key == key && parent.right != null) {
            sb.append("Nút anh em (bên phải): ").append(parent.right.key).append("\n");
        } else if (parent.right != null && parent.right.key == key && parent.left != null) {
            sb.append("Nút anh em (bên trái): ").append(parent.left.key).append("\n");
        } else {
            sb.append("Không có nút anh em\n");
        }
    } else {
        sb.append("Không có nút anh em\n");
    }

    // Hiển thị nút con
    if (node.left != null) {
        sb.append("Nút con trái: ").append(node.left.key).append("\n");
    } else {
        sb.append("Không có nút con trái\n");
    }

    if (node.right != null) {
        sb.append("Nút con phải: ").append(node.right.key).append("\n");
    } else {
        sb.append("Không có nút con phải\n");
    }

    // Hiển thị kết quả lên textArea
    txtResult.setText(sb.toString());
}

    public void resetTree() {
    root = null;
}
    public boolean isAVL() {
    return checkAVL(root) != -1;
}

private int checkAVL(AVLNode node) {
    if (node == null) return 0;

    int leftHeight = checkAVL(node.left);
    if (leftHeight == -1) return -1;  // Không phải AVL

    int rightHeight = checkAVL(node.right);
    if (rightHeight == -1) return -1;  // Không phải AVL

    if (Math.abs(leftHeight - rightHeight) > 1) return -1;  // Mất cân bằng

    return Math.max(leftHeight, rightHeight) + 1;
}

    
    public int findMin() {
    if (root == null) throw new IllegalStateException("Cây rỗng!");
    AVLNode current = root;
    while (current.left != null) {
        current = current.left;
    }
    return current.key;
}

    public int findMax() {
    if (root == null) throw new IllegalStateException("Cây rỗng!");
    AVLNode current = root;
    while (current.right != null) {
        current = current.right;
    }
    return current.key;
}
    public String findPath(int key) {
    StringBuilder path = new StringBuilder();
    AVLNode current = root;

    while (current != null) {
        path.append(current.key);
        if (key == current.key) {
            return path.toString(); // Đã tìm thấy
        } else if (key < current.key) {
            path.append(" -> ");
            current = current.left;
        } else {
            path.append(" -> ");
            current = current.right;
        }
    }

    // Không tìm thấy
    return "Không tìm thấy nút có giá trị " + key + " trong cây!";
}
    
    
    public String levelOrderTraversal() {
        if (root == null) return "Cây rỗng!";

        StringBuilder result = new StringBuilder();
        Queue<AVLNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            AVLNode current = queue.poll();
            result.append(current.key).append(" ");

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }

        return result.toString();
    }

    int height(AVLNode N) {
        if (N == null) return 0;
        return N.height;
    }

    int getBalance(AVLNode N) {
        if (N == null) return 0;
        return height(N.left) - height(N.right);
    }
    // Sửa hàm tính chiều cao chính xác hơn
    public int getActualTreeHeight() {
        return getHeight(root);
    }

    // Hàm tính chiều cao chính xác
    private int getHeight(AVLNode node) {
        if (node == null) return -1; // Trả về -1 thay vì 0 để đúng chiều cao
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }



    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }


private AVLNode insert(AVLNode node, int key, JTextArea logArea) {
    if (node == null) {
        logArea.append("→ B" + nextStep() + ": Thêm nút " + key + " vào cây\n");
        return new AVLNode(key);
    }

    if (key < node.key) {
        logArea.append("→ B" + nextStep() + ": So sánh " + key + " < " + node.key + " → đi bên trái\n");
        node.left = insert(node.left, key, logArea);
    } else if (key > node.key) {
        logArea.append("→ B" + nextStep() + ": So sánh " + key + " > " + node.key + " → đi bên phải\n");
        node.right = insert(node.right, key, logArea);
    } else {
        logArea.append("→ B" + nextStep() + ": Nút " + key + " đã tồn tại, không thêm\n");
        return node;
    }

    node.height = Math.max(height(node.left), height(node.right)) + 1;

    int balance = getBalance(node);

    if (balance > 1 && key < node.left.key) {
        logArea.append("→ B" + nextStep() + ": Cân bằng tại nút " + node.key + " (quay phải)\n");
        return rightRotate(node);
    }
    if (balance < -1 && key > node.right.key) {
        logArea.append("→ B" + nextStep() + ": Cân bằng tại nút " + node.key + " (quay trái)\n");
        return leftRotate(node);
    }
    if (balance > 1 && key > node.left.key) {
        logArea.append("→ B" + nextStep() + ": Cân bằng tại nút " + node.key + " (quay trái‑phải)\n");
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
    if (balance < -1 && key < node.right.key) {
        logArea.append("→ B" + nextStep() + ": Cân bằng tại nút " + node.key + " (quay phải‑trái)\n");
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    return node;
}


   private AVLNode deleteNode(AVLNode root, int key) {
    if (root == null) return null;

    if (key < root.key) {
        root.left = deleteNode(root.left, key);
    } else if (key > root.key) {
        root.right = deleteNode(root.right, key);
    } else {
        // Đã tìm thấy node
        if ((root.left == null) || (root.right == null)) {
            AVLNode temp = (root.left != null) ? root.left : root.right;
            if (temp == null) {
                root = null;
            } else {
                root = temp;
            }
        } else {
            // Node có 2 con
            AVLNode temp = minValueNode(root.right);
            root.key = temp.key;
            root.right = deleteNode(root.right, temp.key);
        }
    }

    if (root == null) return null;

    // Cập nhật chiều cao
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    // Cân bằng lại cây
    int balance = getBalance(root);

    // 4 TH mất cân bằng
    if (balance > 1 && getBalance(root.left) >= 0) return rightRotate(root);
    if (balance > 1 && getBalance(root.left) < 0) {
        root.left = leftRotate(root.left);
        return rightRotate(root);
    }
    if (balance < -1 && getBalance(root.right) <= 0) return leftRotate(root);
    if (balance < -1 && getBalance(root.right) > 0) {
        root.right = rightRotate(root.right);
        return leftRotate(root);
    }

    return root;
}

    
    AVLNode minValueNode(AVLNode node){
        AVLNode current = node;
        while (current.left != null) current = current.left;
        return current;
    }
    
    public void remove(int key){
        root = deleteNode(root, key);
    }
    
//    public void add(int key) {
//        root = insert(root, key);
//    }
    

public void add(int key, JTextArea logArea) {
    logArea.setText("");                // (tuỳ bạn có muốn clear log cũ)
    root = insert(root, key, logArea);
}


//}
public void delete(int key) {
    if (!contains(key)) {
        JOptionPane.showMessageDialog(null, "Không tìm thấy nút có giá trị " + key + " trong cây!");
        return;
    }
    // Gọi hàm xóa chính
    root = deleteNode(root, key);

    // Kiểm tra lại sau khi xóa
    if (!contains(key)) {
        JOptionPane.showMessageDialog(null, "Đã xóa nút thành công!");
    } else {
        JOptionPane.showMessageDialog(null, "Lỗi: Nút vẫn tồn tại sau khi xóa!");
    }
}
    


   

    public void clear() {
    root = null;
}

    public void taoCayNgauNhien(int soLuong, JTextArea logArea) {
    resetStepCounter();
    Random rand = new Random();
    Set<Integer> tapSo = new LinkedHashSet<>();

    logArea.setText("");
    logArea.append("B" + nextStep() + ": Sinh các số: ");
    while (tapSo.size() < soLuong) {
        int val = rand.nextInt(100);
        if (tapSo.add(val)) logArea.append(val + " ");
    }
    logArea.append("\n");

    for (int val : tapSo) {
        logArea.append("B" + nextStep() + ": Thêm nút " + val + " vào cây\n");
        root = insert(root, val, logArea);
    }
}


    public boolean contains(int key) {
        return search(root, key);
    }

    boolean search(AVLNode node, int key) {
        if (node == null) return false;
        if (key == node.key) return true;
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

//    void insert(int value) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }

}

class TreePanel extends JPanel {

    private AVLTree avlTree;

    public TreePanel(AVLTree tree) {
        this.avlTree = tree;
    }
    
    public void setTree(AVLTree tree){
        this.avlTree = tree;
        repaint();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (avlTree != null && avlTree.root != null) {
            drawTree(g, avlTree.root, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void drawTree(Graphics g, AVLNode node, int x, int y, int xOffset) {
        if (node == null) return;

        g.setColor(Color.BLACK);
        g.fillOval(x - 15, y - 15, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(node.key), x - 7, y + 5);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x - xOffset, y + 50);
            drawTree(g, node.left, x - xOffset, y + 50, xOffset / 2);
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x, y, x + xOffset, y + 50);
            drawTree(g, node.right, x + xOffset, y + 50, xOffset / 2);
        }
    }
    
    public static class ResultPanel extends JPanel {
    private String result = "";

    public void setResult(String result) {
        this.result = result;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawString("Traversal Result: " + result, 10, 20);
    }
}

   
   
}
