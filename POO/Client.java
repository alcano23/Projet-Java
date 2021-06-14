public class Client implements IAffiche
{
    private String nci;
    private String nomComplet;
    private String tel;
    private String adresse;
    private String email;


    // Attribut navigationnel 
    private Reservation[] tableReservation = new Reservation[5];

    public Client()
    {

    }

    public Client(String nci, String nomComplet, String tel, String adresse, String email)
    {
        this.setNci(nci);
        this.setNomComplet(nomComplet);
        this.setTel(tel);
        this.setAdresse(adresse);
        this.setEmail(email);
    }
    
    private int nombreDeReservations;

    public int getNombreDeReservation()
    {
        return nombreDeReservations;
    }

    
    public Reservation[] getTableReservation() {
        return tableReservation;
    }

    public void addReservation( Reservation reservation) {
        tableReservation[nombreDeReservations] = reservation;
        nombreDeReservations++;
    }

    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
    
    public String getNci() {
        return nci;
    }    
    public void setNci(String nci) {
        this.nci = nci;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String afficher() {
        return "\n Nci : " + getNci() 
        + "\n Nom Complet : " + getNomComplet()
        + "\n Telephone : " + getTel()
        + "\n Adresse : " + getAdresse()
        + "\n Email : " + getEmail() ;
    }
}
