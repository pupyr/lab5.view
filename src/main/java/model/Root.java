package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;

public class Root
{

    private static Root INSTANCE;

    public static Root getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Root();
        }
        return INSTANCE;
    }
    private Date date;
    private LinkedHashMap<Long, Vehicle> vehicle = new LinkedHashMap<>();

    public Date getDate() {
        return date;
    }

    public void setDate( Date date) {
        this.date = date;
    }

    public LinkedHashMap<Long, Vehicle> getRoot() {
        return vehicle;
    }

    public void setRoot( LinkedHashMap<Long, Vehicle> root) {
        this.vehicle = root;
    }

    public void add( Long key,  Vehicle vehicle) {this.vehicle.put(key, vehicle);}

    public String write( int in) {
        StringBuilder s = new StringBuilder();
        int i = 0;
        for ( Long ss : vehicle.keySet()) {
            ++i;
            if (in != 0) {
                s.append("\t <vehicle key=\"").append(ss).append("\"");
            }
            else {
                s.append("\t").append(ss).append(":");
            }
            s.append(vehicle.get(ss).write(in));
            if (i != vehicle.size()) {
                s.append("\n");
            }
        }
        return s.toString();
    }

    public void sorting(boolean b){
        Long lll = null;
        LinkedHashMap<Long, Vehicle> map=new LinkedHashMap<>();
        Root root=getInstance();
        if(!root.getRoot().isEmpty()) {
            ArrayList<Long> arrayList = new ArrayList<>(root.getRoot().keySet());
            Collections.sort(arrayList);
            for (Long l : arrayList) {
                for (Long ll : root.getRoot().keySet()) {
                    if (l.equals(ll)) {
                        lll = ll;
                        break;
                    }
                }
                map.put(l, root.getRoot().get(lll));
                if (!b) {
                    System.out.println("\t"+l+":"+map.get(l).write(0));
                }
            }
            if(b) {
                root.setRoot(map);
            }
        }
    }

}
