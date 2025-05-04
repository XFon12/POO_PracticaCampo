
import java.util.Map;


// Clase principal que demuestra todas las funcionalidades requeridas
public class SistemaCiberseguridadPYME {

    public static void main(String[] args) {
        GestorVulnerabilidades gestor = new GestorVulnerabilidades();

  

        
    }
}

// Clase que gestiona vulnerabilidades (Sobrecarga de métodos + Errores)
class GestorVulnerabilidades {
    

    

    // Validación de CVE
    private boolean validarCVE(String cve) {
        return cve.matches("^CVE-\\d{4}-\\d{4,}$");
    }

    // Muestra vulnerabilidades críticas (Colecciones)
    
}

// Clase para representar una vulnerabilidad
class Vulnerabilidad {
    private String cve;
    private double cvss;
    private String descripcion;

    public Vulnerabilidad(String cve, double cvss, String descripcion) {
        this.cve = cve;
        this.cvss = cvss;
        this.descripcion = descripcion;
    }

    // Getters
    public String getCve() { return cve; }
    public double getCvss() { return cvss; }
    public String getDescripcion() { return descripcion; }
}
