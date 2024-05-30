package miCrud;

public class Cine {

    // atributos

    private int idCine = -1;
    private String direccionCine = null;
    private String nombreCine = null;

    // constructor

    public Cine(String direccion, String nombreCine) {
        this.direccionCine = direccion;
        this.nombreCine = nombreCine;
    }

    // getters y setters

    public int getIdCine() {
        return idCine;
    }

    public void setIdCine(int idCine) {
        this.idCine = idCine;
    }

    public String getDireccion() {
        return direccionCine;
    }

    public void setDireccion(String direccion) {
        this.direccionCine = direccion;
    }

    public String getNombreCine() {
        return nombreCine;
    }

    public void setNombreCine(String nombreCine) {
        this.nombreCine = nombreCine;
    }

}
