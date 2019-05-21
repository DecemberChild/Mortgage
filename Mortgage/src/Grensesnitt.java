import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class Grensesnitt extends JFrame {
    GridBagConstraints gbc = new GridBagConstraints();
    JPanel jp = new JPanel(new GridBagLayout());
    JPanel jp2 = new JPanel(new GridBagLayout());
    Kontroll K = new Kontroll();
    JTextField txtLoan = new JTextField(10);
    JTextField txtAPR = new JTextField(10);
    JTextField txtYears = new JTextField(10);
    JTextField txtResult = new JTextField(10);
    public Grensesnitt(){
        setTitle("Mortgage");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelTextnLabel(BorderLayout.CENTER);
        panelButtons(BorderLayout.SOUTH);
pack();
        setVisible(true);
    }
    public void panelTextnLabel(String LO){

        txtResult.setEnabled(false);
        txtResult.setBackground(Color.LIGHT_GRAY);
txtResult.setDisabledTextColor(Color.black);
        JLabel lblLoan = new JLabel("Loan: ");
        JLabel lblAPR = new JLabel("Interest Rate: ");
        JLabel lblYears = new JLabel("Years:  ");
        JLabel lblResult = new JLabel("Monthly Payment: ");


        addTextField(1,0,txtLoan);
        addTextField(1,1,txtAPR);
        addTextField(1,2,txtYears);
        addTextField(1,3,txtResult);
        addLabel(0,0,lblLoan);
        addLabel(0,1,lblAPR);
        addLabel(0,2,lblYears);
        addLabel(0,3,lblResult);
        add(jp,LO);
    }
    public void panelButtons(String LO){
        JButton btnCalculate = new JButton("Calculate");

        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
try {
    double Loan = Double.parseDouble(txtLoan.getText());
    double APR = Double.parseDouble(txtAPR.getText());
    double Years = Double.parseDouble(txtYears.getText());
    double R = K.Calculation(Loan, APR, Years);
}catch(Exception E){JOptionPane.showMessageDialog(null,"You must write numbers");}
               txtResult.setText( Double.toString(R));
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        addButton(0,4,btnCalculate);
        addButton(1,4,btnExit);


        add(jp2,LO);
    }
    public void addTextField(int x ,int y,JTextField jf){
        gbc.gridy=y;
        gbc.gridx=x;
        jp.add(jf,gbc);

    }
    public void addLabel(int x ,int y ,JLabel lbl){
        gbc.gridx=x;
        gbc.gridy=y;
        jp.add(lbl,gbc);
    }
    public void addButton(int x,int y ,JButton btn){
        gbc.gridx=x;
        gbc.gridy=y;
        jp2.add(btn,gbc);
    }
}
