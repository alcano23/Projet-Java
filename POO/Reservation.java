import java.time.*;


public class Reservation {
    private LocalDate date;
    private int duree;
    private String etat;
    private int id;
    private static int nbreReservation;

    //Attribut navigationnel 1
    private String nciClient;

    public void setNciClient(String nciClient){
        this.nciClient=nciClient;
    }

    public String getNciClient(){
        return nciClient;
    }

    //Attribut navigationnel 2
    private String refLocal;
    
    public void setRefLocal(String refLocal){
        this.refLocal=refLocal;
    }

    public String getRefLocal(){
        return refLocal;
    }

    
    //Setters
    public void setDate(LocalDate date){
        this.date=date;
    }
    public void setDuree(int duree){
        this.duree=duree;
    }
    public void setEtat(String etat){
        this.etat=etat;
    }

    //Getters
    public LocalDate getDate(){
        return date;
    }
    public int  getDuree(){
        return duree;
    }
    public String getEtat(){
        return etat;
    }
    public int  getId(){
        return id;
    }

    

    //constructeur
    public Reservation(LocalDate date, int duree, String etat){
        id=++nbreReservation;
        this.setDate(date);
        this.setDuree(duree);
        this.setEtat(etat);
    }

    
}
