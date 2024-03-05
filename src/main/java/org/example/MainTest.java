//package org.example;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.testng.annotations.Test;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class MainTest {
//
//    @Test
//    public void printJson(){
//        GeolocationPojo geo = new GeolocationPojo();
//        geo.setLongitude("1234.4545.4.64.645.6");
//        geo.setLatitude("1234.4545.4.64.645.6");
//        MainPojo mp = new MainPojo();
//        mp.setGeo(geo);
//        mp.setAddress("123 Test");
//        mp.setName("Test");
//        String[] a = {"12344555.5453", "1233423.423.43.423"};
//        List<String> vals = new ArrayList<>(Arrays.stream(a).toList());
//        mp.setAlpha(vals);
//        ObjectMapper mapper = new ObjectMapper();
//        try{
//            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mp));
//        }catch (Exception e){e.printStackTrace();}
//    }
//}
