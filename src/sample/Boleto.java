package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Boleto {
    private IntegerProperty boletoId = new SimpleIntegerProperty();
    private IntegerProperty seccionID = new SimpleIntegerProperty();


    public int getBoletoId() {
        return boletoId.get();
    }

    public IntegerProperty boletoIdProperty() {
        return boletoId;
    }

    public void setBoletoId(int boletoId) {
        this.boletoId.set(boletoId);
    }

    public int getSeccionID() {
        return seccionID.get();
    }

    public IntegerProperty seccionIDProperty() {
        return seccionID;
    }

    public void setSeccionID(int seccionID) {
        this.seccionID.set(seccionID);
    }

    @Override
    public String toString(){
        return "Boleto{" +
                "numBoleto="+boletoId.get()+"," +
                "seccionId="+seccionID.get()+"}";
    }
}
