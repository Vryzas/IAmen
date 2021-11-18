/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package iamen;

/**
 *
 * @author Vryzas
 */
public class IAmen {
    /*
    van = 20 "slots"
    1big package = 9
    1 medium package = 4
    1 small package = 1
    max = 1b + 2m + 3s or 1b + 1m  + 7s or 1b + 11s
    4m + 4s or 3m + 8s or 2m + 12s or 1m + 16s
    20s
    */
    
    public static void main(String[] args) {
        node a = new node("Porto", true);
        node b = new node("Lisboa", false);
        node c = new node("Braga", false);
        node d = new node("Aveiro", false);
        node e = new node("Gaia", false);
        a.insertVertice(b,360);
        a.insertVertice(c,60);
        a.insertVertice(d,59);
        a.insertVertice(e,3);
        node z[]= a.getTree();
        System.out.println(a.getNodename() + " tem ligação a:");
        for (int i = 0; i < z.length; i++){
            System.out.println(z[i].getNodename());
        }
    }
}
