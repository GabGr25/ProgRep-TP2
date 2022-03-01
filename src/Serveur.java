import javax.naming.ldap.SortKey;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    private ServerSocket serveurSocket;

    private void enregistrementService(int port){
        try{
            serveurSocket=new ServerSocket(port,4);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Impossible de crée le ServerSoket !");
            System.exit(1);
        }
    }

    private Socket nouvelleConnexion(){
        Socket socket = null;

        try{
            socket=serveurSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Probleme lors de l'attente d'une nouvelle connexion !");
        }
        System.out.println("Nouvelle connexion réalisé ! ");
        return socket;
    }

    public static void main(String[] args) {
        if(args.length!=1){
            System.err.println("Le programme necessite un argument !");
            System.exit(1);
        }
        int monPort= Integer.parseInt(args[0]);
        System.out.println("Numéro de port à utiliser "+monPort);

        Serveur serveur=new Serveur();
        serveur.enregistrementService(monPort);
        Socket socket = new Socket();

    }
}
