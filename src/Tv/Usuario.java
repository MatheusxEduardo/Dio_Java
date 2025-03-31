package Tv;
public class Usuario {
    public static void main (String[] argvs) throws Exception {
        SmartTv smartTv = new SmartTv();
        System.out.println("ligada " + smartTv.ligada);
        System.out.println("Canal "  + smartTv.canal);
        System.out.println("Volume " + smartTv.volume);
        
        smartTv.ligar();
        System.out.println("ligada " + smartTv.ligada);
        
    }
}