import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fennetre_standard1 extends JFrame implements ActionListener{
    private JLabel monEtiquette;
    private JButton buttonmesdeclaration;
    private JButton buttonmesnouveldec;
    private JButton buttonmescerfa;
    private JButton buttonmescompte;
    private JButton buttonmesdéconection;
    private JPanel c1;
    private bdd bdd;
    public fennetre_standard1(utilisateur currentuser){
        setTitle(Constants.title);                                     //céation d'une fenetre
        setSize(Constants.width,Constants.height);                                             //getContentPane().
        setLocation(50,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        bdd = new bdd(Constants.url,Constants.log_id,Constants.log_mdp);
       
        setResizable(false);


        monEtiquette = new JLabel(Constants.text_connexion);                         //céation d'un label
        monEtiquette.setText(currentuser.getnom());
        monEtiquette.setBounds((Constants.width)/2-100,5,300,30);
        monEtiquette.setForeground(Color.black);
        monEtiquette.setBackground(Color.yellow);
        monEtiquette.setFont(Constants.police);
        
        buttonmesdeclaration = new JButton("mes déclaration");                     //céation d'un bouton
        buttonmesdeclaration.setBounds(0,40,Constants.buttonwidth,40);
        buttonmesdeclaration.setBackground(Color.gray);
        buttonmesdeclaration.setForeground(Color.black);
        buttonmesdeclaration.addActionListener(this);

        buttonmesnouveldec = new JButton("nouvel déclaration");                     //céation d'un bouton
        buttonmesnouveldec.setBounds(Constants.buttonwidth,40,Constants.buttonwidth,40);
        buttonmesnouveldec.setBackground(Color.gray);
        buttonmesnouveldec.setForeground(Color.black);
        buttonmesnouveldec.addActionListener(this);

        buttonmescerfa = new JButton("télécharger mes  CERFA ");                     //céation d'un bouton
        buttonmescerfa.setBounds(2*Constants.buttonwidth,40,Constants.buttonwidth,40);
        buttonmescerfa.setBackground(Color.gray);
        buttonmescerfa.setForeground(Color.black);
        buttonmescerfa.addActionListener(this);

        buttonmescompte = new JButton("mon Compte ");                     //céation d'un bouton
        buttonmescompte.setBounds(3*Constants.buttonwidth,40,Constants.buttonwidth,40);
        buttonmescompte.setBackground(Color.gray);
        buttonmescompte.setForeground(Color.black);
        buttonmescompte.addActionListener(this);

        buttonmesdéconection = new JButton("se déconnecter ");                     //céation d'un bouton
        buttonmesdéconection.setBounds(4*Constants.buttonwidth,40,Constants.buttonwidth,40);
        buttonmesdéconection.setBackground(Color.gray);
        buttonmesdéconection.setForeground(Color.black);
        buttonmesdéconection.addActionListener(this);
        
        c1 = new JPanel();
        c1.add(monEtiquette);
        c1.add(buttonmesdeclaration);
        c1.add(buttonmesnouveldec);
        c1.add(buttonmescerfa);
        c1.add(buttonmescompte);
        c1.add(buttonmesdéconection);
        c1.setLayout(null);


        c1.setBounds(0,0,Constants.width,Constants.height);
        c1.setBackground(Constants.BackGround);
        add(c1);
        setVisible(true);

    }
    /**
     * acion lors que le bouton es pressé
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if (e.getSource()==buttonmesdéconection){                           // action déconection
            new fennetre_connexion();
            this.dispose();                                         // fermeture de la fenetre
        }
    }
}