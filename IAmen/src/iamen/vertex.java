 
package iamen;

/**
 *
 * @author Vryzas
 */
public class vertex {
    
    private node nodex;
    private int distancex;

    vertex(node a, int b) {
        nodex = a;
        distancex = b;
    }


    public node getNodex() {
        return nodex;
    }

    public void setNodex(node nodex) {
        this.nodex = nodex;
    }

    public int getDistancex() {
        return distancex;
    }

    public void setDistancex(int distancex) {
        this.distancex = distancex;
    }
    
    
    
    
}
