package Observer;

public interface Observable {  //Duyuru sistemindeki kullanıcıların temsili interface'i

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    String notifyObserver(int kullanici_id);
}
