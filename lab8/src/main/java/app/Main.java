package app;import app.DAO.DAOClass;import app.DAO.Data;import app.entities.InhabitantType;import app.entities.Region;import app.entities.Weather;import java.sql.SQLException;import java.time.LocalDate;import java.util.ArrayList;public class Main {    public static void main(String[] args) throws SQLException, ClassNotFoundException {        Data data = new DAOClass();        data.openConnection();        java.util.Date now = new java.util.Date();        java.sql.Date date = new java.sql.Date(now.getTime());        /*        Region region = new Region();        region.setName("Minsk");        region.setArea(4113);        region.setWeather(new Weather(date,41,12));        region.setInhabitantType(new InhabitantType("rus","Russian"));        data.addRegion(region);        */        System.out.println("\nИнфа о регионах");        ArrayList<Region> regions = data.getRegionsByName("Minsk");        for (Region r: regions) {            System.out.println(r.toString());        }        System.out.println("\nДаты, когда в регионе Minsk был влажность > 80 и температура < 0");        for (Region r: regions) {            if(r.getWeather().getTemperature() <0 && r.getWeather().getPrecipitation() > 0)                System.out.println(r.toString());        }        System.out.println("\nИнфо о погоде за пошедшую неделю в регионах, где жители общаются на белорусском языке");        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);        for (Region r: regions) {            if(r.getInhabitantType().getLanguage().equals("Belorussian") && r.getWeather().getDate().toLocalDate().isAfter(sevenDaysAgo))                System.out.println(r.toString());        }        System.out.println("\nСредняя температура за пошедшую неделю в регионах, где площадь меньше 445");        int avg =0;        int i=0;        for (Region r: regions) {            if(r.getArea() < 445  && (r.getWeather().getDate().toLocalDate().isAfter(sevenDaysAgo))){                System.out.println(r.toString());                avg+=r.getWeather().getTemperature();                i++;            }        }        if(i != 0)            System.out.println("\nСредняя температура = "+avg/i);        else            System.out.println("Нету таких регионов");        data.closeConnection();    }}