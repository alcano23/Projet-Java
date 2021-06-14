import java.util.List;
import java.util.ArrayList;

public class ServiceList implements IService<List<Local>> {
    
    private List<Local> listLocals = new ArrayList<>();
    private List<Client> listClients = new ArrayList<>();
    private List<Reservation> listReservations = new ArrayList<>();

    @Override
    public Client searchClient(String nci) {

        for (Client client : listClients) {
            if (client.getNci().compareTo(nci) == 0) {
                return client;
            }
    
        }
        return null;
    }

    @Override
    public Reservation searchReservation(int id) {

        for (Reservation reservation : listReservations) {
            if (reservation.getId()==id) {
                return reservation;
            }
    
        }
        return null;
    }

    @Override
    public Local searchLocal(String numLocal) {
        for (Local local : listLocals) {
            if (local.getRef().compareTo(numLocal) == 0) {
                return local;
            }
    
        }
        return null;
    }

    @Override
    public void createLocal(Local local) {
        listLocals.add(local);       
    }

    @Override
    public void createClient(Client client) {
        listClients.add(client);       
    }

    @Override
    public void listerLocal() {
        for(Local local:this.listLocals){
            System.out.println(local.afficher());
        }
    }

    @Override
    public void doReservation(Reservation reservation) {
        listReservations.add(reservation);        
    }

    @Override
    public void cancelReservation(Reservation reservation) {
        listReservations.remove(reservation);        
    }

    @Override
    public void listerLocalByType(int typeLocalInt) {
        for(Local local:this.listLocals){
            if (local.getType()==typeLocalInt) {
                System.out.println(local.afficher());
            }
        }
        
    }

    @Override
    public void listerLocalByClient(String nci) {
        for(Reservation reservation:listReservations){
            if (reservation.getNciClient().compareTo(nci) == 0) {
                for(Local local:this.listLocals){
                    if (local.getRef().compareTo(reservation.getRefLocal()) == 0) {
                        System.out.println(local.afficher());
                    }
                }
            }
        }
        
                
    } 
    // public ArrayList<Local> listerReservationByClient(String nci) 
    // {
    //     ArrayList<Local> locauxClients = new ArrayList<>();
    //     // parcours de toutes les reservations 
    //     for(Reservation r:reservationDao.findAll())
    //     {
            
    //         if (r.getNciClient().equalsIgnoreCase(nci)) {
    //             //Parcours de tous les locaux 
    //             for (Local local : localDao.findAll()) {
                    
    //                 if (local.getRef().equalsIgnoreCase(r.getRefLocal())) {
    //                     locauxClients.add(local);
    //                 }
    //             }
    //         }
    //     }
    //     return locauxClients;
    // }
      
}
