package sample;

import java.sql.*;
import java.util.ArrayList;

public class OpereacionesCliente {

    private Connection connection;

    public OpereacionesCliente() {
        try{
            DBManager manager = new DBManager();
            this.connection = manager.getConnection();

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }//CREATE
    public void insertCliente(Cliente cliente){
        String query = "INSERT INTO cliente (clienteId,nombre,apellidos,direccion)" +
                "VALUES (?,?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,cliente.getClienteId());
            stmt.setString(2,cliente.getNombre());
            stmt.setString(3,cliente.getApellidos());
            stmt.setString(4,cliente.getDireccion());
            if(!stmt.execute()){
                System.out.println("SU REGISTRO FUE EXITOSO");
            } else {
                System.out.println("REGISTRO INCORRECTO");
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

    }

    public void updateCliente(){

    }

    public void getClientes(){

    }

    public void getClienteById(){

    }
    public void deleteCompra(VistaCompra vistaCompra){
        try{

            String sql = "DELETE FROM compra WHERE compraId = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,vistaCompra.getCompraId());
            stmt.execute();

            sql = "DELETE FROM boleto WHERE numBoleto = ?";
            stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,vistaCompra.getNumBoleto());
            stmt.execute();

            sql = "DELETE FROM cliente WHERE clienteID = ?";
            stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,vistaCompra.getClienteID());
            stmt.execute();

            sql = "DELETE FROM seccion WHERE seccionId = ?";
            stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1,vistaCompra.getSeccionId());
            stmt.execute();

        }catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void insertBoleto(Boleto boleto,Seccion seccion,Compra compra){
        String query = "INSERT INTO seccion (seccionId,descripcion,precio)" +
                "VALUES (?,?,?)";
        try{
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1,seccion.getSeccionId());
            stmt.setString(2,seccion.getDescipcion());
            stmt.setFloat(3,seccion.getPrecio());
            if(!stmt.execute()){
                query = "INSERT INTO boleto (numBoleto,seccionId)" +
                        "VALUES (?,?)";

                stmt = this.connection.prepareStatement(query);
                stmt.setInt(1,boleto.getBoletoId());
                stmt.setFloat(2,seccion.getSeccionId());

                if(!stmt.execute()){
                    query = "INSERT INTO compra (clienteId,numBoleto,pagado,fechaHora)" +
                            "VALUES (?,?,?,?)";

                    stmt = this.connection.prepareStatement(query);
                    stmt.setInt(1,compra.getClienteId());
                    stmt.setInt(2,compra.getNumBoleto());
                    stmt.setBoolean(3,compra.isPagado());
                    stmt.setDate(4, new Date(compra.getFechaHora().getTime()) );

                    if(!stmt.execute()){
                        System.out.println("Agregado con exito");
                    } else {
                        System.out.println("Ocurrio un error");
                    }
                } else {
                    System.out.println("No se pudo registrar");
                }

            } else {
                System.out.println("No se registro con exito");
            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    public ArrayList<VistaCompra> getRegistros(){
        ArrayList<VistaCompra> vistaCompras = new ArrayList<>();
        try{

            String sql = "select c.compraId,c.numBoleto,c.pagado,c.fechaHora,cli.clienteID,cli.nombre,cli.apellidos,cli.direccion,s.seccionId,s.descripcion,s.precio \n" +
                    "from compra c\n" +
                    "INNER JOIN boleto b on (b.numBoleto = c.numBoleto)\n" +
                    "INNER JOIN seccion s on (b.seccionId = s.seccionId)\n" +
                    "INNER JOIN cliente cli on (c.clienteId = cli.clienteID)";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                 VistaCompra vista = new VistaCompra();
                 vista.setCompraId(rs.getInt("compraId"));
                 vista.setNumBoleto(rs.getInt("numBoleto"));
                 vista.setPagado(rs.getBoolean("pagado"));
                 vista.setFechaHora(rs.getDate("fechaHora"));
                 vista.setClienteID(rs.getInt("clienteID"));
                 vista.setClienteNombre(rs.getString("nombre"));
                 vista.setClienteApellidos(rs.getString("apellidos"));
                 vista.setClienteDireccion(rs.getString("direccion"));
                 vista.setSeccionId(rs.getInt("seccionId"));
                 vista.setSeccionDescripcion(rs.getString("descripcion"));
                 vista.setSeccionPrecio(rs.getFloat("precio"));

                 vistaCompras.add(vista);

            }

        }catch (SQLException ex){
            ex.printStackTrace();
        }

        return vistaCompras;
    }

    public void updateRegistro(Compra compra,Cliente cliente,Seccion seccion){
        try{

            String sql = "UPDATE compra SET pagado = ? WHERE compraId = ?";

            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setBoolean(1,compra.isPagado());
            stmt.setInt(2,compra.getCompraId());
            stmt.execute();

            sql = "UPDATE cliente SET nombre = ?, apellidos = ?, direccion = ? WHERE clienteID=?";
            stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,cliente.getNombre());
            stmt.setString(2,cliente.getApellidos());
            stmt.setString(3,cliente.getDireccion());
            stmt.setInt(4, cliente.getClienteId());
            stmt.execute();

            sql = "UPDATE seccion SET descripcion = ?, precio = ? WHERE seccionId=?";
            stmt = this.connection.prepareStatement(sql);
            stmt.setString(1,seccion.getDescipcion());
            stmt.setFloat(2,seccion.getPrecio());
            stmt.setInt(3,seccion.getSeccionId());
            stmt.execute();

            System.out.println("Actualización con exito");

        }catch (SQLException ex){

            ex.printStackTrace();

        }

    }

    //insertar seccion

}
