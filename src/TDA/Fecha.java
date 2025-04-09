package TDA;

public class Fecha {
    /* 
     * 1) PK: clave compuesta día, mes y año. Analice y especifique las operaciones
       2) Implemente especificando en 1a) con tres atributos enteros que representen dia, mes y año por separado.     
     * 3) Implemente el TDA Fecha especificado en 1a) con un único atributo interno String con el formato
     *    “AAAAMMDD” donde AAAA es el año expresado con cuatro dígitos, MM y DD son mes y día
     *    expresados con dos dígitos cada uno.
    */
    private int dia, mes, anio;

    Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // considerar metodo adicion y resta de dias meses y años
    public boolean sumar(int dias) {
		// 

        return true;
    }
    // considerar metodo esFechaValida(Fecha unaFecha): boolean
    // e.g 31/02/2020 no es valida
    // considerar metodo esBisiesto(): boolean
    // considerar un .toString() --> "dd/mm/aaaa"
	  // creo ya hice un tda fecha en desalg revisar!
    
    public boolean esBisiesto() {
        if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", dia, mes, anio);
    }

    
}
