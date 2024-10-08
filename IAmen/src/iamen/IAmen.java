
package iamen;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Vryzas
 */
public class IAmen {
    
    static node alfa[] = new node[18];
    static van v = new van();
    static ArrayList<vertex> myway = new ArrayList<>();
    /*
    van = 20 "slots"
    1big package = 9
    1 medium package = 4
    1 small package = 1
    max = 1b + 2m + 3s or 1b + 1m  + 7s or 1b + 11s
    4m + 4s or 3m + 8s or 2m + 12s or 1m + 16s
    20s
    */
    
    //creates the nodes list
    public static void alfaNodes(node[] alfa){
        alfa[0] = new node("Porto - Garagem", true,6,1);
        alfa[1] = new node("Lisboa", true,18,1);
        alfa[2] = new node("Braga", false,3,3);
        alfa[3] = new node("Aveiro", false,10,1);
        alfa[4] = new node("Guimaraes", true,4,4);
        alfa[5] = new node("Viana do Castelo", true,2,1);
        alfa[6] = new node("Braganca", false,2,9);
        alfa[7] = new node("Vila Real", false,5,7);
        alfa[8] = new node("Amarante", false,6,5);
        alfa[9] = new node("Povoa de Varzim", false,4,1);
        alfa[10] = new node("Viseu", true,10,6);
        alfa[11] = new node("Figueira da Foz", false,13,1);
        alfa[12] = new node("Coimbra", true,12,3);
        alfa[13] = new node("Santarem", false,16,4);
        alfa[14] = new node("Guarda", false,10,8);
        alfa[15] = new node("Castelo Branco", true,14,8);
        alfa[16] = new node("Evora", true,20,6);
        alfa[17] = new node("Setubal", false,20,1);
    }
    
    //creates the node tree
    public static void alfaInsert(node[] alfa){
        alfa[0].insertVertice(alfa[9],38);
        alfa[0].insertVertice(alfa[2],56);
        alfa[0].insertVertice(alfa[8],61);
        alfa[0].insertVertice(alfa[3],76);
        alfa[1].insertVertice(alfa[11],197);
        alfa[1].insertVertice(alfa[13],80);
        alfa[1].insertVertice(alfa[17],49);
        alfa[1].insertVertice(alfa[16],195);
        alfa[2].insertVertice(alfa[5],62);
        alfa[2].insertVertice(alfa[0],56);
        alfa[2].insertVertice(alfa[4],25);
        alfa[3].insertVertice(alfa[0],76);
        alfa[3].insertVertice(alfa[10],85);
        alfa[3].insertVertice(alfa[12],66);
        alfa[3].insertVertice(alfa[11],72);
        alfa[9].insertVertice(alfa[5],45);
        alfa[9].insertVertice(alfa[4],52);
        alfa[9].insertVertice(alfa[0],38);
        alfa[8].insertVertice(alfa[0],61);
        alfa[8].insertVertice(alfa[4],49);
        alfa[8].insertVertice(alfa[7],40);
        alfa[5].insertVertice(alfa[9],45);
        alfa[5].insertVertice(alfa[2],62);
        alfa[4].insertVertice(alfa[2],25);
        alfa[4].insertVertice(alfa[9],52);
        alfa[4].insertVertice(alfa[8],49);
        alfa[4].insertVertice(alfa[7],85);
        alfa[7].insertVertice(alfa[6],118);
        alfa[7].insertVertice(alfa[4],85);
        alfa[7].insertVertice(alfa[8],40);
        alfa[7].insertVertice(alfa[10],96);
        alfa[10].insertVertice(alfa[3],85);
        alfa[10].insertVertice(alfa[12],92);
        alfa[10].insertVertice(alfa[14],76);
        alfa[10].insertVertice(alfa[7],96);
        alfa[12].insertVertice(alfa[3],66);
        alfa[12].insertVertice(alfa[11],56);
        alfa[12].insertVertice(alfa[13],136);
        alfa[12].insertVertice(alfa[10],92);
        alfa[11].insertVertice(alfa[3],72);
        alfa[11].insertVertice(alfa[12],56);
        alfa[11].insertVertice(alfa[1],197);
        alfa[14].insertVertice(alfa[10],76);
        alfa[14].insertVertice(alfa[15],95);
        alfa[13].insertVertice(alfa[12],136);
        alfa[13].insertVertice(alfa[15],156);
        alfa[13].insertVertice(alfa[1],80);
        alfa[13].insertVertice(alfa[17],117);
        alfa[15].insertVertice(alfa[14],95);
        alfa[15].insertVertice(alfa[13],156);
        alfa[15].insertVertice(alfa[16],195);
        alfa[17].insertVertice(alfa[1],49);
        alfa[17].insertVertice(alfa[13],117);
        alfa[16].insertVertice(alfa[1],132);
        alfa[16].insertVertice(alfa[15],195);
        alfa[6].insertVertice(alfa[7],118);
    }
    
    //prints the tree by node order and distance
    public static void printAlfa(node [] alfa){
        for (node alfa1 : alfa) {
            node[] z = alfa1.getTree();
            System.out.println(alfa1.getNodename() + " tem ligação a:");
            for (node z1 : z) {
                System.out.print(z1.getNodename() + ", fica a " + alfa1.getDistance(z1.getNodename()) + " km");
                if (z1.hasGas()){
                    System.out.println(" e tem abastecimento disponível.");
                } else {
                    System.out.println(".");
                }
            }
            System.out.println("-----");
        }
    }
    
    /*direct path estimation formulae "heuristic()" method
    lat = |latA-latB|
    lon = |lonA-lonB|
    lat *45% of 25km + lon *45% of 30km
    */
    //calculates the heuristic from one node to another
    public static int heuristic(node a, node b){
        int lat = a.getLat() - b.getLat();//latitud value
        int lon = a.getLon() - b.getLon();//longitude value
        if (lat < 0){//executes module of value
            lat = lat * -1;
        }
        if (lon < 0){
            lon = lon * -1;
        }
        lat = lat * 12;
        lon = lon * 14;
        return lat + lon;
    }
    
    //finds the next node in path
    public static node nextVertex(node[] beta, String[] path, node root){
        node ret = new node();//return node
        int tempheur = 200;//temporary heuristic
        for (int i = 0; i < path.length; i++){//path cicle
            for (int j = 0; j < beta.length; j++){//existing nodes cicle
                if (beta[j].getNodename().equals(path[i])){//if node/name match...
                    if (heuristic(root, beta[j]) < tempheur){//estimates h(n)
                        tempheur = heuristic(beta[j],root);//if h(n) < than temp
                        ret = beta[j];//next node in path
                    }
                }
            }
            
        }
        return ret;//returns the node with least distance to root
    }
    
    public static void aStar(node root, String[] path, int cost){
        node[] verlist = root.getTree(); //get vertex list
        node next = nextVertex(alfa, path, root);//next delivery point
        int heur = heuristic(root, next);//initial heuristic
        int tempcost = cost + heur;//temporary cost
        node goTo = new node();//waypoint node
        int a;//debug var
        while (goTo.getNodename().equals("knowhere")){//while no waypoint is found
            for (int i = 0; i < verlist.length; i++){//cicle thru vertexes...
                a = heuristic(verlist[i], next);//estimation value
                if (a <= heur){//to find the smallest cost/heuristic
                    tempcost = cost + heuristic(verlist[i], next);//temporary cost + heuristic
                    heur = heuristic(verlist[i], next);//estimation recalculation
                    goTo = verlist[i];//new waypoint found
                }
            }
            heur = heur + 2;//if estimation is > all vertexes
        }
       /* goTo = theBest(root, next, heur);//autonomy management "solution"
        tempcost = cost + heuristic(goTo, next);
        if (tempcost > v.getGas()){
            if(root.hasGas()){
                v.setGasMax();
            }else{
                node z = goTo;
                goTo = secondBest(root, next, z, heur);
                tempcost = cost + heuristic(goTo, next);
                if (tempcost > v.getGas()){
                    goTo = thirdBest(root, next, heur);
                    tempcost = cost + heuristic(goTo, next);
                }
            }
        }*/
       
        v.setGas(tempcost);//subtracts gas cost
        if (goTo.hasGas()){//if waypoint ha gas
           v.setGasMax();//refuels
        }
        myway.add(new vertex (goTo, v.getGas()));//inserts waypoint
        if (goTo != next){//if waypoint != destination
            aStar(goTo,path,tempcost);//recall method with new root/same path
        }else{
            if (path.length!=1){//if not last point
                path = newPath(path, next);//updates path to remove waypoint 
                aStar(goTo,path,tempcost);//recalls method with new root & path
            }
        }
    }
    
   /* public static node theBest(node a, node b, int heur){
        node d = new node();
        node[] e = a.getTree();
        int h;
        for(int i = 0; i < e.length; i++){
            h = heuristic(e[i],b);
            if(h < heur){
                d=e[i];
            }
        }
        return d;
    }
    
    public static node secondBest(node a, node b, node c, int heur){
        node d = new node();
        node[] e = a.getTree();
        int h;
        for(int i = 0; i < e.length; i++){
            if (e[i]!=c){
                h = heuristic(e[i],b);
                if(h < heur){
                    d=e[i];
                }
            }
        }
        return d;
    }
    public static node thirdBest(node a, node b, int heur){
        node d = new node();
        node[] e = a.getTree();
        int h;
        do{
            for(int i = 0; i < e.length; i++){
                h = heuristic(e[i],b);
                if(e[i].hasGas()){
                    if(h < heur){
                        d=e[i];
                    }
                }
            }
            heur = heur + 10;
        }while(d.getNodename().equals("knowhere"));
        return d;
    }*/
    
    public static String [] newPath(String[] path,node next){
        String[] newpath = new String[path.length-1];
        String remove = next.getNodename();
        int j = 0;
        for (int i = 0; i < path.length; i++){
            if(!path[i].equals(remove)){
                newpath[j] = path[i];
                j++;
            }
        }
        return newpath;
    }
  
    public static void main(String[] args) {
        
        Scanner read= new Scanner(System.in);
        
        alfaNodes(alfa);      
        alfaInsert(alfa);
        //printAlfa(alfa);//uncoment to enable
        
        System.out.println("Inserir número de paragens: ");
        int a = read.nextInt();//insert the nr of path stops
        String[] path = new String[a];
        read.nextLine();
        
        System.out.println("Listar paragens - Introduzir nomes dos locais de entrega: ");
        for (int i = 0; i < a; i++){
            path[i] = read.nextLine();//loop insert for full path stop names
        }
        System.out.println("O seu percurso está a ser calculado.");
        System.out.println("Partida de ");
        System.out.println(alfa[0].getNodename());
        aStar(alfa[0], path, 0);
        if (!myway.isEmpty()){
            for (int i = 0; i < myway.size(); i++){
                System.out.println(myway.get(i).getNodex().getNodename());
                
            }
        }
    }
}
