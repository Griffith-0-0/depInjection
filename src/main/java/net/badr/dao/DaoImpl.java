package net.badr.dao;

public class DaoImpl implements IDao{

    @Override
    public double getData() {
        System.out.println("Implementation 1 Dao");
        double t=40;
        return t;
    }
}
