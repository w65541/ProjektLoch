package GameLogic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;import java.awt.event.MouseAdapter;

public class Backpack extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JButton helmet;
    private JButton armor;
    private JButton boots;
    private JButton weapon;
    private JButton shield;
    private JButton use;
    private JButton drop;
    private JTextPane desc;
    private JList list1;
    private JTextPane stats;
    private DefaultListModel<Item> data = new DefaultListModel<>();
    Item active;
    Item none=new Item("none","none",0,0,0,0,0);
    public Backpack(Player player) {

        this.setContentPane(this.panel);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(1300,700);
        use.setEnabled(false);
        drop.setEnabled(false);
        list1.setModel(data);
        updateStats(player);
        for (int i = 0; i < player.getInv().size(); i++) {
            data.addElement(player.getInv().get(i));
        }
        helmet.setText(player.getHelmet().name);

        helmet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.clearSelection();
                active=player.getHelmet();
            desc.setText(active.opis());
            if(!active.equals(none)){
                use.setEnabled(true);
                drop.setEnabled(true);
                use.setText("Unequip");
            }
            }
        });
        list1.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                active= (Item) list1.getSelectedValue();
                if(active!=null){
                desc.setText(active.opis());
                use.setEnabled(true);
                drop.setEnabled(true);
                use.setText("Equip");
            }}
        });
        use.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(use.getText().equals("Equip")){
                    Item temp=player.equip(active);
                    data.remove(list1.getSelectedIndex());
                    if(!temp.name.equals("none"))data.addElement(temp);
                }else{
                    Item temp=player.equip(new Item(none,active));
                    data.addElement(temp);
                }updateStats(player);
            }
        });
        drop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(use.getText().equals("Equip")){
                    data.remove(list1.getSelectedIndex());
                }else{
                    Item temp=player.equip(none);
                }updateStats(player);
            }
        });

        armor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.clearSelection();
                active=player.getArmor();
                desc.setText(active.opis());
                if(!active.equals(none)){
                    use.setEnabled(true);
                    drop.setEnabled(true);
                    use.setText("Unequip");
                }
            }
        });
        boots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.clearSelection();
                active=player.getBoots();
                desc.setText(active.opis());
                if(!active.equals(none)){
                    use.setEnabled(true);
                    drop.setEnabled(true);
                    use.setText("Unequip");
                }
            }
        });
        shield.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.clearSelection();
                active=player.getShield();
                desc.setText(active.opis());
                if(!active.equals(none)){
                    use.setEnabled(true);
                    drop.setEnabled(true);
                    use.setText("Unequip");
                }
            }
        });
        weapon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list1.clearSelection();
                active=player.getWeapon();
                desc.setText(active.opis());
                if(!active.equals(none)){
                    use.setEnabled(true);
                    drop.setEnabled(true);
                    use.setText("Unequip");
                }
            }
        });
    panel.addMouseListener(new MouseAdapter() { } );}
    public void update(Player player){
        data.addElement(player.getInv().get(player.getInv().size()-1));
    }
    public void updateStats(Player player){
        stats.setText("MaxHP: "+player.getHp()+"\n"
                +"Defense: "+player.getDef()+"\n"
                +"Damage: "+player.getDamage()+"\n"
                +"Speed: "+player.getSpeed());
    }
}
