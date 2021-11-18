/*

 */
package iamen;

import java.util.HashMap;
import java.lang.Integer;

public class node {
    
    //vars
    private String nodename = "knowhere";
    private boolean gas = false;
    private HashMap<node, Integer> vertices = new HashMap<>();
    
    public node(String name, boolean a){
        nodename = name;
        gas = a;
    }//construct
    
    //node tag
    public String getNodename() {
        return nodename;
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
    public int getDistance(node name) {
        return vertices.get(name);
    }
    
    
}
