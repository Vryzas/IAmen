/*

 */
package iamen;

import java.util.HashMap;
import java.lang.Integer;

public class node{
    
    //vars
    private String nodename = "knowhere";
    private boolean gas = false;
    private int lat = 0;
    private int lon = 0;
    private HashMap<node, Integer> vertices = new HashMap<>();
    
    //construct
    public node(String name, boolean a, int lat, int lon){
        nodename = name;
        gas = a;
        this.lat = lat;
        this.lon = lon;
    }
    
    //node tag
    public String getNodename() {
        return nodename;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }
    
    //unnecessary...
    public void setNodename(String nodename) {
        this.nodename = nodename;
    }

    public boolean hasGas() {//gas station?
        return gas;
    }

    public void setGas(boolean gas) {//gas station construction/demolish
        this.gas = gas;
    }
    //defaults maybe useful
    public HashMap<node, Integer> getVertices() {
        return vertices;
    }
    
    public void setVertices(HashMap<node, Integer> vertices) {
        this.vertices = vertices;
    }
    
    public void insertVertice(node a, int b){
        vertices.put(a,b);
    }
    
    //groups the edges names into an array for return
    public node[] getTree(){
        node[] a;
        a = vertices.keySet().toArray(new node[vertices.size()]);        
        return a;
    }
    //returns distance to the node 
    public int getDistance(String name) {
        int ret = 0;
        node z[]= getTree();
        for (node z1 : z) {
            if (z1.getNodename().equals(name)){
                ret = vertices.get(z1);
            } 
        }
        return ret;
    }
        
}
