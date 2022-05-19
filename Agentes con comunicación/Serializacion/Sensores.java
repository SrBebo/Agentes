
package contenidoSerializado;

import java.io.Serializable;


public class Sensores implements Serializable{
    private String msjag3;
    private String msjag1;
    public Sensores(String msjag3, String msjag1){
        this.msjag1=msjag1;
        this.msjag3=msjag3;
    }
    public Sensores(){
    
    
    }

    public String getMsjag3() {
        return msjag3;
    }

    public void setMsjag3(String msjag3) {
        this.msjag3 = msjag3;
    }

    public String getMsjag1() {
        return msjag1;
    }

    public void setMsjag1(String msjag1) {
        this.msjag1 = msjag1;
    }
