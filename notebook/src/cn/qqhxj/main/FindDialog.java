package cn.qqhxj.main;

import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FindDialog {

	private TextEdit textEdit = null;
	Box leftBox, rightBox, baseBox;
	JTextField findText = null;
	JTextField replaceText = null;
	JButton findJButton = null;
	JButton replaceJButton = null;

	public FindDialog(TextEdit textEdit) {
		super();
		this.textEdit = textEdit;
		JFrame jFrame = new JFrame("查找");
		jFrame.setLayout(new FlowLayout());
		jFrame.setVisible(true);
		JFrame textEditJframe = textEdit.getjFrame();
		jFrame.setBounds(textEditJframe.getX() + textEditJframe.getWidth()
				- 400,
				textEditJframe.getY() + textEditJframe.getHeight() - 300, 400,
				300);
		// jFrame.setSize(400, 300);

		findText = new JTextField(10);
		replaceText = new JTextField(10);

		findJButton = new JButton("查找");
		findJButton.setSize(50, 30);

		replaceJButton = new JButton("替換");
		replaceJButton.setSize(50, 30);

		leftBox = Box.createVerticalBox();
		leftBox.add(new JLabel("查找:   "));
		leftBox.add(Box.createVerticalStrut(20));
		leftBox.add(new JLabel("替换:   "));
		leftBox.add(Box.createVerticalStrut(20));
		leftBox.add(findJButton);

		rightBox = Box.createVerticalBox();
		rightBox.add(findText);
		rightBox.add(Box.createVerticalStrut(10));
		rightBox.add(replaceText);
		rightBox.add(Box.createVerticalStrut(20));
		rightBox.add(replaceJButton);

		baseBox = Box.createHorizontalBox();
		baseBox.add(leftBox);
		baseBox.add(rightBox);

		jFrame.add(baseBox);
	}

	public TextEdit getTextEdit() {
		return textEdit;
	}

	public void setTextEdit(TextEdit textEdit) {
		this.textEdit = textEdit;
	}

	public Box getLeftBox() {
		return leftBox;
	}

	public void setLeftBox(Box leftBox) {
		this.leftBox = leftBox;
	}

	public Box getRightBox() {
		return rightBox;
	}

	public void setRightBox(Box rightBox) {
		this.rightBox = rightBox;
	}

	public Box getBaseBox() {
		return baseBox;
	}

	public void setBaseBox(Box baseBox) {
		this.baseBox = baseBox;
	}

	public JTextField getFindText() {
		return findText;
	}

	public void setFindText(JTextField findText) {
		this.findText = findText;
	}

	public JTextField getReplaceText() {
		return replaceText;
	}

	public void setReplaceText(JTextField replaceText) {
		this.replaceText = replaceText;
	}

	public JButton getFindJButton() {
		return findJButton;
	}

	public void setFindJButton(JButton findJButton) {
		this.findJButton = findJButton;
	}

	public JButton getReplaceJButton() {
		return replaceJButton;
	}

	public void setReplaceJButton(JButton replaceJButton) {
		this.replaceJButton = replaceJButton;
	}

}
