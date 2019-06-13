package sample;

import com.mysql.cj.xdevapi.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.security.auth.login.FailedLoginException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class UpdateController implements Initializable {
//SCENE BUILDER
    @FXML private TextField text1;
    @FXML private TextField text2;
    @FXML private TextField text3;
    @FXML private TextField text4;
    @FXML private TextField text5;
    @FXML private TextField text6;
    @FXML private TextField text7;
    @FXML private TextField text8;
    @FXML private Label label1;
    @FXML private Button boton1;
    @FXML private ComboBox combo1;

    private Controller controller;
    private VistaCompra vistaCompra;
    private OpereacionesCliente opereacionesCliente;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        opereacionesCliente = new OpereacionesCliente();
        combo1.getItems().add("Boleto Pagado");
        combo1.getItems().add("Boleto Sin Pagar");
        combo1.setValue("Boleto Sin Pagar");
//SE DESABILITAN LOS ID
        text1.setDisable(true);
        text5.setDisable(true);
        text6.setDisable(true);

        boton1.setOnMousePressed((event)->{
            Cliente cliente = new Cliente();
            Seccion seccion = new Seccion();
            Compra compra = new Compra();

            cliente.setClienteId(vistaCompra.getClienteID());
            cliente.setNombre(text2.getText());
            cliente.setApellidos(text3.getText());
            cliente.setDireccion(text4.getText());

            compra.setCompraId(vistaCompra.getCompraId());
            compra.setClienteId(vistaCompra.getClienteID());
            compra.setNumBoleto(vistaCompra.getNumBoleto());
            if(combo1.getValue().equals("Boleto Pagado")){
                compra.setPagado(true);
            } else {
                compra.setPagado(false);
            }
            compra.setFechaHora(vistaCompra.getFechaHora());

            seccion.setSeccionId(vistaCompra.getSeccionId());
            seccion.setDescipcion(text7.getText());
            seccion.setPrecio(Float.parseFloat(text8.getText()));


            opereacionesCliente.updateRegistro(compra,cliente,seccion);
            controller.getRegistros();
//EVENTO DEL BOTTON QUE AL SER PRESIONADO CIERRE LA VENTANA
            Stage stage = (Stage)((Button)event.getSource()).getScene().getWindow();
            stage.close();

        });

    }
//AL MOMENTO DE GUARDAR CIERRA Y EJECUTA EN EL PANE ORIGINAL
    public void setController(Controller controller,VistaCompra vistaCompra){
        this.controller = controller;
        this.vistaCompra = vistaCompra;
        this.cargarDatos();
    }

    public void cargarDatos(){
        text1.setText(vistaCompra.getClienteID()+"");
        text2.setText(vistaCompra.getClienteNombre());
        text3.setText(vistaCompra.getClienteApellidos());
        text4.setText(vistaCompra.getClienteDireccion());


        text5.setText(vistaCompra.getNumBoleto()+"");
        if(vistaCompra.isPagado()){
            combo1.setValue("Boleto Pagado");
        } else {
            combo1.setValue("Boleto Sin Pagar");
        }

        label1.setText(new SimpleDateFormat("yyyy-mm-dd").format(vistaCompra.getFechaHora()));

        text6.setText(vistaCompra.getSeccionId()+"");
        text7.setText(vistaCompra.getSeccionDescripcion());
        text8.setText(vistaCompra.getSeccionPrecio()+"");
    }
}
