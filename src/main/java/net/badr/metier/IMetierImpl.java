package net.badr.metier;

import net.badr.dao.IDao;

public class IMetierImpl implements IMetier {
    private IDao dao;

    @Override
    public double calcul() {
        double t=dao.getData();
        double res=t*12;
        return res;
    }
    public IMetierImpl(IDao dao) {
        this.dao=dao;
    }
    public IMetierImpl() {}

    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
