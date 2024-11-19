package psp_h2_servidor_cliente;

public class PruebaCliente {
    public static void main(String[] args) {
        String direccionServidor = "localhost"; // Dirección del servidor (localhost significa que está en el mismo equipo)
        int puerto = 12346; // Puerto donde el servidor está escuchando

        // Crea el cliente y enviar una solicitud con la palabra clave
        Cliente cliente = new Cliente(direccionServidor, puerto);
        cliente.solicitarInfo("Java"); // Palabra clave para buscar en el archivo
    }
}

