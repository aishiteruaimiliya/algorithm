package unionFInd;

public interface unionFind {
    public int getSize();
    public int find(int p);
    public void union(int q,int p);
    public boolean isConnected(int p,int q);
}
