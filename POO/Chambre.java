public class Chambre extends Local
{
    private int dimension;

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public Chambre()
    {
        type=1;
    }

    public Chambre(int prix, String localisation, int tauxLoc, int dimension)
    {
        super(prix, localisation, tauxLoc);
        this.setDimension(dimension); 
        type= 1; 
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
        + "\n dimension : " + getDimension();
    }
    
}
