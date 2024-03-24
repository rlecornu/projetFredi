import java.net.URI;
import java.sql.*;
import java.awt.Desktop;
import java.net.URI;
public class bdd{
private Connection conn;    //attribut qui memorise la connexion a la base
            
    /**
     * Le constructeur de la classe etablit la connexion.
     * parametres : l'adresse de la base de donnees,
     *  le login et le mot de passe
     */
    public bdd(String adresseBD, String nomLogin, String mdp) {
        System.out.println("bdd");

        try {           
            //Enregistrement de la classe du driver par le driverManager
            System.out.println("Driver reche...");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver trouve...");
            //Creation d'une connexion à la base de donnees
            conn = DriverManager.getConnection(adresseBD, nomLogin, mdp);
            System.out.println("Connexion etablie...");
            System.out.println("");
        }
        catch(Exception e){
            //Affiche le message d'erreur si une erreur se produit durant la connexion
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Methode qui verifie si l'utilisateur existe
     */
    public boolean testconnexion(String id,String mdp){
        int existe = 0 ;
        try {   
            //Creation de la requete
            // nom et prenom des etudiante-s de Grenoble
            String sqlStr = "SELECT count(*) FROM compte where mot_de_passe = '"+mdp+"' and nom = '"+id+"'";
            Statement stmt = conn.createStatement();
            
            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requete executee ....\n" );
            while (res.next()) {
                System.out.println(res.getString(1));
                existe = res.getInt(1);
                }
            }
        catch(Exception e){
            //si une erreur se produit, affichage du message correspondant
            System.out.println(e.getMessage()+"testconnexion");
            System.exit(0);
            }
        if (existe == 1){
            return true;
        }else  if (existe == 0){
            return false;
        }
        return false;
    }

    /**
     * Methode qui récupère les donnée utilisateur
     */
    public utilisateur connexion(String id,String mdp){
        ResultSet res ;
        utilisateur currentuser = new utilisateur("","","",0,"");
        try {   
            //Creation de la requete
            // nom et prenom des etudiante-s de Grenoble
            String sqlStr = "SELECT * FROM compte where mot_de_passe = '"+mdp+"' and nom = '"+id+"'";
            Statement  stmt = conn.createStatement();
            
            //execution de la requete
            res = stmt.executeQuery(sqlStr);
            System.out.println("requete executee ....\n" );
            while (res.next()) {
                currentuser = new utilisateur(res.getString(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(6));
                
                }
            }
        catch(Exception e){
            //si une erreur se produit, affichage du message correspondant
            System.out.println(e.getMessage()+"connexion");
            System.exit(0);
            }
        return currentuser;
    }

    /**
     * Methode qui récupere la liste des déclaration de l'utilisateur
     */
    public String[][] FindMesDeclaration(utilisateur currentuser){
        int count = 0;
        int size =0;
        String[][] liste = { { "0" }};
        try {   
            //Creation de la requete
            // nom et prenom des etudiante-s de Grenoble
            String sqlStr = "SELECT Count(*) FROM declaration WHERE compte = "+currentuser.getTel();
            Statement stmt = conn.createStatement();
            
            //execution de la requete
            ResultSet res = stmt.executeQuery(sqlStr);
            System.out.println("requete executee ....\n" );
            while (res.next()) {
                size = res.getInt(1);
            }


            sqlStr = "SELECT * FROM declaration WHERE compte = "+currentuser.getTel();
            stmt = conn.createStatement();
            
            //execution de la requete
            res = stmt.executeQuery(sqlStr);
            System.out.println("requete executee ....\n" );
            liste = new String[size][10];
            while (res.next()) {
                
                res.getString(4).length();
                liste[count][0] = ""+res.getInt(1);
                liste[count][1] = ""+res.getInt(2);
                liste[count][2] = ""+res.getDate(3);
                liste[count][3] = res.getString(4);
                liste[count][4] = res.getString(5);
                liste[count][5] = ""+res.getFloat(6)+"kms";
                liste[count][6] = ""+res.getFloat(7)+"€";
                liste[count][7] = ""+res.getFloat(8)+"€";
                liste[count][8] = ""+res.getFloat(9)+"€";
                liste[count][9] = res.getString(10);
                count++;
            }
        }
        catch(Exception e){
            //si une erreur se produit, affichage du message correspondant
            System.out.println(e.getMessage()+"testconnexion");
            System.exit(0);
        }
        // for (int i = 0; i < liste.length; i++) {
        //     for (int j = 0; j < liste[i].length; j++) {
        //         System.out.print(liste[i][j] + " ");
        //     }
        //     System.out.println("");
        // }
        return liste;
    }
}