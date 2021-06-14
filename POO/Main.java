//import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.time.*;
public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public Validator validator = new Validator();
    public static void main(String args[])
    {
        IService<List<Local>> service = new ServiceList();
        
        int choix;
        
        do
        {
            choix = menu();
            String nci;
            String localisation;
            String prix;
            String tauxLoc;
            String dimension;
            String nbrePiece;
            switch(choix)

            {
            case 1:
                do
                {
                    System.out.print("Entrer la localisation du local : ");
                    localisation = scanner.nextLine();
                }while(!Validator.isLocalisation(localisation));

                do
                {
                    System.out.print("Entrer le prix du local : ");
                    prix = scanner.nextLine();
                }while(!Validator.isPrix(prix));

                do
                {
                    System.out.print("Entrer le taux de location du local : ");
                    tauxLoc = scanner.nextLine();
                }while(!Validator.isTauxLoc(tauxLoc));

                String type ;
                int typeLocalInt ;
                do{
                    System.out.println("Quel type de local tu veux ajouter ?: "
                            + "\n 1- Chambre" 
                            + "\n 2- Appartement");
                    type = scanner.nextLine();
                    typeLocalInt = Integer.parseInt(type);

                } while (typeLocalInt != 2 && typeLocalInt != 1);
                Local local;
                if(typeLocalInt == 1 )
                {
                    do
                    {
                        System.out.print("Entrer la dimension : ");
                        dimension = scanner.nextLine();
                    }while(!Validator.isDimension(dimension));
                    local = new Chambre(Integer.parseInt(prix),localisation,Integer.parseInt(tauxLoc),Integer.parseInt(dimension));
                }else
                {
                    do
                    {
                        System.out.print("Entrer le nombre de pièces : ");
                        nbrePiece = scanner.nextLine();
                    }while(!Validator.isNbrePiece(nbrePiece) & Integer.parseInt(nbrePiece)<3);
                    local = new Appartement(Integer.parseInt(prix),localisation,Integer.parseInt(tauxLoc), Integer.parseInt(nbrePiece));
        
                }

                
                service.createLocal(local);
                System.out.print("Le local a été ajouté et sa reference est est : " + local.getRef() );
                break;
            case 2:
                do{
                    System.out.println("Quel type de local ? "
                            + "\n 1- Chambre" 
                            + "\n 2- Appartement");
                    type = scanner.nextLine();
                    typeLocalInt = Integer.parseInt(type);

                } while (typeLocalInt != 2 && typeLocalInt != 1);
                service.listerLocalByType(typeLocalInt);
                
                
                break;
            case 3:
                
                do
                {
                    System.out.print("Entrer le nci du client: ");
                    nci = scanner.nextLine();
                }while(!Validator.isNci(nci));
                Client client = service.searchClient(nci);
                if (client == null)
                {
                    System.out.print("NCI introuvable ");

                }
                else
                {
                    System.out.println("Données du client "); 
                    System.out.println(client.afficher());
                    System.out.println("Les locaux réservés du client "); 
                    service.listerLocalByClient(nci);
                }
                break;
            case 4:
                String numLocal;
                Local loc;
                System.out.print("Entrer la reference du local : ");
                numLocal = scanner.nextLine();

                loc = service.searchLocal(numLocal);
                if (loc != null)
                {
                    System.out.println("Détails du local");
                    System.out.println(loc.afficher());
                    
                }
                break;
             case 5:
                
                System.out.println("Faire une reservation ");

                do
                {
                    System.out.print("Entrer la reference du local que vous voulez réserver: ");
                    numLocal = scanner.nextLine();
                    loc = service.searchLocal(numLocal);

                } while (loc == null);

                do
                {
                    System.out.print("Entrer le nci : ");
                    nci = scanner.nextLine();
                } while(!Validator.isNci(nci));
                client = service.searchClient(nci);
                if (client == null)
                {String nomComplet;
                    String tel;
                    String adresse;
                    String email;
                    do
                    {
                        System.out.print("Entrer le Nom Complet du client : ");
                        nomComplet = scanner.nextLine();
                    }while(!Validator.isNomComplet(nomComplet));
                    
                    do
                    {
                        System.out.print("Entrer le Telephone du client : ");
                        tel = scanner.nextLine();
                    }while(!Validator.isTel(tel));

                    do
                    {
                        System.out.print("Entrer l'adresse du client : ");
                        adresse = scanner.nextLine();
                    }while(!Validator.isAdresse(adresse));
                    
                    do
                    {
                        System.out.print("Entrer l'email du client : ");
                        email = scanner.nextLine();
                    }while(!Validator.isEmail(email));
                    
                    
                    client = new Client(nci, nomComplet, tel, adresse, email);
                    service.createClient(client);
                    System.out.println(client.afficher());
                    

                }
                String duree;
                String etat;
                
                LocalDate date = LocalDate.now();

                do
                {
                    System.out.print("Entrer la duree de la reservation : ");
                    duree = scanner.nextLine();
                }while(!Validator.isDuree(duree));

                do
                {
                    System.out.print("Entrer l'etat de la reservation' : ");
                    etat = scanner.nextLine();
                }while(!Validator.isEtat(etat));

                Reservation reservation;
                reservation = new Reservation(date,Integer.parseInt(duree), etat);

                reservation.setNciClient(nci);
                reservation.setRefLocal(numLocal);
                service.doReservation(reservation);
                System.out.print("La reservation a été faite et son id est : " + reservation.getId() );
                break;
            case 6:
                System.out.println("Annuler Reservation ");
                do
                {
                    System.out.print("Entrer l'id de la reservation que vous voulez annuler: ");
                    String id = scanner.nextLine();
                    reservation = service.searchReservation(Integer.parseInt(id));

                } while (reservation == null);

                service.cancelReservation(reservation);
                break;
            case 7:
                System.out.println("Locaux disponibles ");
                service.listerLocal();
                break;
            case 8:
                System.out.println("Bye :( "); 
                break;
            default:
                System.out.println("Mauvais choix :( ");
            }
            
        } while (choix != 8);
    }

    public static int menu()
    {
        int choix;
        System.out.println
        ("\n Menu"
        + "\n 1-Ajouter local"  
        + "\n 2-Lister locaux par type"
        + "\n 3-Lister locaux réservés par un client"
        + "\n 4-Voir details d'un local"
        + "\n 5-Faire une reservation"
        + "\n 6-Annuler une reservation"
        + "\n 7-Lister locaux disponibles"
        + "\n 8-Quitter");
        System.out.print("Faites votre choix : ");
        choix = Integer.parseInt(scanner.nextLine());
        return choix;
    }
}
