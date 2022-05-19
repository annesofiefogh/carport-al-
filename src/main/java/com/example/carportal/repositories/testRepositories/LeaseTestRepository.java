package com.example.carportal.repositories.testRepositories;

import com.example.carportal.models.Damage;
import com.example.carportal.models.Lease;
import com.example.carportal.repositories.ILeaseRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeaseTestRepository implements ILeaseRepository {
    ArrayList<Lease> arrayList = new ArrayList(Arrays.asList(
            new Lease(1,1,1,100.5, LocalDate.of(1999,12,12),LocalDate.of(2050,12,12),true),
            new Lease(2,2,2,200.5, LocalDate.now(),LocalDate.of(2030,12,12),false),
            new Lease(3,3,3,300.5, LocalDate.of(1940,12,12),LocalDate.of(2025,12,12),true),
            new Lease(4,4,4,400.5, LocalDate.now(),LocalDate.of(2099,12,12),false),
            new Lease(5,5,5,500.5, LocalDate.now(),LocalDate.of(2027,12,12),true),
            new Lease(6,6,6,600.5, LocalDate.now(),LocalDate.of(2055,12,12),true)
    ));
    @Override
    public boolean damageReport(int leaseID, int carID, ArrayList<Damage> listOfDamages) {
        return false;
    }

    @Override
    public ArrayList<Lease> getAllOpenLeases() {
        ArrayList<Lease> listOfOpenLeases = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).isStatus()){
                listOfOpenLeases.add(arrayList.get(i));
            }
        }
        return listOfOpenLeases;
    }

    @Override
    public Object getOneEntity(int ID) {
        return null;
    }

    @Override
    public List getAllEntities() {
        return null;
    }

    @Override
    public boolean create(Object entity) {
        return false;
    }

    @Override
    public boolean update(int id) {
        return false;
    }
}
