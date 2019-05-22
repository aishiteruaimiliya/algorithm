package unionFInd;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Arrays;
class unionFindImplTest {
    static unionFindImpl union=null;
    @BeforeAll
    public static void init(){
        union=new unionFindImpl(10);
    }
    @AfterEach
    public  void testunion(){
        System.out.println(Arrays.toString(union.data));
    }
    @ParameterizedTest
    @CsvFileSource(numLinesToSkip = 1,resources = "test.csv")
    void union(int p,int q) {
        union.union(p,q);
        System.out.println(union.isConnected(p,q));
    }
}