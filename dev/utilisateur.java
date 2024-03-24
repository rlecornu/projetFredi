public class utilisateur {
    public String nom;
    public String mail;
    public String code_postal;
    public int tel;
    public String type;
    public utilisateur(String nom,String mail,String code_postal,int tel,String type){
        this.nom = nom;
        this.mail = mail;
        this.code_postal = code_postal;
        this.tel = tel;
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

    public int getTel(){
        return this.tel;
    }

    public String getcode_postal(){
        return this.code_postal;
    }

    public String getmail(){
        return this.mail;
    }

    public String getnom(){
        return this.nom;
    }

    @Override
    public String toString() {
        String res = "type " +getType()+" \ntel "+getTel()+" \ncode postal "+getcode_postal()+" \nmail "+getmail()+" \nnom "+getnom();
        return res;
    }
}

