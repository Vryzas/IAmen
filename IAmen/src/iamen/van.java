
package iamen;

public class van {
    private int gas = 100;
    private int space = 20;
    
    public van(){
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = this.gas - gas;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    @Override
    public String toString() {
        return "van{" + "gas=" + gas + ", space=" + space + '}';
    }
    
}