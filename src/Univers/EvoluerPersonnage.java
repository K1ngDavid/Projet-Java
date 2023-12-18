//package Univers;
//
//import java.lang.reflect.Constructor;
//import java.lang.reflect.InvocationTargetException;
//
//public class EvoluerPersonnage<T extends Personnage> {
//
//    T perso;
//
//    public static <P extends Personnage, T extends Personnage> Personnage EvoluerPersonnage(P p, Class<T> classePersonnage, Object... params) {
//        try {
//            // Obtenez le constructeur avec les types de paramètres correspondants
//            Class<?>[] paramTypes = new Class<?>[params.length];
//            for (int i = 0; i < params.length; i++) {
//                paramTypes[i] = params[i].getClass();
//            }
//            Constructor<T> constructor = classePersonnage.getDeclaredConstructor(paramTypes);
//
//            // Créez une nouvelle instance en passant les paramètres requis
//            T t = constructor.newInstance(params);
//            return t.setPersonnage(p);
//        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
//            e.printStackTrace();
//            return p;
//        }
//    }
//}
