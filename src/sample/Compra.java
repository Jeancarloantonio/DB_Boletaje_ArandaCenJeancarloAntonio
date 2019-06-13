package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Date;

public class Compra {
    private IntegerProperty compraId = new SimpleIntegerProperty();
    private IntegerProperty clienteId = new SimpleIntegerProperty();
    private IntegerProperty numBoleto = new SimpleIntegerProperty();
    private BooleanProperty pagado = new SimpleBooleanProperty();
    private Date fechaHora;


    public int getCompraId() {
        return compraId.get();
    }

    public IntegerProperty compraIdProperty() {
        return compraId;
    }

    public void setCompraId(int compraId) {
        this.compraId.set(compraId);
    }

    public int getClienteId() {
        return clienteId.get();
    }

    public IntegerProperty clienteIdProperty() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId.set(clienteId);
    }

    public int getNumBoleto() {
        return numBoleto.get();
    }

    public IntegerProperty numBoletoProperty() {
        return numBoleto;
    }

    public void setNumBoleto(int numBoleto) {
        this.numBoleto.set(numBoleto);
    }

    public boolean isPagado() {
        return pagado.get();
    }

    public BooleanProperty pagadoProperty() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado.set(pagado);
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString(){
        return "Compra{" +
                "compraId="+compraId.get()+"," +
                "clienteId="+clienteId.get()+"," +
                "numBoleto="+numBoleto.get()+"," +
                "fecha="+fechaHora.toString()+"," +
                "Pagado="+pagado.get()+"}";
    }
}
