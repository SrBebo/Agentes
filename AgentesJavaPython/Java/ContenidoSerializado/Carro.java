
package contenidoSerializado;

import java.io.Serializable;


public class Carro implements Serializable{
    private int model_name, transmission, odometer_value, year_produced,
                    body_type, has_warranty, drivetrain,
                    feature_0, feature_1, feature_2, feature_3, feature_4,
                    feature_5, feature_6, feature_7, feature_8, feature_9;
    private float engine_capacity;

    public Carro(int model_name, int transmission, int odometer_value, int year_produced, float engine_capacity, int body_type, int has_warranty, int drivetrain, int feature_0, int feature_1, int feature_2, int feature_3, int feature_4, int feature_5, int feature_6, int feature_7, int feature_8, int feature_9) {
        this.model_name = model_name;
        this.transmission = transmission;
        this.odometer_value = odometer_value;
        this.year_produced = year_produced;
        this.engine_capacity = engine_capacity;
        this.body_type = body_type;
        this.has_warranty = has_warranty;
        this.drivetrain = drivetrain;
        this.feature_0 = feature_0;
        this.feature_1 = feature_1;
        this.feature_2 = feature_2;
        this.feature_3 = feature_3;
        this.feature_4 = feature_4;
        this.feature_5 = feature_5;
        this.feature_6 = feature_6;
        this.feature_7 = feature_7;
        this.feature_8 = feature_8;
        this.feature_9 = feature_9;
      
    }

    @Override
    public String toString() {
        return "\""+model_name+"\" \""+transmission+"\" \""+odometer_value+"\" \""+year_produced+"\" \""+engine_capacity+"\" \""+body_type+"\" \""+has_warranty+"\" \""+drivetrain+"\" \""+feature_0+"\" \""+feature_1+"\" \""+feature_2+"\" \""+feature_3+"\" \""+feature_4+"\" \""+feature_5+"\" \""+feature_6+"\" \""+feature_7+"\" \""+feature_8+"\" \""+feature_9+"\"";
    }

    
    
}
