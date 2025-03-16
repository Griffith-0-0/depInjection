package net.badr.pres;

import net.badr.dao.IDao;
import net.badr.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class presDynamic {
    //FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(new File("config"));
        String  doaClassName=sc.nextLine();
        Class cDao = Class.forName(doaClassName);
        IDao dao=(IDao) cDao.newInstance(); // en utilisant constructeur sans para
        String metierClassName=sc.nextLine();
        Class cMetier=Class.forName(metierClassName);
        // en utilisant constructeur avec para
        IMetier metier1= (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
        System.out.println("instanciation dynamique avec const avec para, res="+metier1.calcul());
        // en utilisant constructeur sana para et setter
        IMetier metier2= (IMetier) cMetier.getConstructor().newInstance();
        Method setDao=cMetier.getDeclaredMethod("seDao", IDao.class);
        setDao.invoke(metier2,dao);
        System.out.println("instanciation dynamique avec setter, res="+metier2.calcul());
    }
}
