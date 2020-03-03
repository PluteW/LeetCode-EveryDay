package LeetCode.Graph.worth;

public class LC684_ronguylianjie_200303 {
    public static void main(String[] args) {
        new LC684_ronguylianjie_200303().solution();
    }
    
    /**
     * @Description： 并查集解法  无路径压缩
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 23:24
    */
    public int[] solution() {
        int[][] edges = {{1,2}, {1,3}, {2,3}};
        UF uf=new UF(edges.length);
        for(int[] t:edges){
            if(uf.connected(t[0],t[1]))
                return t;
            uf.union(t[0],t[1]);
        }
        return null;
    }
    class UF{
        int[] arr;
        int[] size;
        UF(int n){
            arr=new int[n+1];
            size=new int[n+1];
            for(int i=1;i<n+1;i++){
                arr[i]=i;
                size[i]=1;
            }
        }
        public int find(int p){
            while(arr[p]!=p){
                arr[p]=arr[arr[p]];
                p=arr[p];
            }
            return p;
        }
        public void union(int p,int q){
            int rootp=find(p);
            int rootq=find(q);
            if(rootp==rootq)
                return;
            if(size[rootp]<size[rootq]){
                arr[rootp]=rootq;
                size[rootq]+=size[rootp];
            }else{
                arr[rootq]=rootp;
                size[rootp]+=size[rootq];
            }
        }
        public boolean connected(int p,int q){
            return find(p)==find(q);
        }
    }
    
    /**
     * @Description：  并查集解法  带路径压缩
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 23:23
    */

    public int[] solution2(int[][] edges) {
        if (edges == null || edges.length == 0) return null;
        int[] parent = new int[1005], ans = new int[0];
        for (int[] edge: edges)     // scan edges
            // ==== if two parts have been connected (the same parent), update the answer =======
            // ==== else connect two parts =====
            if (find(parent, edge[0]) == find(parent, edge[1])) ans = edge;
            else join(parent, edge[0], edge[1]);
        return ans;
    }
    private void join(int[] parent, int a, int b){
        // to make a and b have the same parent
        parent[find(parent, b)] = find(parent, a);
    }
    private int find(int[] parent, int x){
        // 3 conditions below:
        // 1) not init, parent is self, return
        // 2) parent is self, return
        // 3) call find parent's parent
        // (parent[x] = ... => cache for faster query)
        return parent[x] == 0 ? (parent[x] = x) :parent[x] == x ? x : (parent[x] = find(parent, parent[x]));
    }
}
