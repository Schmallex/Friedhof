package algodat;

import java.util.*;

public class Breitensuche {
    public static void main(String[] args) {
        int[] startint = {0, 8, 0, 0};
        int[] pathint = {3, 1, 6, 7};
        Graph[] graphs = {GraphLesen.FileToGraph("C:/graph8.txt", true), GraphLesen.FileToGraph("C:/graph8.txt", true), GraphLesen.FileToGraph("C:/graph20.txt", true), GraphLesen.FileToGraph("C:/graph20.txt", false)};
        for (int i = 0; i < graphs.length; i++) {
            System.out.print(graphs[i]);
            long start = System.currentTimeMillis();
            DepthBreadthSearch(graphs[i], startint[i]);
            System.out.println(ShortestPath(graphs[i], startint[i], pathint[i]));
            long end = System.currentTimeMillis();
            System.out.println("Took " + (end - start) + " Milliseconds");
            System.out.println();
        }
    }

    /**
     * /**
     * Funktion zur Breitensuche
     * Knoten und ihre Distanz zum Anfangsknoten werden auf der Konsole wiedergegeben.
     * @param graph sei der zu durchsuchende Graph
     * @param startPoint sei der Anfangsknoten
     * @return eine Hashmap die als Keys die Vertexen des Graphen und als Value die jeweilige Tiefe hat
     * @throws IllegalArgumentException wenn der Startpunkt nicht existiert.
     */
    public static HashMap<Vertex, Integer> DepthBreadthSearch(Graph graph, int startPoint) throws IllegalArgumentException {
        if (graph.getVertex(startPoint) == null) {
            throw new IllegalArgumentException("Startpoint doesn't exist.");
        }
        //in die Queue werden die abzuarbeitenden Knoten eingefügt
        Queue<Vertex> q = new LinkedList<>();
        //in die Hashmap werden die bereits besuchten Knoten eingefügt
        HashMap<Vertex,String> visited = new HashMap<Vertex, String>();
        // in die HashMap werden die Knoten mit dazugehöriger Tiefe eingetragen
        HashMap<Vertex, Integer> depth = new HashMap<>();
        Vertex og = graph.getVertex(startPoint);

        depth.put(og, 0);
        q.add(og);
        visited.put(og,"Visited");

        System.out.printf("%-5s %-5s %-5s %-5d %-5s %-5d\n", "Vertex : ", og, " pred: ", 0, "dist:", depth.get(og));
        //solange Queue noch Knoten enthält, wird ein Knoten entfernt und man lässt sich alle Nachbarn ausgeben und fügt sie der Queue hinzu
        while (!q.isEmpty()) {
            Vertex parent = q.remove();
            Collection<Vertex> neighbours = graph.getNeighbours(parent);
                for (Vertex child : neighbours) {
                    if (!visited.containsKey(child)) {
                        depth.put(child, depth.get(parent) + 1);
                        visited.put(child,"Visited");
                        q.add(child);
                        System.out.printf("%-5s %-5s %-5s %-5s %-5s %-5d \n", "Vertex : ", child.toString(), " pred: ", parent, "dist:", depth.get(child));
                    }
                }
            }

        return depth;
    }

    /**
     *
     * @param graph sei der zu durchsuchende Graph.
     * @param startPoint sei der Anfangsknoten.
     * @param endPoint sei der Endknoten.
     * @return eine Liste aus Vertexen die den kürzesten Weg zwischen startPoint und endPoint beschreibt oder null wenn kein Weg vorhanden ist.
     * @throws IllegalArgumentException wenn der Start oder der Endpunkt nicht existiert.
     */
    public static List<Vertex> ShortestPath(Graph graph, int startPoint, int endPoint) throws IllegalArgumentException {
        if (graph.getVertex(startPoint) == null ) {
            throw new IllegalArgumentException("Startpoint doesn't exist");
        }
        if(graph.getVertex(endPoint) == null){
            throw new IllegalArgumentException("Endpoint doesnt exist");
        }
        //in die Queue werden die abzuarbeitenden Knoten eingefügt
        Queue<Vertex> q = new LinkedList<>();
        //in die Hashmap werden die bereits besuchten Knoten eingefügt
        HashMap<Vertex,String> visited = new HashMap<Vertex,String>();
        // in die HashMap werden die Knoten mit dazugehörigen Vorgänger eingetragen
        HashMap<Vertex, Vertex> pred = new HashMap<>();
        Vertex startVertex = graph.getVertex(startPoint);

        q.add(startVertex);
        visited.put(startVertex,"visited");
        boolean found = false;
        //solange Queue noch Knoten enthält oder der Endpunkt gefunden ist, wird ein Knoten entfernt und man fügt alle Nachbarn der Queue hinzu
        while (!q.isEmpty()) {
            Vertex parent = q.remove();
            Collection<Vertex> neighbours = graph.getNeighbours(parent);
                for (Vertex child : neighbours) {
                    if (child.equals(graph.getVertex(endPoint))) {
                        pred.put(child, parent);
                        q.clear();
                        found = true;
                        break;
                    }
                    if (!visited.containsKey(child)) {
                        pred.put(child, parent);
                        visited.put(child,"visited");
                        q.add(child);
                    }
                }
                if (found) {
                    break;
                }

        }
        //Early exit falls kein Weg vorhanden
        if(found ==false){
            return null;
        }
        //in der Liste wird der Pfad zwischen startPunkt und endPunkt eingetragen
        List<Vertex> path = new ArrayList();
        Vertex vertex=graph.getVertex(endPoint);
        //Läuft die Pred Hashmap durch bis der Pfad gefunden ist
        while(vertex!=startVertex){
            path.add(vertex);
            vertex = pred.get(vertex);
            if (vertex == graph.getVertex(startPoint)) {
                path.add(vertex);
                Collections.reverse(path);
                return path;
            }
        }
        return null;
    }
}