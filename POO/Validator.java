import java.util.regex.*;
public class Validator {
    public static boolean isEmail(String email)
    {
        //String regExp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,}$";
        String regExp = "^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$";
        Pattern pat = Pattern.compile(regExp);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }


    public static boolean isNci(String nci)
    {
        String regExp = "^[\\d\\s]{17,20}$";
        Pattern pat = Pattern.compile(regExp);
        if (nci == null)
            return false;
        return pat.matcher(nci).matches();
    }

    public static boolean isNomComplet(String nomComplet)
    {
        String regExp = "^[-\\w\\s]+$";
        Pattern pat = Pattern.compile(regExp);
        if (nomComplet == null)
            return false;
        return pat.matcher(nomComplet).matches();
    }

    public static boolean isTel(String tel)
    {
        String regExp = "^[\\d]{9}$";
        Pattern pat = Pattern.compile(regExp);
        if (tel == null)
            return false;
        return pat.matcher(tel).matches();
    }

    public static boolean isAdresse(String adresse)
    {
        String regExp = "^[-\\d\\w\\s,]+$";
        Pattern pat = Pattern.compile(regExp);
        if (adresse == null)
            return false;
        return pat.matcher(adresse).matches();
    }

    public static boolean isLocalisation(String localisation)
    {
        String regExp = "^[-\\w\\s,]+$";
        Pattern pat = Pattern.compile(regExp);
        if (localisation == null)
            return false;
        return pat.matcher(localisation).matches();
    }

    public static boolean isEtat(String etat)
    {
        String regExp = "^[\\w\\s]+$";
        Pattern pat = Pattern.compile(regExp);
        if (etat == null)
            return false;
        return pat.matcher(etat).matches();
    }

    public static boolean isPrix(String prix)
    {
        String regExp = "^[\\d]+$";
        Pattern pat = Pattern.compile(regExp);
        if (prix == null)
            return false;
        return pat.matcher(prix).matches();
    }

    public static boolean isDimension(String dimension)
    {
        String regExp = "^[\\d]+$";
        Pattern pat = Pattern.compile(regExp);
        if (dimension == null)
            return false;
        return pat.matcher(dimension).matches();
    }

    public static boolean isNbrePiece(String nbrePiece)
    {
        String regExp = "^[\\d]+$";
        Pattern pat = Pattern.compile(regExp);
        if (nbrePiece == null)
            return false;
        return pat.matcher(nbrePiece).matches();
    }

    public static boolean isDuree(String duree)
    {
        String regExp = "^[\\d]+$";
        Pattern pat = Pattern.compile(regExp);
        if (duree == null)
            return false;
        return pat.matcher(duree).matches();
    }

    public static boolean isTauxLoc(String tauxLoc)
    {
        String regExp = "^[\\d]+$";
        Pattern pat = Pattern.compile(regExp);
        if (tauxLoc == null)
            return false;
        return pat.matcher(tauxLoc).matches();
    }

    // public static void main(String[] args) {
    //     System.out.println(isEmail("vsbc-jnv@sdgs.fbj"));
    //     System.out.println(isNci("0061-52 05-448"));
    //     System.out.println(isNomComplet("gh-jkn vjbkjn"));
    //     System.out.println(isTel("781854127"));
    //     System.out.println(isAdresse("69, rue du colo"));
    // }
    
}
