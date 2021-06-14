public class Appartement extends Local
{
    private int nbrePiece;

    public int getNbrePiece() {
        return nbrePiece;
    }

    public void setNbrePiece(int nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public Appartement()
    {
        type=2;
    }

    public Appartement(int prix, String localisation, int tauxLoc, int nbrePiece)
    {
        super(prix, localisation, tauxLoc);
        this.setNbrePiece(nbrePiece);
        type=2; 
    }

    @Override
    public void cout(int prix, float tauxLoc) {
        if (prix > 0 && tauxLoc>0)
        {
            prix += (tauxLoc / 100) * prix;
        }
        else 
        {
            System.out.println("Prix et/ou taux de location invalide");
        }
    }

    @Override
    public String afficher()
    {
        return super.afficher() 
        + "\n nbrePiece : " + getNbrePiece();
    }
    
}

