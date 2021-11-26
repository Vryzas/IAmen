
package iamen;

import java.util.Scanner;
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
    
    //creates the nodes list
    public static void alfaNodes(node[] alfa){
        alfa[0] = new node("Porto - Garagem", true,6,1);
        alfa[1] = new node("Lisboa", true,18,1);
        alfa[2] = new node("Braga", false,3,3);
        alfa[3] = new node("Aveiro", false,10,1);
        alfa[4] = new node("Guimarães", true,4,4);
        alfa[5] = new node("Viana do Castelo", true,2,1);
        alfa[6] = new node("Bragança", false,2,9);
        alfa[7] = new node("Vila Real", true,6,6);
        alfa[8] = new node("Amarante", false,6,4);
        alfa[9] = new node("Póvoa de Varzim", false,4,1);
        alfa[10] = new node("Viseu", true,10,5);
        alfa[11] = new node("Figueira da Foz", false,13,1);
        alfa[12] = new node("Coimbra", true,12,3);
        alfa[13] = new node("Santarém", false,16,4);
        alfa[14] = new node("Guarda", false,10,8);
        alfa[15] = new node("Castelo branco", false,14,8);
        alfa[16] = new node("Évora", true,20,6);
        alfa[17] = new node("Setúbal", false,20,1);
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
    
    /*direct path estimation
    lat = |latA-latB|
    lon = |lonA-lonB|
    lat *40% of 25km + lon *40%30km
    */
    public static int heuristic(node a, node b){
        int lat =(int) ((a.getLat()-b.getLat()) * (0.45*25));
        int lon = (int) (a.getLon()-b.getLon() * (0.45*30));
        if (lat < 0){
            lat = lat * -1;
        }
        if (lon < 0){
            lon = lon * -1;
        }
        return lat+lon;
    }
    
    //next node finder
    public static node findNext(node[] zed, node end){
        int besth = heuristic(zed[0], end);
        int heur;
        node ret = null;
        for (int i = 0; i <zed.length; i++){
            heur = heuristic(zed[i], end);
            if (heur < besth){
                besth = heur;
                ret = zed[i];
            }
        }
        return ret;
    }
 
    /*
        *include a total cost variable
        include an extimated cost variable (total cost + estimation)
        step 1 save alfa[0] vertices to an array with .getTree()
        step 2 find the shortest distance in the vertices
        step 3 replace the array with the next vertice 'vertices'
        step 4 add the distance of the shortest vertice and
        step 5 compare with previous 
        step 6 if shorter step3
        step 7 else return to alfa[0] and go with 2nd shortest vertice
        step 8 go step 3 in 2nd shortest vertice
        */ 
    
    public static void aStar(node[] alfa, String[] path){
        int cam = 0;
        int rout = 0;
        String next = path[cam];//next node to visit
        node[] z = alfa[rout].getTree();//vertices from root node
        node end = alfa[alfa.length-1];//last node of the chosen path
        node nextnode = findNext(z, end);      
    }
    
    public static void main(String[] args) {
        
        Scanner read= new Scanner(System.in);
        
        node alfa[] = new node[18];
        alfaNodes(alfa);      
        alfaInsert(alfa);
        printAlfa(alfa);//coment to disable
        
        System.out.println("Inserir número de paragens: ");
        int a = read.nextInt();//insert the nr of path stops
        String[] path = new String[a];
        for (int i = 0; i < a; i++){
            //loop insert for full path stop names
        }
    }
}
