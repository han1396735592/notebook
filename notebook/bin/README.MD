题目  编写一个记事本程序
设计要求
1、  用图形用户界面实现。
2、  能实现编辑、保存、另存为、查找替换等功能。
3、  提示：使用文件输入输出流。


//  JOptionPane.showMessageDialog(new JFrame(),"已删除");  



int n = JOptionPane.showConfirmDialog(null, "确认删除吗?", "确认对话框", JOptionPane.YES_NO_OPTION);   
if (n == JOptionPane.YES_OPTION) {   
    JOptionPane.showMessageDialog(new JFrame(),"已删除");  
} else if (n == JOptionPane.NO_OPTION) {   
    JOptionPane.showMessageDialog(new JFrame(),"已取消");  