
import java.util.Map;



public class SistemaCiberseguridadPYME {

    public static void main(String[] args) {
        GestorVulnerabilidades gestor = new GestorVulnerabilidades();
        
            // --- Sobrecarga de métodos ---
            gestor.registrarVulnerabilidad("CVE-2023-1234"); 
            gestor.registrarVulnerabilidad("Log4Shell", 10.0, "Vulnerabilidad crítica en Log4j"); 

        
    }
}


class GestorVulnerabilidades {
    private Map<String, Vulnerabilidad> vulnerabilidades = new HashMap<>();
    private PriorityQueue<Vulnerabilidad> colaCriticas = new PriorityQueue<>(
            (v1, v2) -> Double.compare(v2.getCvss(), v1.getCvss())
    );

    //Sobrecarga de metodos
    public void registrarVulnerabilidad(String cve) throws CVEInvalidoException {
        if (!validarCVE(cve)) {
            throw new CVEInvalidoException("Formato de CVE inválido. Use: CVE-AAAA-NNNN");
        }
        Vulnerabilidad vuln = new Vulnerabilidad(cve, 0.0, "Sin descripción");
        vulnerabilidades.put(cve, vuln);
    }    
    public void registrarVulnerabilidad(String nombre, double cvss, String descripcion) {
        if (cvss < 0.0 || cvss > 10.0) {
            throw new IllegalArgumentException("CVSS debe ser entre 0.0 y 10.0");
        }
        String cve = "N/A-" + nombre.toUpperCase();
        Vulnerabilidad vuln = new Vulnerabilidad(cve, cvss, descripcion);
        vulnerabilidades.put(cve, vuln);
        if (cvss >= 9.0) {
            colaCriticas.add(vuln);  
        }
    }
    

    private boolean validarCVE(String cve) {
        return cve.matches("^CVE-\\d{4}-\\d{4,}$");
    }

    
    
}


class Vulnerabilidad {
    private String cve;
    private double cvss;
    private String descripcion;

    public Vulnerabilidad(String cve, double cvss, String descripcion) {
        this.cve = cve;
        this.cvss = cvss;
        this.descripcion = descripcion;
    }

   
    public String getCve() { return cve; }
    public double getCvss() { return cvss; }
    public String getDescripcion() { return descripcion; }
}
