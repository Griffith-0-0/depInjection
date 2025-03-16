package net.badr.pres;

import net.badr.dao.DaoImpl;
import net.badr.metier.IMetierImpl;

public class presStatic {
    public static void main(String[] args) {
        DaoImpl d = new DaoImpl();
        IMetierImpl metier1= new IMetierImpl();
        metier1.setDao(d); //injection via le setter
        System.out.println("instanciation statique, injection via le setter/ res="+metier1.calcul());
        IMetierImpl metier2= new IMetierImpl(d); //injection via le constructeur
        System.out.println("instanciation statique, injection via le constructeur/ res="+metier2.calcul());
    }
}
