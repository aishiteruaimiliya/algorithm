package unionFInd;

public class unionFindImpl implements unionFind {
    int []data=null;
    public unionFindImpl(int size){
        data=new int[size];
        for (int i=0;i<size;i++){
            data[i]=i;
        }
    }
    @Override
    public int getSize() {
        return data.length;
    }

    @Override
    public int find(int p) {
        if(p<0||p>getSize()) throw new  IllegalArgumentException();
        if(data[p]==p) return p;
        data[p]=find(data[p]);
        return data[p];
    }

    @Override
    public void union(int q, int p) {
        int m=find(q);
        int n=find(p);
        if(m==n) return;
        data[n]=m;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
}
