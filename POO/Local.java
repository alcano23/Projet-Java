public abstract class Local implements IAffiche
{
    private static int nombreLocal;
    private final int FORMAT = 4;
    protected String ref;
    protected int prix;
    protected String localisation;
    protected int tauxLoc;
    protected int type;


    //attribut navigationnel
    private Reservation[] tableReservationLocals = new Reservation[5];

    
    private int nombreDeReservations;

    public int getNombreDeReservation()
    {
        return nombreDeReservations;
    }

    
    public Reservation[] getTableReservation() {
        return tableReservationLocals;
    }

    public void addReservationLocal( Reservation reservation) {
        tableReservationLocals[nombreDeReservations] = reservation;
        nombreDeReservations++;
    }
    
    
    private String generateRef()
    {
        String nombreZero = "";
        String nombreDeLocalString = String.valueOf(++nombreLocal);
        for(int i=1; i<=(FORMAT - nombreDeLocalString.length()); i++)
        {
            nombreZero += "0";
        }
        return nombreZero + nombreDeLocalString;
    }


    public String getRef() {
        return ref;
    }
    public int getPrix() {
        return prix;
    }
    public int getType() {
        return type;
    }
    public String getLocalisation() {
        return localisation;
    }
    public int getTauxLoc() {
        return tauxLoc;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
    public void setType(int type) {
        this.type = type;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }
    public void setTauxLoc(int tauxLoc) {
        this.tauxLoc = tauxLoc;
    }

    
    public Local() {
        ref = generateRef();
    }
    
    public Local(int prix, String localisation, int tauxLoc) {
        ref = generateRef();
        this.setPrix(prix);
        this.setLocalisation(localisation);
        this.setTauxLoc(tauxLoc);
    }

    @Override
    public String afficher()
    {
        return "\n ref de Local : " + getRef() 
        + "\n localisation : " + getLocalisation()
        + "\n prix : " + getPrix()
        + "\n taux de location : " + getTauxLoc();
    }
    
    public abstract void cout(int prix, float tauxLoc);

}