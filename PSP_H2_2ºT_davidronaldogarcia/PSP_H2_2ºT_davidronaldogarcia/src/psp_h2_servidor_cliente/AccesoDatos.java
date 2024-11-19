package psp_h2_servidor_cliente;
import java.io.*;

public class AccesoDatos {

    private String rutaArchivo; // Ruta al archivo que contiene la información de los libros

    // Constructor que inicializa la ruta del archivo
    public AccesoDatos(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    // Método que busca información sobre libros basándose en una clave de búsqueda
    public String buscarInformacion(String claveBusqueda) {
        StringBuilder resultado = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                if (linea.toLowerCase().contains(claveBusqueda.toLowerCase())) {
                    resultado.append(linea).append("\n"); // Si la línea contiene la clave, la añadimos al resultado
                }
            }
        } catch (IOException e) {
            return "Error al leer el archivo.";
        }

        // Si no se encontró ninguna coincidencia
        if (resultado.length() == 0) {
            return "No se encontraron libros con la clave: " + claveBusqueda;
        }

        return resultado.toString(); // Devuelve todas las líneas que contienen la clave
    }
}
