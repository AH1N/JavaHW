package sem4;

public class L4 {
    public static void main(String[] args) {

        Mapa <Integer, String> mapa = new Mapa<>();
        System.out.println(mapa.put(1, "1"));
        System.out.println(mapa.put(2, "2"));
        System.out.println(mapa.get(2) + " это значение нода изначальное ");

        System.out.println(mapa.put(3, "3"));
//        System.out.println(mapa.put(4, "4"));
//        System.out.println(mapa.put(17, "F+1"));
//        System.out.println(mapa.put(18, "F+2"));
//        System.out.println(mapa.put(33, "F+21"));
//        System.out.println();
        mapa.replace(2,"15");
        System.out.println(mapa.get(2) + " это нода перезаписанная");
        System.out.println(mapa.size());

        System.out.println(mapa.contains(2,"2"));
        System.out.println(mapa.contains(2,"15"));
        System.out.println(mapa.contains(176,"1"));
        System.out.println(mapa.contValue("15"));
        System.out.println(mapa.contValue("15rthnt"));
//        System.out.println(mapa.get(106));
//        System.out.println(mapa.get(33));
//        System.out.println(mapa.get(17));
//        System.out.println();
//
//        System.out.println(mapa.remove(106));
//        System.out.println(mapa.remove(17));
//
//        System.out.println();

//

    }
}