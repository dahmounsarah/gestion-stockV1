package dz.elit.exception;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    ARTICLE_INVALID(1001),
    CODE_NOT_EXSIT(1002),
    CATOGORY_NOT_FOUD(2000),
    CATOGORY_NOT_VALID(2001),
    CLIENT_NOT_FOUND(3000),
    COMMANDE_CLEINT_NOT_VALID(4000),
    COMMANDE_CLEINT_NOT_FOUD(4001),
    COMMANDE_FOURNISSEUR_NOT_VALID(5000),
    VENTE_NOT_FOUND(0600),
    VENTE_INVALID(6001),
    ENTREPRISE_INVALIDE(7000),
    ENTREPRISE_NOT_foud(7001),
    UTILISATEUR_NOT_FOUD(8000),
    BAD_CREDENTIALS(100000);





    private int code;

    ErrorCodes(int code){
        this.code=code;
    }
    public int getCode(){
        return code;
    }


}
