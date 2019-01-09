package terminkalender.dao.interfaces;

public interface ObjectDAO
{
    //Hilfsfunktion, erstelle die persistence entity objekt, um mit dem Datenbank zu kommunizieren
    void initTransaction();

    //Hilfsfunktion, schliesst die persistence entity objekt aus
    void finishTransaction();
}
