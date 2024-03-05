package org.example;

import java.util.List;

public class MainPojo {

    private  String name;
    private  String address;

    private GeolocationPojo geo;

    private List<String> alpha;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeolocationPojo getGeo() {
        return geo;
    }

    public void setGeo(GeolocationPojo geo) {
        this.geo = geo;
    }

    public List<String> getAlpha() {
        return alpha;
    }

    public void setAlpha(List<String> alpha) {
        this.alpha = alpha;
    }

    public String asString(){
        return getName()+"\n"+getAddress()+"\n"+getGeo()+"\n"+getAlpha();
    }

//    public MainPojo(String name, String address, GeolocationPojo geo, List<String> alpha){
//        setName(name);
//        setAddress(address);
//        setGeo(geo);
//        setAlpha(alpha);
//
//    }
}
