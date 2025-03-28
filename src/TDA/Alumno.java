package TDA;


/**
 *
 * @author julian.monsalves
 */
public class Alumno {
    int legajo; //legajo PK
    String nombre, apellido, domicilio, usuario, clave;
    char dniTipo;
    int dniNum, telefono;
    

    public Alumno(int legajo) {
        this.legajo = legajo;
        this.nombre = "";
        this.apellido = "";
        this.domicilio = "";
        this.usuario = "";
        this.clave = "";
        this.dniTipo = 'x';
        this.dniNum = -1;
        this.telefono = -1;
    }

    public int getLegajo() {
        return legajo;
    }

    /*public void setLegajo(int legajo) {
        this.legajo = legajo;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // ?
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    // ?
    public char getDniTipo() {
        return dniTipo;
    }

    public void setDniTipo(char dniTipo) {
        this.dniTipo = dniTipo;
    }

    public int getDniNum() {
        return dniNum;
    }

    public void setDniNum(int dniNum) {
        this.dniNum = dniNum;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return "[Legajo: "+this.legajo+", Nombre: "+this.nombre+", Apellido: "+this.apellido+", Domic: "+this.domicilio+", Tipo DNI: "+this.dniTipo+", Num. DNI: "+this.dniNum+", Usuario: "+this.usuario+"]";
    }
    
    
    
}
