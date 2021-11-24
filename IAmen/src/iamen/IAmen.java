
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
    public static void alfaNodes(node[] alfa){//creates the nodes list
        alfa[0] = new node("Porto - Garagem", true);
        alfa[1] = new node("Lisboa", true);
        alfa[2] = new node("Braga", false);
        alfa[3] = new node("Aveiro", false);
        alfa[4] = new node("Guimarães", true);
        alfa[5] = new node("Viana do Castelo", true);
        alfa[6] = new node("Bragança", false);
        alfa[7] = new node("Vila Real", true);
        alfa[8] = new node("Amarante", false);
        alfa[9] = new node("Póvoa de Varzim", false);
        alfa[10] = new node("Viseu", true);
        alfa[11] = new node("Figueira da Foz", false);
        alfa[12] = new node("Coimbra", true);
        alfa[13] = new node("Santarém", false);
        alfa[14] = new node("Guarda", false);
        alfa[15] = new node("Castelo branco", false);
        alfa[16] = new node("Évora", true);
        alfa[17] = new node("Setúbal", false);
    }
    public static void alfaInsert(node[] alfa){//creates the node tree
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
    
    public static void printAlfa(node [] alfa){//prints the tree by node order and distance
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
    
    public static void aStar(node [] alfa){
        /*
        step 1 save alfa[0] vertices to an array with .getTree()
        step 2 find the shortest distance in the vertices
        step 3 replace the array with the next vertice 'vertices'
        step 4 add the distance of the shortest vertice and
        step 5 compare with previous 
        step 6 if shorter step3
        step 7 else return to alfa[0] and go with 2nd shortest vertice
        step 8 go step 3 in 2nd shotest vertice
        */
    }
    
    public static void main(String[] args) { 
        node alfa[] = new node[18];
        alfaNodes(alfa);      
        alfaInsert(alfa);
        printAlfa(alfa);
    }
}
