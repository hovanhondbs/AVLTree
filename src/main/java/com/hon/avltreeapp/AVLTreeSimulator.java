package com.hon.avltreeapp;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Laptop
 */
public class AVLTreeSimulator extends javax.swing.JFrame {
    private AVLTree avlTree= new AVLTree();

    /**
     * Creates new form AVLTreeSimulator
     */
    
    public AVLTreeSimulator() {
        initComponents();
    duongdicuanut.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int value = Integer.parseInt(jTextField1.getText().trim());
                String path = avlTree.findPath(value);
                jTextArea1.setText("Đường đi đến nút " + value + ": " + path);
            } catch (NumberFormatException ex) {
                jTextArea1.setText("Vui lòng nhập số nguyên hợp lệ!");
            }
    }
});
    
        
    checkvar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (avlTree.isAVL()) {
                jTextArea1.setText("Đây là một cây AVL hợp lệ.");
            } else {
                jTextArea1.setText("Không phải là cây AVL.");
            }
            panelTree.repaint();
        }
    });    
        
    theobacButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String result = avlTree.levelOrderTraversal();  // Gọi hàm duyệt cây theo bậc
            jTextArea1.setText("Duyệt cây theo bậc: " + result);
    }
});    
        
    hautu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String result = avlTree.postOrder();
            jTextArea1.setText("Duyệt Hậu tự: " + result);
    }
});// TODO add your handling code here:    
        
    trungtu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String result = avlTree.inOrder();
            jTextArea1.setText("Duyệt Trung tự: " + result);
    }
});   
        
    tientu.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            String result = avlTree.preOrder();
            jTextArea1.setText("Duyệt Tiền tự: " + result);
    }
});       
        
    chieucaocay.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int height = avlTree.getActualTreeHeight();
                jTextArea1.setText("Chiều cao của cây là: "+height);
            }
        });    
        
    timkiemnut.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int value = Integer.parseInt(jTextField1.getText().trim());
            avlTree.timKiemVaHienThiQuanHe(value, jTextArea1);
        } catch (NumberFormatException ex) {
            jTextArea1.setText("Vui lòng nhập số nguyên hợp lệ!");
        }
    }
});    
        
        
    nutnhonhat.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int min = avlTree.findMin();
                jTextArea1.setText("Giá trị nhỏ nhất trong cây là: " + min);
            } catch (IllegalStateException ex) {
                jTextArea1.setText("Cây hiện đang rỗng!");
            }
        }
    });    
        
        
    nutlonhat.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int max = avlTree.findMax();
                jTextArea1.setText("Giá trị lớn nhất trong cây là: " + max);
            } catch (IllegalStateException ex) {
                jTextArea1.setText("Cây hiện đang rỗng!");
            }
        }
    });

        
    reload.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        avlTree.resetTree();  // Xóa sạch cây
        panelTree.repaint();  // Vẽ lại cây rỗng
        jTextArea1.setText("Đã xóa toàn bộ cây, cây hiện đang rỗng.");
    }
});

        
      themnut.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = jTextField1.getText().trim();
        if (input.isEmpty()) {
            jTextArea1.setText("Vui lòng nhập giá trị!");
            return;
        }

        try {
            int value = Integer.parseInt(input);
            if (avlTree.contains(value)) {
                jTextArea1.setText("Giá trị " + value + " đã tồn tại trong cây!");
            } else {
               
                avlTree.add(value, jTextArea1);               
                panelTree.repaint();      
                jTextArea1.setText("Đã thêm nút " + value + " vào cây AVL.");
                jTextField1.setText("");          
            }
        } catch (NumberFormatException ex) {
            jTextArea1.setText("Vui lòng nhập số nguyên hợp lệ!");
        }
    }
});




        
        themtaptin.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                
                avlTree.resetTree();
                avlTree.readFromFile(selectedFile, jTextArea1);
                panelTree.repaint();  // Vẽ lại cây sau khi load xong
            }
        }
});
        
          xoa.addActionListener( new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                try{
                    int key = Integer.parseInt(jTextField1.getText());
                    
                    panelTree.repaint();
                    avlTree.delete(key);

                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số nguyên");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Giatridauvao = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        themnut = new javax.swing.JButton();
        xoa = new javax.swing.JButton();
        nutlonhat = new javax.swing.JButton();
        nutnhonhat = new javax.swing.JButton();
        randomTree = new javax.swing.JButton();
        timkiemnut = new javax.swing.JButton();
        chieucaocay = new javax.swing.JButton();
        themtaptin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tientu = new javax.swing.JButton();
        trungtu = new javax.swing.JButton();
        hautu = new javax.swing.JButton();
        reload = new javax.swing.JButton();
        checkvar = new javax.swing.JButton();
        duongdicuanut = new javax.swing.JButton();
        theobacButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        panelTree = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thuật toán trên cây AVL");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(169, 181, 223));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mô phỏng thuật toán trên cây AVL");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(169, 181, 223));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 51, 107), 1, true));

        Giatridauvao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Giatridauvao.setText("Nhập giá trị:");

        jTextField1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        themnut.setBackground(new java.awt.Color(45, 51, 107));
        themnut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themnut.setForeground(new java.awt.Color(255, 242, 242));
        themnut.setText("Thêm nút");
        themnut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themnutActionPerformed(evt);
            }
        });

        xoa.setBackground(new java.awt.Color(45, 51, 107));
        xoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        xoa.setForeground(new java.awt.Color(255, 242, 242));
        xoa.setText("Xóa nút");
        xoa.setToolTipText("");
        xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoaActionPerformed(evt);
            }
        });

        nutlonhat.setBackground(new java.awt.Color(45, 51, 107));
        nutlonhat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nutlonhat.setForeground(new java.awt.Color(255, 242, 242));
        nutlonhat.setText("Nút lớn nhất");
        nutlonhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutlonhatActionPerformed(evt);
            }
        });

        nutnhonhat.setBackground(new java.awt.Color(45, 51, 107));
        nutnhonhat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        nutnhonhat.setForeground(new java.awt.Color(255, 242, 242));
        nutnhonhat.setText("Nút nhỏ nhất");
        nutnhonhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nutnhonhatActionPerformed(evt);
            }
        });

        randomTree.setBackground(new java.awt.Color(45, 51, 107));
        randomTree.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        randomTree.setForeground(new java.awt.Color(255, 242, 242));
        randomTree.setText("Tạo cây ngẫu nhiên");
        randomTree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomTreeActionPerformed(evt);
            }
        });

        timkiemnut.setBackground(new java.awt.Color(45, 51, 107));
        timkiemnut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        timkiemnut.setForeground(new java.awt.Color(255, 242, 242));
        timkiemnut.setText("Tìm kiếm nút");
        timkiemnut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timkiemnutActionPerformed(evt);
            }
        });

        chieucaocay.setBackground(new java.awt.Color(45, 51, 107));
        chieucaocay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chieucaocay.setForeground(new java.awt.Color(255, 242, 242));
        chieucaocay.setText("Chiều cao của cây");
        chieucaocay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chieucaocayActionPerformed(evt);
            }
        });

        themtaptin.setBackground(new java.awt.Color(45, 51, 107));
        themtaptin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        themtaptin.setForeground(new java.awt.Color(255, 242, 242));
        themtaptin.setText("Thêm từ tập tin");
        themtaptin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themtaptinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Giatridauvao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(themnut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(xoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nutlonhat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nutnhonhat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(randomTree)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(themtaptin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(timkiemnut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chieucaocay)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Giatridauvao)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(themnut)
                    .addComponent(xoa)
                    .addComponent(nutlonhat)
                    .addComponent(nutnhonhat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(randomTree)
                    .addComponent(timkiemnut)
                    .addComponent(chieucaocay)
                    .addComponent(themtaptin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(169, 181, 223));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 51, 107), 1, true));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Các phép duyệt:");

        tientu.setBackground(new java.awt.Color(45, 51, 107));
        tientu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tientu.setForeground(new java.awt.Color(255, 242, 242));
        tientu.setText("Tiền tự");
        tientu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tientuActionPerformed(evt);
            }
        });

        trungtu.setBackground(new java.awt.Color(45, 51, 107));
        trungtu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        trungtu.setForeground(new java.awt.Color(255, 242, 242));
        trungtu.setText("Trung tự");
        trungtu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trungtuActionPerformed(evt);
            }
        });

        hautu.setBackground(new java.awt.Color(45, 51, 107));
        hautu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        hautu.setForeground(new java.awt.Color(255, 242, 242));
        hautu.setText("Hậu tự");
        hautu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hautuActionPerformed(evt);
            }
        });

        reload.setBackground(new java.awt.Color(45, 51, 107));
        reload.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reload.setForeground(new java.awt.Color(255, 242, 242));
        reload.setText("Tải lại");
        reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadActionPerformed(evt);
            }
        });

        checkvar.setBackground(new java.awt.Color(45, 51, 107));
        checkvar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        checkvar.setForeground(new java.awt.Color(255, 242, 242));
        checkvar.setText("Cây AVL?");
        checkvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkvarActionPerformed(evt);
            }
        });

        duongdicuanut.setBackground(new java.awt.Color(45, 51, 107));
        duongdicuanut.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        duongdicuanut.setForeground(new java.awt.Color(255, 242, 242));
        duongdicuanut.setText("Xác định đường đi");
        duongdicuanut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duongdicuanutActionPerformed(evt);
            }
        });

        theobacButton.setBackground(new java.awt.Color(45, 51, 107));
        theobacButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        theobacButton.setForeground(new java.awt.Color(255, 242, 242));
        theobacButton.setText("Theo bậc");
        theobacButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theobacButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Thao tác:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(tientu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trungtu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hautu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(theobacButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(reload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(duongdicuanut)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tientu)
                    .addComponent(trungtu)
                    .addComponent(hautu)
                    .addComponent(theobacButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reload)
                        .addComponent(duongdicuanut)
                        .addComponent(jLabel2)))
                .addContainerGap())
        );

        panelTree.setBackground(new java.awt.Color(255, 255, 255));
        panelTree.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 51, 107), 1, true));

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 481, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(169, 181, 223));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 51, 107), 1, true));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Kết quả hiển thị:");

        jTextArea1.setBackground(new java.awt.Color(169, 181, 223));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(45, 51, 107));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(45, 51, 107), 1, true));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void themnutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themnutActionPerformed
        // TODO add your handling code here:
        


    }//GEN-LAST:event_themnutActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void randomTreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomTreeActionPerformed
        try {
        String input = jTextField1.getText().trim();  
        if (input.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng");
            return;
        }

        int soLuong = Integer.parseInt(input);
        if (soLuong <= 0) {
            JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            return;
        }

//        avlTree = new AVLTree();  
        avlTree.clear();
        avlTree.taoCayNgauNhien(soLuong, jTextArea1); 

        // Cập nhật giao diện cây
        panelTree.removeAll();  // Xóa cây cũ nếu có
        TreePanel treePanel = new TreePanel(avlTree); // Truyền cây vào Panel vẽ
        panelTree.setLayout(new BorderLayout());      // Set layout để add vào giữa
        panelTree.add(treePanel, BorderLayout.CENTER); 
        panelTree.repaint();    // Vẽ lại
        panelTree.revalidate(); // Cập nhật giao diện

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ");
    }
    }//GEN-LAST:event_randomTreeActionPerformed

    private void xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoaActionPerformed
      
    }//GEN-LAST:event_xoaActionPerformed

    private void tientuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tientuActionPerformed
         // TODO add your handling code here:
    }//GEN-LAST:event_tientuActionPerformed

    private void trungtuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trungtuActionPerformed
        
        // TODO add your handling code here:
    }//GEN-LAST:event_trungtuActionPerformed

    private void hautuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hautuActionPerformed
 
    }//GEN-LAST:event_hautuActionPerformed

    private void chieucaocayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chieucaocayActionPerformed
        
    }//GEN-LAST:event_chieucaocayActionPerformed

    private void nutnhonhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutnhonhatActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_nutnhonhatActionPerformed

    private void nutlonhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nutlonhatActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_nutlonhatActionPerformed

    private void duongdicuanutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duongdicuanutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_duongdicuanutActionPerformed

    private void timkiemnutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timkiemnutActionPerformed
        // TODO add your handling code here:
        


    }//GEN-LAST:event_timkiemnutActionPerformed

    private void reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadActionPerformed
        // TODO add your handling code here:
   

    }//GEN-LAST:event_reloadActionPerformed

    private void checkvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkvarActionPerformed
        // TODO add your handling code here:
        

    }//GEN-LAST:event_checkvarActionPerformed

    private void theobacButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theobacButtonActionPerformed
        

        // TODO add your handling code here:
    }//GEN-LAST:event_theobacButtonActionPerformed

    private void themtaptinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themtaptinActionPerformed
        


    }//GEN-LAST:event_themtaptinActionPerformed
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AVLTreeSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AVLTreeSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AVLTreeSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AVLTreeSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        AVLTreeSimulator simulator = new AVLTreeSimulator();
        // doi con
        ImageIcon appIcon = new ImageIcon("C:\\Users\\Laptop\\Downloads\\NienluanCS\\AVLTreeApp\\src\\main\\java\\com\\hon\\avltreeapp\\logo-ctu-inkythuatso-01-09-14-23-14.jpg");
        simulator.setIconImage(appIcon.getImage());
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                simulator.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Giatridauvao;
    private javax.swing.JButton checkvar;
    private javax.swing.JButton chieucaocay;
    private javax.swing.JButton duongdicuanut;
    private javax.swing.JButton hautu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton nutlonhat;
    private javax.swing.JButton nutnhonhat;
    private javax.swing.JPanel panelTree;
    private javax.swing.JButton randomTree;
    private javax.swing.JButton reload;
    private javax.swing.JButton themnut;
    private javax.swing.JButton themtaptin;
    private javax.swing.JButton theobacButton;
    private javax.swing.JButton tientu;
    private javax.swing.JButton timkiemnut;
    private javax.swing.JButton trungtu;
    private javax.swing.JButton xoa;
    // End of variables declaration//GEN-END:variables

}
