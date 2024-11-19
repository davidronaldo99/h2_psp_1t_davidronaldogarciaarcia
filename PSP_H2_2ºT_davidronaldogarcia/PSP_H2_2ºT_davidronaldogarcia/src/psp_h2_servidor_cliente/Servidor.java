package psp_h2_servidor_cliente;

import java.io.*;
import java.net.*;

public class Servidor {
    private AccesoDatos accesoDatos; // Objeto que maneja el acceso al archivo
    private int puerto; // Puerto donde el servidor escuchará

    // Constructor que inicializa el puerto y el objeto AccesoDatos
    public Servidor(int puerto, String rutaArchivo) {
        this.puerto = puerto;
        this.accesoDatos = new AccesoDatos(rutaArchivo); // Inicializamos con la ruta del archivo
    }

    // Método para iniciar el servidor y aceptar conexiones
    public void iniciar() {
        try (ServerSocket servidor = new ServerSocket(puerto)) { // Crear el servidor que escucha en el puerto
            System.out.println("Servidor iniciado en el puerto " + puerto + ". Esperando conexiones...");

            while (true) {
                // Acepta una conexión del cliente
                Socket cliente = servidor.accept();
                System.out.println("Cliente conectado.");

                // Configura el flujo de entrada y salida con el cliente
                BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
                PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);

                // Lee la clave de búsqueda que envió el cliente
                String claveBusqueda = entrada.readLine();
                System.out.println("Buscando información para la clave: " + claveBusqueda);

                // Busca la información usando la clase AccesoDatos
                String resultado = this.accesoDatos.buscarInformacion(claveBusqueda);

                // Enviar el resultado al cliente
                salida.println(resultado); 

                // Imprimir el resultado en consola
                System.out.println("Resultado para '" + claveBusqueda + "': " + resultado);

                // Cerrar la conexión con el cliente
                cliente.close(); 
                System.out.println("Cliente desconectado.");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Si ocurre algún error, se imprime en consola
        }
    }

    public static void main(String[] args) {
        // Cambia la ruta del archivo según donde tengas la información de los libros
        String rutaArchivo = "libros.txt"; // Suponiendo que tienes un archivo con información de libros
        int puerto = 12346; // Puerto donde el servidor escucha
        Servidor servidor = new Servidor(puerto, rutaArchivo);
        servidor.iniciar(); // Inicia el servidor
    }
}
