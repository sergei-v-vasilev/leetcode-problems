package algorithms.array;

/**
 * 2924. Find Champion II
 */
public class FindChampionII {
    public int findChampion(int n, int[][] edges) {
        int[] champions = new int[n];
        for(int i = 0; i < edges.length; i++){
            champions[edges[i][1]] = 1;
        }
        int champion=-1;
        for(int i = 0; i < n; i++) {
            if(champion ==-1 && champions[i] == 0){
                champion = i;
            } else if(champion !=-1 && champions[i] == 0) {
                return -1;
            }
        }
        return champion;
    }
}
