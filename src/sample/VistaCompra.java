package sample;

import java.util.Date;
import javafx.scene.control.Button;

public class VistaCompra {
    private int compraId;
    private int numBoleto;
    private boolean pagado;
    private Date fechaHora;
    private int clienteID;
    private String clienteNombre;
    private String clienteApellidos;
    private String clienteDireccion;
    private int seccionId;
    private String seccionDescripcion;
    private float seccionPrecio;
    private  Button botonUpdate;
    private Button botonDelete;

    public VistaCompra(){//CREAMOS LOS BOTONES PARA LA TABLE VIEW
        this.botonUpdate = new Button("Modificar");
        this.botonDelete = new Button("Eliminar");
    }
    public VistaCompra(int compraId, int numBoleto, boolean pagado, Date fechaHora, int clienteID
            , String clienteNombre, String clienteApellidos, String clienteDireccion, int seccionId,
                       String seccionDescripcion, float seccionPrecio){
        this.compraId = compraId;
        this.numBoleto = numBoleto;
        this.pagado = pagado;
        this.fechaHora = fechaHora;
        this.clienteID = clienteID;
        this.clienteNombre = clienteNombre;
        this.clienteApellidos = clienteApellidos;
        this.clienteDireccion = clienteDireccion;
        this.seccionId = seccionId;
        this.seccionDescripcion = seccionDescripcion;
        this.seccionPrecio = seccionPrecio;
        this.botonUpdate = new Button("Modificar");
        this.botonDelete = new Button("Eliminar");
    }
//SE OBTIENEN Y SE REGRESAN
    public int getCompraId() {
        return compraId;
    }

    public int getNumBoleto() {
        return numBoleto;
    }
    public Date getFechaHora() {
        return fechaHora;
    }

    public int getClienteID() {
        return clienteID;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public String getClienteApellidos() {
        return clienteApellidos;
    }

    public String getClienteDireccion() {
        return clienteDireccion;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public String getSeccionDescripcion() {
        return seccionDescripcion;
    }
    public float getSeccionPrecio(){
        return  this.seccionPrecio;
    }

//SE OBTIENE LO MODIFICADO Y SE PARTICULIZA DE LA CLASE
    public void setCompraId(int compraId) {
        this.compraId = compraId;
    }

    public void setNumBoleto(int numBoleto) {
        this.numBoleto = numBoleto;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public void setClienteApellidos(String clienteApellidos) {
        this.clienteApellidos = clienteApellidos;
    }

    public void setClienteDireccion(String clienteDireccion) {
        this.clienteDireccion = clienteDireccion;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    public void setSeccionDescripcion(String seccionDescripcion) {
        this.seccionDescripcion = seccionDescripcion;
    }

    public void setSeccionPrecio(float seccionPrecio) {
        this.seccionPrecio = seccionPrecio;
    }

    public Button getBotonUpdate() {
        return botonUpdate;
    }

    public void setBotonUpdate(Button botonUpdate) {
        this.botonUpdate = botonUpdate;
    }

    public Button getBotonDelete() {
        return botonDelete;
    }

    public void setBotonDelete(Button botonDelete) {
        this.botonDelete = botonDelete;
    }

    public boolean isPagado() {
        return pagado;
    }
}
