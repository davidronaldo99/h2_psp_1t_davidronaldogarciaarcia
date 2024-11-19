package psp_h2_servidor_cliente;

import java.io.*;
import java.net.*;

public class Cliente {
    private String direccionServidor; // Dirección del servidor (en este caso, localhost)
    private int puerto; // Puerto del servidor

    // Constructor que inicializa la dirección y el puerto del servidor
    public Cliente(String direccionServidor, int puerto) {
        this.direccionServidor = direccionServidor;
        this.puerto = puerto;
    }

    // Método para solicitar información al servidor
    public void solicitarInfo(String palabraClave) {
        try (Socket socket = new Socket(direccionServidor, puerto);
             BufferedReader entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter salida = new PrintWriter(socket.getOutputStream(), true)) {

            // Envia la palabra clave al servidor
            salida.println(palabraClave);

            // Recibe y muestra la respuesta del servidor
            String respuesta;
            while ((respuesta = entrada.readLine()) != null) {
                System.out.println("Respuesta del servidor: " + respuesta);
            }
        } catch (IOException e) {
            System.out.println("Error al conectar con el servidor: " + e.getMessage());
        }
    }
}
