package sample;

import javafx.beans.property.*;

public class Seccion {
    private IntegerProperty seccionId = new SimpleIntegerProperty();
    private StringProperty descipcion = new SimpleStringProperty();
    private FloatProperty precio  = new SimpleFloatProperty();

    public int getSeccionId() {
        return seccionId.get();
    }

    public IntegerProperty seccionIdProperty() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId.set(seccionId);
    }

    public String getDescipcion() {
        return descipcion.get();
    }

    public StringProperty descipcionProperty() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion.set(descipcion);
    }

    public float getPrecio() {
        return precio.get();
    }

    public FloatProperty precioProperty() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio.set(precio);
    }

    @Override
    public String toString(){
        return "Seccion{" +
                "seccionId="+seccionId.get()+"," +
                "Descripcion="+descipcion.get()+"," +
                "Precio="+precio.get()+"}";
    }
}
