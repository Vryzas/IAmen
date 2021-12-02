/*

 */
package iamen;


import java.util.ArrayList;

public class node{
    
    //vars
    private String nodename = "knowhere";
    private boolean gas = false;
    private int lat = 0;
    private int lon = 0;
    private ArrayList<vertex> vertices = new ArrayList<>();

    public node() {
    }
          
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
    public ArrayList<vertex> getVertices() {
        return vertices;
    }
    
    public void setVertices(ArrayList<vertex> vertices) {
        this.vertices = vertices;
    }
    
    public void insertVertice(node a, int b){
        vertex c = new vertex(a, b);
        vertices.add(c);
    }
    
    //groups the edges names into an array for return
    public node[] getTree(){
        node[] a = new node[vertices.size()];
        int j = 0;
        for (int i = 0; i < vertices.size(); i++){
            if ( vertices.get(i) != null){
                a[j] = vertices.get(i).getNodex();
                j++;
            }
        }
        return a;
    }
    
    //returns distance to the node 
    public int getDistance(String name) {
        int ret = 0; 
        for (int i = 0; i < vertices.size(); i++){
            if ( vertices.get(i) != null){
                if(name.equals(vertices.get(i).getNodex().getNodename())){
                    ret = vertices.get(i).getDistancex();
                }
            }
        }
        return ret;
    }
        
}

