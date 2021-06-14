public interface IService <T> {

    public Client searchClient(String nci);

    public Local searchLocal(String numLocal);

    public Reservation searchReservation(int id);

    public void createLocal(Local local);

    public void createClient(Client client);

    public void listerLocal();

    public void listerLocalByType(int typeLocalInt);
    
    public void listerLocalByClient(String nci);

    public void doReservation(Reservation reservation);

    public void cancelReservation(Reservation reservation);

}
