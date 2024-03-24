import java.awt.*;
public interface Constants {
    final String title = "Projet FREDI";
    final int width =1400;
    final int height =750;
    final int ConWidth = (int)(width *0.4 );
    final int ConHeight = (int)(height / 4);
    final int ConOffsetY = (int)(height / 8 * 3);
    final int ConOffsetX = (int)(width *0.3);
    final int buttonwidth =280;
    final Color BackGround = Color.lightGray;
    final Color BackGround2 = Color.white;
    final Color ForeGround = Color.lightGray;
    final String text_connexion = "connexion";
    final String text_echec_connexion = "Vos identifiant de connexion sont incorect";
    final String text_reussite_connexion = "bravo";
    final Font police = new Font("Arial",Font.PLAIN,20);
    final String url = "jdbc:mysql://127.0.0.1:3306/projet_fredi";
    final String log_id = "standar";
    final String log_mdp = "fredi";
}