import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class fennetre_stanNewDéclaration extends JFrame implements ActionListener{
    private JLabel monEtiquette;
    private JLabel labelDate;
    private JButton buttonmesdeclaration;
    private JButton buttonmesnouveldec;
    private JButton buttonmescerfa;
    private JButton buttonmescompte;
    private JButton buttonmesdéconection;
    private JTextField DateY;
    private JComboBox DateM;
    // private bdd bdd;
    private utilisateur currentuser;
    public fennetre_stanNewDéclaration(utilisateur currentuser){
        this.currentuser = currentuser;
        setTitle(Constants.title);                                     //céation d'une fenetre
        setSize(Constants.width,Constants.height);                                             //getContentPane().
        setLocation(50,20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        // bdd = new bdd(Constants.url,Constants.log_id,Constants.log_mdp);
       
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


        labelDate = new JLabel("Date");                         //céation d'un label
        labelDate.setBounds(40,150,300,30);
        labelDate.setForeground(Color.black);
        labelDate.setBackground(Color.yellow);
        labelDate.setFont(Constants.police);


        DateY = new JTextField("yyyy");                          //céation d'une zone d'entrée de texte
        DateY.setBackground(Constants.BackGround2);
        DateY.setForeground(Color.GRAY);
        DateY.setFont(Constants.police);
        DateY.setBounds(100,150,60,30);
        DateY.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (DateY.getText().equals("yyyy")) {
                    DateY.setText("");
                    DateY.setForeground(Color.BLACK);
                }
            }
            public void focusLost(FocusEvent e) {
                if (DateY.getText().isEmpty()) {
                    DateY.setForeground(Color.GRAY);
                    DateY.setText("yyyy");
                }
            }
        });
        

        DateM = new JComboBox<String>(new String[]{"janvier","fevrier","mars","avril","mai","juin","juillet","aout","septembre","octobre","novembre","decembre"});
        DateM.setBounds(170,150,150,30);
        DateM.setBackground(Constants.BackGround2);
        DateM.setFont(Constants.police);



        
        
        this.add(monEtiquette);
        this.add(labelDate);
        this.add(buttonmesdeclaration);
        this.add(buttonmesnouveldec);
        this.add(buttonmescerfa);
        this.add(buttonmescompte);
        this.add(buttonmesdéconection);
        this.add(DateY);
        this.add(DateM);
        this.setLayout(null);

        setVisible(true);

    }
    /**
     * acion lors que le bouton es pressé
     */
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        if (e.getSource()==buttonmesdeclaration){                               // action mes déclaration
            new fennetre_stanMesDéclaration(this.currentuser);
            this.dispose();                                         // fermeture de la fenetre
        }else if (e.getSource()==buttonmesnouveldec){                           // action nouvle déclaration
            new  fennetre_stanNewDéclaration(this.currentuser);
            this.dispose();                                         // fermeture de la fenetre
        }else if (e.getSource()==buttonmescerfa){                               // action mes cerfa
            new fennetre_stanMesCERFA(this.currentuser);
            this.dispose();                                         // fermeture de la fenetre
        }else if (e.getSource()==buttonmescompte){                              // action mon compte
            new fennetre_stanMonCompte(this.currentuser);
            this.dispose();                                         // fermeture de la fenetre
        }else if (e.getSource()==buttonmesdéconection){                         // action déconection
            new fennetre_connexion();
            this.dispose();                                         // fermeture de la fenetre
        }
    }
}