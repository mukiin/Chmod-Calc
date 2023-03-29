import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChmodCalculator extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel ownerLabel, groupLabel, publicLabel, numericLabel, symbolicLabel;
    private JCheckBox ownerRead, ownerWrite, ownerExecute, groupRead, groupWrite, groupExecute, publicRead, publicWrite, publicExecute;
    private JTextField numericField, symbolicField;

    public ChmodCalculator() {
        super("Chmod Calculator");
        setLayout(new GridLayout(6, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setPreferredSize(new Dimension(450, 350));
        pack();

        // Define some colors
        Color blue = new Color(172, 182, 189);

        ownerLabel = new JLabel("OWNER", JLabel.CENTER);
        groupLabel = new JLabel("GROUP", JLabel.CENTER);
        publicLabel = new JLabel("PUBLIC", JLabel.CENTER);
        numericLabel = new JLabel("Numeric Permissions: ", JLabel.RIGHT);
        symbolicLabel = new JLabel("Symbolic Permissions: ", JLabel.RIGHT);

        ownerRead = new JCheckBox(" Read");
        ownerWrite = new JCheckBox("Write");
        ownerExecute = new JCheckBox("Exec.");
        groupRead = new JCheckBox("Read");
        groupWrite = new JCheckBox("Write");
        groupExecute = new JCheckBox("Exec.");
        publicRead = new JCheckBox("Read");
        publicWrite = new JCheckBox("Write");
        publicExecute = new JCheckBox("Exec.");

        numericField = new JTextField();
        symbolicField = new JTextField();

        // Set style for checkboxes and text fields
        ownerRead.setBackground(blue);
        ownerRead.setForeground(Color.WHITE);
        ownerRead.setHorizontalAlignment(SwingConstants.CENTER);
        ownerRead.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        ownerWrite.setBackground(blue);
        ownerWrite.setForeground(Color.WHITE);
        ownerWrite.setHorizontalAlignment(SwingConstants.CENTER);
        ownerExecute.setBackground(blue);
        ownerExecute.setForeground(Color.WHITE);
        ownerExecute.setHorizontalAlignment(SwingConstants.CENTER);

        groupRead.setBackground(blue);
        groupRead.setForeground(Color.WHITE);
        groupRead.setHorizontalAlignment(SwingConstants.CENTER);
        groupWrite.setBackground(blue);
        groupWrite.setForeground(Color.WHITE);
        groupWrite.setHorizontalAlignment(SwingConstants.CENTER);
        groupExecute.setBackground(blue);
        groupExecute.setForeground(Color.WHITE);
        groupExecute.setHorizontalAlignment(SwingConstants.CENTER);

        publicRead.setBackground(blue);
        publicRead.setForeground(Color.WHITE);
        publicRead.setHorizontalAlignment(SwingConstants.CENTER);
        publicWrite.setBackground(blue);
        publicWrite.setForeground(Color.WHITE);
        publicWrite.setHorizontalAlignment(SwingConstants.CENTER);
        publicExecute.setBackground(blue);
        publicExecute.setForeground(Color.WHITE);
        publicExecute.setHorizontalAlignment(SwingConstants.CENTER);

        numericField.setBackground(Color.white);
        symbolicField.setBackground(Color.white);

        add(ownerLabel);
        add(groupLabel);
        add(publicLabel);
        add(ownerRead);
        add(groupRead);
        add(publicRead);
        add(ownerWrite);
        add(groupWrite);
        add(publicWrite);
        add(ownerExecute);
        add(groupExecute);
        add(publicExecute);
        add(numericLabel);
        add(numericField);
        add(new JLabel(""));
        add(symbolicLabel);
        add(symbolicField);
        add(new JLabel(""));

        ownerRead.addActionListener(this);
        ownerWrite.addActionListener(this);
        ownerExecute.addActionListener(this);
        groupRead.addActionListener(this);
        groupWrite.addActionListener(this);
        groupExecute.addActionListener(this);
        publicRead.addActionListener(this);
        publicWrite.addActionListener(this);
        publicExecute.addActionListener(this);
        numericField.addActionListener(this);
        symbolicField.addActionListener(this);

        pack();
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ownerRead || e.getSource() == ownerWrite || e.getSource() == ownerExecute ||
                e.getSource() == groupRead || e.getSource() == groupWrite || e.getSource() == groupExecute ||
                e.getSource() == publicRead || e.getSource() == publicWrite || e.getSource() == publicExecute) {
            int numericValue = 0;
            String symbolicValue = "";
            if (ownerRead.isSelected()) {
                numericValue += 400;
                symbolicValue += "r";
            } else {
                symbolicValue += "-";
            }
            if (ownerWrite.isSelected()) {
                numericValue += 200;
                symbolicValue += "w";
            } else {
                symbolicValue += "-";
            }
            if (ownerExecute.isSelected()) {
                numericValue += 100;
                symbolicValue += "x";
            } else {
                symbolicValue += "-";
            }
            if (groupRead.isSelected()) {
                numericValue += 40;
                symbolicValue += "r";
            } else {
                symbolicValue += "-";
            }
            if (groupWrite.isSelected()) {
                numericValue += 20;
                symbolicValue += "w";
            } else {
                symbolicValue += "-";
            }
            if (groupExecute.isSelected()) {
                numericValue += 10;
                symbolicValue += "x";
            } else {
                symbolicValue += "-";
            }
            if (publicRead.isSelected()) {
                numericValue += 4;
                symbolicValue += "r";
            } else {
                symbolicValue += "-";
            }
            if (publicWrite.isSelected()) {
                numericValue += 2;
                symbolicValue += "w";
            } else {
                symbolicValue += "-";
            }
            if (publicExecute.isSelected()) {
                numericValue += 1;
                symbolicValue += "x";
            } else {
                symbolicValue += "-";
            }
            numericField.setText(String.valueOf(numericValue));
            symbolicField.setText(symbolicValue);
        } else if (e.getSource() == numericField) {
            int numericValue = Integer.parseInt(numericField.getText());
            ownerRead.setSelected((numericValue / 400) == 1);
            ownerWrite.setSelected(((numericValue / 200) % 2) == 1);
            ownerExecute.setSelected(((numericValue / 100) % 2) == 1);
            groupRead.setSelected(((numericValue / 40) % 2) == 1);
            groupWrite.setSelected(((numericValue / 20) % 2) == 1);
            groupExecute.setSelected(((numericValue / 10) % 2) == 1);
            publicRead.setSelected(((numericValue / 4) % 2) == 1);
            publicWrite.setSelected(((numericValue / 2) % 2) == 1);
            publicExecute.setSelected((numericValue % 2) == 1);
            String symbolicValue = "";
            symbolicValue += ((numericValue / 400) == 1) ? "r" : "-";
            symbolicValue += (((numericValue / 200) % 2) == 1) ? "w" : "-";
            symbolicValue += (((numericValue / 100) % 2) == 1) ? "x" : "-";
            symbolicValue += (((numericValue / 40) % 2) == 1) ? "r" : "-";
            symbolicValue += (((numericValue / 20) % 2) == 1) ? "w" : "-";
            symbolicValue += (((numericValue / 10) % 2) == 1) ? "x" : "-";
            symbolicValue += (((numericValue / 4) % 2) == 1) ? "r" : "-";
            symbolicValue += (((numericValue / 2) % 2) == 1) ? "w" : "-";
            symbolicValue += ((numericValue % 2) == 1) ? "x" : "-";
            symbolicField.setText(symbolicValue);
        } else if (e.getSource() == symbolicField) {
            String symbolicValue = symbolicField.getText();
            int numericValue = 0;
            if (symbolicValue.charAt(0) == 'r') {
                ownerRead.setSelected(true);
                numericValue += 400;
            } else {
                ownerRead.setSelected(false);
            }
            if (symbolicValue.charAt(1) == 'w') {
                ownerWrite.setSelected(true);
                numericValue += 200;
            } else {
                ownerWrite.setSelected(false);
            }
            if (symbolicValue.charAt(2) == 'x') {
                ownerExecute.setSelected(true);
                numericValue += 100;
            } else {
                ownerExecute.setSelected(false);
            }
            if (symbolicValue.charAt(3) == 'r') {
                groupRead.setSelected(true);
                numericValue += 40;
            } else {
                groupRead.setSelected(false);
            }
            if (symbolicValue.charAt(4) == 'w') {
                groupWrite.setSelected(true);
                numericValue += 20;
            } else {
                groupWrite.setSelected(false);
            }
            if (symbolicValue.charAt(5) == 'x') {
                groupExecute.setSelected(true);
                numericValue += 10;
            } else {
                groupExecute.setSelected(false);
            }
            if (symbolicValue.charAt(6) == 'r') {
                publicRead.setSelected(true);
                numericValue += 4;
            } else {
                publicRead.setSelected(false);
            }
            if (symbolicValue.charAt(7) == 'w') {
                publicWrite.setSelected(true);
                numericValue += 2;
            } else {
                publicWrite.setSelected(false);
            }
            if (symbolicValue.charAt(8) == 'x') {
                publicExecute.setSelected(true);
                numericValue += 1;
            } else {
                publicExecute.setSelected(false);
            }
            numericField.setText(String.valueOf(numericValue));
        }
    }

    public static void main(String[] args) {
        new ChmodCalculator();
    }
}

