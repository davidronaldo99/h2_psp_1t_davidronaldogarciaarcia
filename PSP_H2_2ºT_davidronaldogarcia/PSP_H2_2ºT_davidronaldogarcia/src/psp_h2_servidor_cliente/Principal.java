package psp_h2_servidor_cliente;

public class Principal {
    public static void main(String[] args) {
        int puerto = 12346; // Puerto donde el servidor escuchará
        String rutaArchivo = "src/datos.txt"; // Ruta del archivo de datos que el servidor usará

        // Crea una instancia del servidor con el puerto y la ruta del archivo
        Servidor servidor = new Servidor(puerto, rutaArchivo);
        servidor.iniciar(); // Inicia el servidor
    }
}
