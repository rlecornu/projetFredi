import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fennetre_connexion extends JFrame implements ActionListener{
    private JLabel monEtiquette;
    private JTextArea champ_MDP;
    private JTextField entee_MDP;
    private JTextArea champ_ID;
    private JTextField entee_ID;
    private JButton buttonafficher;
    private JPanel c1;
    private bdd bdd;
    public fennetre_connexion(){
        setTitle(Constants.title);                                     //céation d'une fenetre
        setSize(Constants.width,Constants.height);                                             //getContentPane().
        setLocation(50,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        bdd = new bdd(Constants.url,Constants.log_id,Constants.log_mdp);
       
        setResizable(false);


        monEtiquette = new JLabel(Constants.text_connexion);                         //céation d'un label
        monEtiquette.setText(Constants.text_connexion);
        monEtiquette.setBounds(235,5,300,30);
        monEtiquette.setForeground(Color.black);
        monEtiquette.setBackground(Color.yellow);
        monEtiquette.setFont(Constants.police);

        champ_MDP = new JTextArea("MDP");                          //céation d'une zone de texte
        champ_MDP.setBackground(Constants.BackGround);
        champ_MDP.setForeground(Color.black);
        champ_MDP.setFont(Constants.police);
        champ_MDP.setBounds(100+60,100,60,40);

        entee_MDP = new JTextField("mdp");                          //céation d'une zone d'entrée de texte
        entee_MDP.setBackground(Constants.BackGround2);
        entee_MDP.setForeground(Color.GRAY);
        entee_MDP.setFont(Constants.police);
        entee_MDP.setBounds(180+80,90,200,40);
        entee_MDP.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (entee_MDP.getText().equals("mdp")) {
                    entee_MDP.setText("");
                    entee_MDP.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (entee_MDP.getText().isEmpty()) {
                    entee_MDP.setForeground(Color.GRAY);
                    entee_MDP.setText("mdp");
                }
            }
            });
        
        champ_ID = new JTextArea("ID");                          //céation d'une zone de texte
        champ_ID.setBackground(Constants.BackGround);
        champ_ID.setForeground(Color.black);
        champ_ID.setFont(Constants.police);
        champ_ID.setBounds(100+60,50,60,40);

        entee_ID = new JTextField("id");                          //céation d'une zone d'entrée de texte
        entee_ID.setBackground(Constants.BackGround2);
        entee_ID.setForeground(Color.GRAY);
        entee_ID.setFont(Constants.police);
        entee_ID.setBounds(180+80,40,200,40);
        entee_ID.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (entee_ID.getText().equals("id")) {
                    entee_ID.setText("");
                    entee_ID.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (entee_ID.getText().isEmpty()) {
                    entee_ID.setForeground(Color.GRAY);
                    entee_ID.setText("id");
                }
            }
            });

        buttonafficher = new JButton("Se connecter");                     //céation d'un bouton
        buttonafficher.setBounds(220,140,150,40);
        buttonafficher.setBackground(Color.gray);
        buttonafficher.setForeground(Color.black);
        buttonafficher.addActionListener(this);
        
        c1 = new JPanel();
        c1.add(monEtiquette);
        c1.add(champ_MDP);
        c1.add(champ_ID);
        c1.add(entee_MDP);
        c1.add(entee_ID);
        c1.add(buttonafficher);
        c1.setLayout(null);


        c1.setBounds(Constants.ConOffsetX,Constants.ConOffsetY,Constants.ConWidth,Constants.ConHeight);

        c1.setBackground(Constants.BackGround);
        add(c1);
        setVisible(true);

    }
    /**
     * acion lors que le bouton es pressé
     */
    public void actionPerformed(ActionEvent e) {
        // System.out.println("actionperformed");
        if ( bdd.testconnexion(entee_ID.getText(),entee_MDP.getText())){
            monEtiquette.setText(Constants.text_reussite_connexion);
            monEtiquette.setBounds(235,5,300,30);
            utilisateur currentuser = bdd.connexion(entee_ID.getText(),entee_MDP.getText());
            System.out.println(currentuser);
            if (currentuser.getType()=="standard") {
                
            }else if (currentuser.getType()=="standard") {
                
            }
            new fennetre_stanMesDéclaration(currentuser);
            this.dispose();                                                 // fermeture de la fenetre
        }else{
            monEtiquette.setText(Constants.text_echec_connexion);
            monEtiquette.setBounds(120,5,450,30);
        }
    }
}