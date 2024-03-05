package org.example;

public class GeolocationPojo {

//    {
//        "name":"ikram",
//            "address":"123 test",
//            "geolocation":{
//        "latitude":"123.455.666.77.8",
//                "longitude":"123.455.34477.8"
//    },
//        "alpha":[
//        "test1",
//                "test2",
//                "test3"


        private String latitude;
        private String longitude;

        public GeolocationPojo(){
//            setLatitude(latitude);
//            setLongitude(longitude);
        }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
