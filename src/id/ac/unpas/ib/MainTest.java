package id.ac.unpas.ib;

import id.ac.unpas.ib.bfs.BreadthFirstSearch;
import id.ac.unpas.ib.dls.DepthLimitedSearch;
import id.ac.unpas.ib.ucs.NodeUCS;
import id.ac.unpas.ib.ucs.UniformCostSearch;

public class MainTest {
    public static void main(String[] args) {
        // Ibukota provinsi
        Node banda_aceh = new Node("Banda Aceh");
        Node medan = new Node("Medan");
        Node padang = new Node("Padang");
        Node pekanbaru = new Node("Pekanbaru");
        Node jambi = new Node("Jambi");
        Node bengkulu = new Node("Bengkulu");
        Node lampung = new Node("Bandar Lampung");
        Node palembang = new Node("Palembang");

        // tetangga ibu kota provinsi
        banda_aceh.addTetangga(medan);
        medan.addTetangga(padang);
        medan.addTetangga(pekanbaru);
        padang.addTetangga(pekanbaru);
        padang.addTetangga(medan);
        padang.addTetangga(jambi);
        pekanbaru.addTetangga(medan);
        pekanbaru.addTetangga(jambi);
        pekanbaru.addTetangga(padang);
        jambi.addTetangga(bengkulu);
        jambi.addTetangga(palembang);
        bengkulu.addTetangga(jambi);
        bengkulu.addTetangga(padang);
        bengkulu.addTetangga(palembang);
        bengkulu.addTetangga(lampung);
        lampung.addTetangga(palembang);
        lampung.addTetangga(bengkulu);
                ;

        // Pencarian BFS
        System.out.println("BFS");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.search(banda_aceh, palembang);
        System.out.println();

        // Pencarian DLS
        System.out.println("DLS");
        DepthLimitedSearch dls = new DepthLimitedSearch();
        dls.setLimit(10);
        dls.search(banda_aceh, palembang);
        System.out.println();

        // node untuk algoritma UCS
        NodeUCS banda_acehUCS = new NodeUCS(banda_aceh, 0);
        NodeUCS medanUCS = new NodeUCS(medan, 200);
        NodeUCS padangUCS = new NodeUCS(padang, 350);
        NodeUCS pekanbaruUCS = new NodeUCS(pekanbaru, 520);
        NodeUCS jambiUCS = new NodeUCS(jambi, 700);
        NodeUCS bengkuluUCS = new NodeUCS(bengkulu, 880);
        NodeUCS lampungUCS = new NodeUCS(lampung, 1050);
        NodeUCS palembangUCS = new NodeUCS(palembang, 1200);

        // tetangga untuk setiap node UCS
        banda_acehUCS.addTetangga(medanUCS);
        medanUCS.addTetangga(padangUCS);
        medanUCS.addTetangga(pekanbaruUCS);
        padangUCS.addTetangga(pekanbaruUCS);
        pekanbaruUCS.addTetangga(jambiUCS);
        jambiUCS.addTetangga(bengkuluUCS);
        bengkuluUCS.addTetangga(lampungUCS);
        lampungUCS.addTetangga(palembangUCS);

        // Panggil algoritma UCS
        System.out.println("UCS");
        UniformCostSearch ucs = new UniformCostSearch();
        ucs.search(banda_acehUCS, palembangUCS);
    }
}
