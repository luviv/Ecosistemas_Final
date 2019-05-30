package luisvivas.com.example.final_ecosistemas;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Observable;

public class Comunicacion extends Observable implements Runnable {

    private static DatagramSocket socket;
    private InetAddress address;
    private String textico;
    private boolean contador1,contador2,contador3,contador4,contador5;
    private boolean contador6,contador7,contador8,contador9,contador10,contador11;

    private static Comunicacion ref;


    private Comunicacion() {
        textico ="SinTexto";
        contador1 =true; contador2 =true;
        contador6 =true; contador9 =true;
    }

    public static Comunicacion getRef(){
        if(ref==null){
            ref=new Comunicacion() ;
            try {
                socket = new DatagramSocket(5000);
                System.out.println("Servidor iniciado");
            } catch (SocketException e) {
                e.printStackTrace();
            }
            Thread t = new Thread(ref);
            t.start();
        }
        return ref;


    }


//contador 1 -5 son temas ... contador 6 -11 son pruebas
    public String getTextico(){
        return textico;
    }
    public boolean getContadorMem(){
        return contador1;
    }
    public  boolean getContadorPrv(){
        return contador2;
    }
    public  boolean getContadorPra(){
        return contador3;
    }
    public boolean getContadorEmo(){
        return contador4;
    }
    public boolean getContadorPsi(){
        return contador5;
    }

    public  boolean getContadorPM1(){
        return contador6;
    }
    public  boolean getContadorPM2(){
        return contador7;
    }
    public boolean getContadorPM3(){
        return contador8;
    }
    public boolean getContadorPV1(){
        return contador9;
    }
    public boolean getContadorPV2(){
        return contador10;
    }
    public boolean getContadorPV3(){
        return contador11;
    }


    public void recibir() throws IOException {

        byte[] buf = new byte[1024];
        DatagramPacket p = new DatagramPacket(buf, buf.length);
        socket.receive(p);
        String mensaje = new String(p.getData(), 0, p.getLength());
        setChanged();
        notifyObservers(mensaje);
        textico = mensaje;

        clearChanged();
        //System.out.println("Mensaje recibido:" + new String(p.getData()));
        System.out.println("Mensaje recibido:" + textico);

    }

    public void almacenarVariable(){
        String[] indicadortexto = textico.split(": :");
        String indicador = indicadortexto[0];
        System.out.println("Puerta:"+ indicador);
        String numero = indicadortexto[1];
        System.out.println("Personas" +numero);
        if (indicador.equals("mem")==true) {
            if(numero.equals("C")){
                contador1 =false;

            }else{
                contador1 = true;
            }
        }
        if (indicador.equals("prv")==true) {
            if(numero.equals("C")){
                contador2 =false;

            }else{
                contador2 = true;
            }
        }
        if (indicador.equals("pra")==true) {
            if(numero.equals("C")){
                contador3 =false;

            }else{
                contador3 = true;
            }
        }

        if (indicador.equals("emo")==true) {
            if(numero.equals("C")){
                contador4 =false;

            }else{
                contador4 = true;
            }
        }
        if (indicador.equals("psi")==true) {
            if(numero.equals("C")){
                contador5 =false;

            }else{
                contador5 = true;
            }
        }


        //-------PRUEBAS

        if (indicador.equals("PM1")==true) {
            if(numero.equals("C")){
                contador6 =false;

            }else{
                contador6 = true;
            }
        }
        if (indicador.equals("PM2")==true) {
            if(numero.equals("C")){
                contador7 =false;

            }else{
                contador7 = true;
            }
        }
        if (indicador.equals("PM3")==true) {
            if(numero.equals("C")){
                contador8 =false;

            }else{
                contador8 = true;
            }
        }

        if (indicador.equals("PP1")==true) {
            if(numero.equals("C")){
                contador9 =false;

            }else{
                contador9 = true;
            }
        }
        if (indicador.equals("PP2")==true) {
            if(numero.equals("C")){
                contador10 =false;

            }else{
                contador10 = true;
            }
        }
        if (indicador.equals("PP3")==true) {
            if(numero.equals("C")){
                contador11 =false;

            }else{
                contador11 = true;
            }
        }


    }


    public void enviar(final String msj) {

        Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    byte[] buf = msj.getBytes();

                    InetAddress ip = InetAddress.getByName("172.30.148.191");
                    int puerto = 5000; // a quien se lo envío
                    DatagramPacket p = new DatagramPacket(buf, buf.length, ip, puerto);
                    socket.send(p);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        hilo.start();
    }

    @Override
    public void run() {
        while (true) {

            try {
                if(socket!=null) {
                    recibir();
                    almacenarVariable();
                }
                // operación de recepción
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}








