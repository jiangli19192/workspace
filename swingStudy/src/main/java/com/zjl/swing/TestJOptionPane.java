package com.zjl.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class TestJOptionPane extends JFrame {
	
	JPanel jp,jp1,jp2;
    JButton jb1,jb2,jb3,jb4,jb5;
    JTable table;
    JTextField aField,bField,cField;
    JLabel label,label2,label3;
    int[] index;
    public static void main(String[] args) {
        new TestJOptionPane();
    }
    public TestJOptionPane(){
        super("对话框测试");
        jp = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
                 
        Object[][] tableData = {
                new Object[]{false,"萝卜干","1"},
                new Object[]{false,"红烧肉","2"},
                new Object[]{false,"西红柿炒鸡蛋","3"},
                new Object[]{false,"黄瓜炒鸡蛋","4"},
                new Object[]{false,"红烧茄子","5"}
              /*  new Object[]{false,"6","f"},
                new Object[]{false,"7","g"},
                new Object[]{false,"8","h"}*/
                 
            }; 
        String[] columnTitle = {" ","菜品","数量"};
        final ExtendedTableModel model = new ExtendedTableModel(columnTitle,tableData);
         
        table = new JTable(model);
        table.setRowSelectionAllowed(true);
        //table.getSelectionModel().setSelectionInterval(0, 5);
        //table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setRowHeight(20);     
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                Object oa = model.getValueAt(selectedRow, 0);
                Object ob = model.getValueAt(selectedRow, 1);
                Object oc = model.getValueAt(selectedRow, 2);
                aField.setText(oa.toString());
                bField.setText(ob.toString());
                cField.setText(oc.toString());
            }
        });
        JScrollPane jScrollPane = new JScrollPane(table);
         
        jp1.add(jScrollPane,BorderLayout.CENTER);
        //table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        label = new JLabel("是否:");
        aField = new JTextField(" ", 5);
        jp2.add(label);
        jp2.add(aField);
        label2 = new JLabel("名称:");
        bField = new JTextField(" ", 5);
        jp2.add(label2);
        jp2.add(bField);
        label3 = new JLabel("类名称:");
        cField = new JTextField(" ", 5);
        jp2.add(label3);
        jp2.add(cField);
         
         
         
        jb1 = new JButton("添加");
        jb1.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowCount = table.getRowCount();//获取行数
                Object[] rowValues = {false,rowCount+1,"i"};
                model.addRow(rowValues);
                 
                 
            }
        });
        jp.add(jb1);
        jb2 = new JButton("删除");
        jb2.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] as = table.getSelectedColumns();
                int[] ar = table.getSelectedRows();
                int selectedRow = table.getSelectedRow();
                 
                for(int i=0; i<ar.length; i++){
//                    boolean v = (boolean) model.getValueAt(ar[i], 0);
                 Object valueAt = model.getValueAt(ar[i], 0);
                        model.removeRow(ar[i]);
                     
                    System.out.println(ar[i]+" --------------");
                }
                //int selectedRow = table.getSelectedRow();//获得选中行的索引
                //model.get
                 
                 
                 
                 
            }
        });
        jp.add(jb2);
        jb3 = new JButton("修改");
        jb3.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();//获得选中行的索引
                if(selectedRow!=-1){
                    model.setValueAt(Boolean.valueOf(cField.getText()), selectedRow, 0);
                    model.setValueAt(aField.getText(), selectedRow, 1);
                    model.setValueAt(bField.getText(), selectedRow, 2);
                     
                }
                 
            }
        });
        //jp.add(jb3);
        jb4 = new JButton("关闭");
        jb4.addActionListener(new ActionListener() {
             
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
                 
            }
        });
        jp2.add(jb3);
        jp2.add(jb4);
        setBounds(100, 100, 455, 600);
         
        setLayout(new BorderLayout());
        add(jp,BorderLayout.NORTH);
        add(jp1,BorderLayout.CENTER);
        add(jp2,BorderLayout.SOUTH);        
        //pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        setVisible(true);
                 
    }
     
 
}
class ExtendedTableModel extends DefaultTableModel{
 
    public ExtendedTableModel(String[] columnTitle, Object[][] tableData) {
        super(tableData,columnTitle);
    }
    //重写getColumnClass方法,根据每列的第一个值返回该列真实的数据类型
    @Override
    public Class getColumnClass(int columnIndex) {
         
        return getValueAt(0, columnIndex).getClass();
    }
}
