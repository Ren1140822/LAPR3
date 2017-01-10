package lapr.project.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import lapr.project.model.Aircraft;
import lapr.project.model.Airport;
import lapr.project.model.FlightPlan;
import lapr.project.model.Node;
import lapr.project.model.Pattern;
import lapr.project.model.Project;
import lapr.project.model.lists.FlightList;
import lapr.project.utils.StringToSIUnitConverter;

/**
 *
 * @author Flavio Relvas
 */
public class AddFlightPlanController {

    private FlightList fl;
    private FlightPlan flight;
    private Project project;
    
    public AddFlightPlanController(Project project){
        this.project = project;     
        fl = project.getFlightList();
        flight = fl.newFlight();
    }

    public void setData(String name, int minStopTime, String aircraft, String origin, 
            String destination, Object[] technicalStops, Object[] mandatoryWaypoints) {
        List<Object> stops = Arrays.asList(technicalStops);
        List<Object> mand = Arrays.asList(mandatoryWaypoints);
        List<Airport> stopfinal = new LinkedList<>();
        List<Node> mandinal = new LinkedList<>();
        for (Object o : stops){
            Airport a = (Airport) o;
            stopfinal.add(getAirportByString(a.getName()));
        }
        for (Object o : mand){
            Node n = (Node) o;
            mandinal.add(getNodeByString(n.getId()));
        }
        flight.setFlightDesignator(name);
        flight.setMinStopTime(minStopTime);
        flight.setAircraft(getAircraftByString(aircraft));
        flight.setOrigin(getAirportByString(origin));
        flight.setDestination(getAirportByString(destination));
        flight.setTechnicalStops(stopfinal);
        flight.setMandatoryWaypoints(mandinal);
    }

    public boolean saveFlightPlan() {
        return flight.validate() && fl.saveFlight(flight);
    }
    
    /**
     * Gets the aircraft list of active project
     * @return list of available aircrafts
     */
    public List<Aircraft> getAircraftsList(){
        return project.getAircraftList().getAircraftList();
    }
    
    /**
     * Gets the airport list of active project
     * @return list of available airports
     */
    public List<Airport> getAirportList(){
        return project.getAirportList().getAirportList();
    }
    
    /**
     * Gets the node list of active project
     * @return list of nodes
     */
    public List<Node> getNodeList(){
        return project.getAirNetwork().getNodeList();
    }
    
    private Aircraft getAircraftByString(String id){
        return project.getAircraftList().getAircraftByString(id);
    }
    
    private Airport getAirportByString(String id){
        return project.getAirportList().getAirportByString(id);
    }
    
    private Node getNodeByString(String id){
        return project.getAirNetwork().getNodeByString(id);
    }
    
    public boolean pattern(File ficheiro){
        try {
            Scanner fInput = new Scanner(ficheiro);  
            
            String[] altitude= fInput.nextLine().split(","); 
            String[] vclimb = fInput.nextLine().split(",");              
            String[] vdesc = fInput.nextLine().split(",");
            
            int count=2;
            String s = altitude[1];
            if(s.contains("ft")){
                while (altitude.length > count){
                    double alt = StringToSIUnitConverter.length(altitude[count].trim());
                    double vc = Double.parseDouble(vclimb[count].trim());
                    double vd = Double.parseDouble(vdesc[count].trim());

                    Pattern p = new Pattern(alt, vc, vd);                
                    flight.getListPattern().add(p);            

                    count++;
                }
                fInput.close();
                return true;
                
            }else{
                while (altitude.length > count){
                    double alt = Double.parseDouble(altitude[count].trim());
                    double vc = Double.parseDouble(vclimb[count].trim());
                    double vd = Double.parseDouble(vdesc[count].trim());

                    Pattern p = new Pattern(alt, vc, vd);                
                    flight.getListPattern().add(p);            

                    count++;
                }
                fInput.close();
                return true;
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Não foi encontrado ficheiro. Erro: " + ex);
            return false;
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Erro ao carregar ficheiro => ficheiro danificado. Erro: " + e);
            return false; 
         }
        
    }
}
