package View;

import Controler.Command;
import Model.Currency;
import Model.Money;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DialogMenuSwing extends JPanel implements DialogMenu{
    private Map<String, Command> commands;
    private List<Currency> currencies;
    
    private JLabel fromLabel, toLabel, moneyLabel;
    private JTextField moneyField;
    private JComboBox fromCombo, toCombo;
    private JButton calculate;
    private JTextArea textarea;
    
    
    public DialogMenuSwing(List<Currency> currencies){
        commands = new HashMap<String, Command>();
        this.currencies = currencies;
        CreateComponentsGUI();
    }
    
    private void CreateComponentsGUI(){
        this.setLayout(new BorderLayout());
        fromLabel = new JLabel("FROM= ");
        toLabel = new JLabel("TO= ");
        moneyLabel = new JLabel("Money= ");
        moneyField = new JTextField(10);
        moneyField.setText("0");
        fromCombo = new JComboBox<Currency>();
        toCombo = new JComboBox<Currency>();
        calculate = button();
        textarea = new JTextArea(3,3);
        for (Currency currency : this.currencies) {
            fromCombo.addItem(currency);
            toCombo.addItem(currency);
        }
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(0,1));
        JPanel panelMoney = new JPanel();
        panelMoney.add(moneyLabel);
        panelMoney.add(moneyField);
        center.add(panelMoney);
        JPanel panelFrom = new JPanel();
        panelFrom.add(fromLabel);
        panelFrom.add(fromCombo);
        panelFrom.add(toLabel);
        panelFrom.add(toCombo);
        center.add(panelFrom);
        JPanel panelBotton = new JPanel();
        panelBotton.add(calculate);
        center.add(panelBotton);
        this.add(center, BorderLayout.CENTER);
        this.add(textarea, BorderLayout.SOUTH);
    }

    @Override
    public Money getMoney() {
        try{
            return new Money(Double.parseDouble(moneyField.getText()), (Currency) fromCombo.getSelectedItem());
        } catch (Exception e){
            textarea.setText("\tError the amount of money plis insert the right amount of money");
            return null;
        }
    }

    @Override
    public Currency getCurrencyTO() {
        return (Currency) toCombo.getSelectedItem();
    }

    @Override
    public void refreshMoney(Money m) {
        textarea.setText("\t\tThe exchange of money to the currency\n\t\t" + m.getCurrency().getName() 
                          + " is " + m.getMount() + m.getCurrency().getSimbol() );
    }

    private JButton button() {
        JButton button = new JButton("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("button").execute();
            }
        });
        return button;
    }
    
    public void addCommand(String key, Command command){
        commands.put(key, command);
    }
    
}
